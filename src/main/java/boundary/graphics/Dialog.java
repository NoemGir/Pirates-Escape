package boundary.graphics;

import boundary.GraphicsUtils;
import boundary.graphics.personalizedComponents.CasePanel;
import boundary.graphics.personalizedComponents.PirateFace;
import boundary.graphics.personalizedComponents.DiceCouple;
import boundary.graphics.personalizedComponents.GridModel;
import boundary.graphics.personalizedComponents.HealthBar;
import boundary.graphics.personalizedComponents.MainFrame;
import boundary.graphics.personalizedComponents.PiratePawn;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JLayeredPane;

/**
* Le Dialog s'occupe de gérer les liens entre les différentes composants graphiques, et le Noyau fonctionnel
* 
* @author Noémie GIREAUD
* @author Robin MOUNIER
*/
public class Dialog implements IPirates {
    
    private IFunctionnalKernel adapter;     
    
    private List<PirateFace> listPirateFace = new ArrayList<>();
    private List<PiratePawn> listPiratePawn = new ArrayList<>();
    private List<HealthBar> listPirateHealth = new ArrayList<>();
    private DiceCouple diceCouple;
    private GridModel gridModel;
    private MainFrame mainFrame;
    
    private int idPirate;
    
    private SlidingPawn slidingPawn = new SlidingPawn();
    private PiratePawn movablePawn;
    private CasePanel rightDestination;
    
    private int nbDiceRunning = 0;

    public Dialog(FunctionnalKernelAdapter adapter) {
        this.adapter = adapter;
        slidingPawn.setDialog(this);
    }
    
    @Override
    public void startGame() {
        rightDestination = (CasePanel) gridModel.getGridPanel().getComponent(0);
        
        for(PiratePawn pawn : listPiratePawn){
            pawn.setBox(rightDestination);
            pawn.moveTo(GraphicsUtils.computeLocationPawnInCase(rightDestination));
        }    
        diceCouple.setEnabled(false);
        mainFrame.showMainFrame();
    }
    
    @Override
    public void endGame() {
        mainFrame.dispose();
    }

    @Override
    public String askName(int idPirate) {
        Icon icon = GraphicsUtils.getIcon(listPirateFace.get(idPirate).getImageName()+".jpg");
        String name = mainFrame.popUpAskName(icon);
        if(name != null && !name.equals("")){
            System.out.println("nom donné = '" + name + "'");
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
            p.ChangeImage();
        
        JLayeredPane layeredPaneGrid = gridModel.getjLayeredPane1();
        layeredPaneGrid.setLayer(listPiratePawn.get(idPirate), javax.swing.JLayeredPane.PALETTE_LAYER);
        layeredPaneGrid.setLayer(listPiratePawn.get(idPirate), javax.swing.JLayeredPane.MODAL_LAYER);
        diceCouple.setDicesPlayer();
        idPirate = idNewPirate;
    }
    
    @Override
    public void movePirate(int idNewPirate, int box){
        movablePawn = listPiratePawn.get(idNewPirate);
        
        rightDestination = (CasePanel) gridModel.getGridPanel().getComponent(box);
        rightDestination.putGreenBorder();
    }
    
    /**
     * Une fois un pion arrivé sur une case, vérifie si c'est la case de destination voulu
     */
    public void verifyCaseMove(){
        Component arrivedCase = gridModel.getGridPanel().getComponentAt(movablePawn.getLocation());
        movablePawn.setBox(arrivedCase);
        if(arrivedCase.equals(rightDestination)){
            movablePawn = null;
            rightDestination.putBlackBorder();
            adapter.moveFinished();
            diceCouple.getButton().setEnabled(true);
        }
        else{
            System.out.println("mauvaise destination");
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
            slidingPawn.slidePawnToBox(movablePawn, gridModel.getGridPanel().getComponentAt(point));
        }
    }

    @Override
    public void activateThrowDice() {
        diceCouple.setEnabled(true);
        nbDiceRunning = 2;
    }

    @Override
    public void desactivateThrowDice() {
            diceCouple.setEnabled(false);
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
        nbDiceRunning -= 1;
        if(nbDiceRunning == 0){
            adapter.diceFinished();
        }
    }

    @Override
    public void display(String message) {
        String existingText = mainFrame.getText();
        String newDisplay = existingText + "\n" + message;
        mainFrame.setText(newDisplay);
    }

    @Override
    public void changeHeart(int idNewPirate, int hp) {
        listPirateHealth.get(idNewPirate).repaintHearts(hp);
    }
    
    public void setDiceCouple(DiceCouple diceCouple) {
        this.diceCouple = diceCouple;
    }

    public void setGridModel(GridModel gridModel) {
        this.gridModel = gridModel;
    }

    public void setGameFrame(MainFrame gameFrame) {
        this.mainFrame = gameFrame;
    }
    
    public void addPirateFace(PirateFace pirateFace){
        listPirateFace.add(pirateFace);
    }
    
    public void addPiratePawn(PiratePawn piratePawn){
        listPiratePawn.add(piratePawn);
    } 
    
    public void addPirateHealth(HealthBar healthBar){
        listPirateHealth.add(healthBar);
    }

}
