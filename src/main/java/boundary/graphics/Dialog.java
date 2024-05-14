package boundary.graphics;

import boundary.GraphicsUtils;
import boundary.graphics.personalizedComponents.CasePanel;
import boundary.graphics.personalizedComponents.PirateFace;
import boundary.graphics.personalizedComponents.DiceCouple;
import boundary.graphics.personalizedComponents.GridModel;
import boundary.graphics.personalizedComponents.HealthBar;
import boundary.graphics.personalizedComponents.MainPanel;
import boundary.graphics.personalizedComponents.GameFrame;
import boundary.graphics.personalizedComponents.PiratePawn;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
* Le Dialog s'occupe de gérer les liens entre les différentes composants graphiques, et le Noyau fonctionnel
*
* @author Noémie GIREAUD
* @author Robin MOUNIE
*/
public class Dialog implements IPirates {

    private IFunctionnalKernel adapter;
    
    /**
     * Des listes sont utilisées pour contenir l'ensembles des têtes / pions et bar de vies des pirates pour 
     * permettre la possibilités d'avoir plus de 2 joueurs dans une partie
     */
    private List<PirateFace> listPirateFace = new ArrayList<>();
    private List<PiratePawn> listPiratePawn = new ArrayList<>();
    private List<HealthBar> listPirateHealth = new ArrayList<>();
    private DiceCouple diceCouple;
    private GridModel gridModel;
    private MainPanel mainPanel;
    private GameFrame gameFrame;

    private int idPirate;

    private PiratePawn movablePawn;
    private CasePanel rightDestination;

    private int nbDiceRunning;
    
    
    /** Créer une nouvelle instance de la classe Dialog
     * 
     * @param adapter l'adaptateur fonctionnel
     */
    public Dialog(FunctionnalKernelAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void startGame() {
        nbDiceRunning = 0;
        JPanel gridPanel = gridModel.getGridPanel();
        mainPanel.setText("");
        for(HealthBar bar : listPirateHealth){
            bar.repaintHearts(5);
        }
        rightDestination = (CasePanel) gridPanel.getComponent(0);
        displayGridImage();
        for(PiratePawn pawn : listPiratePawn){
            System.out.println("PAWN");
            pawn.setBox(rightDestination);
            pawn.moveTo(GraphicsUtils.computeLocationPawnInCase(rightDestination));
        }
        for(int i = 0; i < gridPanel.getComponentCount(); i++){
            ((CasePanel) gridPanel.getComponent(i)).putBlackBorder();
        }
        diceCouple.setEnabled(false);
        gameFrame.showMainFrame();
        changePirate(0);
        GraphicsUtils.playSound("/main_sound.wav", -25.0f, -1);
    }

    @Override
    public void endGame(int idPirate) {
        if(idPirate < 0){
            GraphicsUtils.playSound("/genocide_end.wav", -25.0f, -1);
        }
        else{
            GraphicsUtils.playSound("/winner_end.wav", -25.0f, -1);
        }
        display("Voulez-vous rejouer ?");
    }

    @Override
    public String askName(int idPirate) {
        Icon icon = GraphicsUtils.getIcon(listPirateFace.get(idPirate).getImageName()+".jpg");
        String name = gameFrame.popUpAskName(icon);
        if(name != null && !name.equals("")){
            display("Nom du pirate " + idPirate + " : " + name);
            return name;
        }
        else{
            System.out.println("Le nom donné est incorrect");
            System.exit(1);
            return null;
        }
    }

    @Override
    public void changePirate(int idNewPirate) {
        for(PirateFace p : listPirateFace)
            p.changeImageColor();

        JLayeredPane layeredPaneGrid = gridModel.getjLayeredPane1();
        layeredPaneGrid.setLayer(listPiratePawn.get(idPirate), javax.swing.JLayeredPane.PALETTE_LAYER);
        layeredPaneGrid.setLayer(listPiratePawn.get(idPirate), javax.swing.JLayeredPane.MODAL_LAYER);
        diceCouple.setDicesPlayer(idNewPirate);
        idPirate = idNewPirate;
    }

    @Override
    public void movePirate(int idNewPirate, int box){
        movablePawn = listPiratePawn.get(idNewPirate);
        rightDestination = (CasePanel) gridModel.getGridPanel().getComponent(box);
        rightDestination.putGreenBorder();
    }

    @Override
    public void movePirateAuto(int idNewPirate, int box){
        gridModel.setResetPawnEnabled(false);
        mainPanel.enableRestart(false);
        PiratePawn pawn = listPiratePawn.get(idNewPirate);
        pawn.slide(gridModel.getGridPanel().getComponent(box));
    }
    
    /**
     * Affiche sur chaque case de la grille son image associée
     */
    public void displayGridImage(){
        LinkedList<String> list = adapter.getCaseImageLinks();
        for(int i = 0 ;i < 30 ;i++)
        {
           CasePanel box = (CasePanel) this.gridModel.getGridPanel().getComponent(i);
           box.setBoxImage(list.get(i));
                
        }
    }
    
    /**
     * Une fois un pion arrivé sur une case, vérifie si la case d'arrivée correspond bien la case de destination voulu
     */
    public void verifyCaseMove(){
        gridModel.setResetPawnEnabled(true);
        mainPanel.enableRestart(true);
        if(movablePawn != null){
            Component arrivedCase = gridModel.getGridPanel().getComponentAt(movablePawn.getLocation());
            if(arrivedCase.equals(rightDestination)){
                movablePawn = null;
                rightDestination.putBlackBorder();
                adapter.moveFinished();
            }
            else{
                System.out.println("mauvaise destination");
            }
        }
        else{
            adapter.moveEffectFinished();
        }
    }

    /**
    * EventHandler qui s'active lorsque la souris est appuyée sur la grille.
    * Si un pion peut bouger, celui-ci va glisser jusqu'à la case sur lequel le joueur a cliqué
    *
    * @param point Les coordonnées sur lesquelles la souris a cliqué
    */
    public void eventMousePressedGrid(Point point) {
        if(movablePawn != null){
            gridModel.setResetPawnEnabled(false);
            mainPanel.enableRestart(false);
            movablePawn.setBox(null);
            movablePawn.slide(gridModel.getGridPanel().getComponentAt(point));
        }
    }

    @Override
    public void activateThrowDice() {
        diceCouple.getButton().setEnabled(true);
        nbDiceRunning = 2;
    }

    /**
    * Récupère le nombre inscrit sur le dé identifié
    *
    * @param idDice l'identificateur du dé
    * @return le nombre inscrit sur le dés identifié
    */
    public int getDiceResult(int idDice){
        return adapter.getNumberOnDice(idDice);
    }

    /**
    * Indique a l'adaptateur Fonctionnel quand les deux dés on terminés de tourner
    */
    public void diceFinished(){
        if(nbDiceRunning != 0){
            nbDiceRunning -= 1;
            if(nbDiceRunning == 0){
                adapter.diceFinished();
            } 
        }
    }

    @Override
    public void display(String message) {
        String existingText = mainPanel.getText();
        String newDisplay = existingText + message + "\n";
        mainPanel.setText(newDisplay);
    }

    @Override
    public void changeHeart(int idNewPirate, int hp) {
        HealthBar bar = listPirateHealth.get(idNewPirate);
        if(bar.getHearts() > hp){
            GraphicsUtils.playSound(bar.getSoundDamage(), 5.0f, 0);
            display("Aïe ! Le pirate " + adapter.getPirateName(idNewPirate) + " perd " + (bar.getHearts() - hp) + " PV...");
        }
        else{
            if(bar.getHearts() < hp){
                GraphicsUtils.playSound(bar.getSoundHealing(), 5.0f, 0);
                display("Un miracle se produit ! le pirate " + adapter.getPirateName(idNewPirate) + " gagne " + (hp - bar.getHearts()) + " PV !!" );
            }
        }
        bar.repaintHearts(hp);
    }
    
    /**
     * Permet de relancer une partie
     */
    public void playAgain(){
        adapter.playAgain();
    }
    
    /**
     * Arrète le jeu
     * 
     */
    public void stop(){
        System.exit(0);
    }

    /**
     * Définie le couple de dés
     * 
     * @param diceCouple 
     */
    public void setDiceCouple(DiceCouple diceCouple) {
        this.diceCouple = diceCouple;
    }

    /**
     * Défini la grille 
     * @param gridModel 
     */
    public void setGridModel(GridModel gridModel) {
        this.gridModel = gridModel;
    }

    /**
     * Défini la Frame principale
     * 
     * @param gameFrame 
     */
    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    
    /**
     * Défini mainPanel
     * 
     * @param mainPanel
     */
    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    /**
     * ajoute une tête de pirate au dialog
     * 
     * @param pirateFace 
     */
    public void addPirateFace(PirateFace pirateFace){
        listPirateFace.add(pirateFace);
    }

    /**
     *  ajoute un pion de pirate au dialog
     * 
     * @param piratePawn 
     */
    public void addPiratePawn(PiratePawn piratePawn){
        listPiratePawn.add(piratePawn);
        piratePawn.setDialog(this);
    }

    /**
     * ajoute une bar de vie de pirate au dialog
     * 
     * @param healthBar 
     */
    public void addPirateHealth(HealthBar healthBar){
        listPirateHealth.add(healthBar);
    }
}
