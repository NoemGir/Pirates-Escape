package boundary.graphics;

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

/*
 *  Va appeler des methodes implementés dans FunctionnalKernelAdapter
 * appel servir IBoundary codé avec les services de IPirate ?
 *
 *Le contrôleur de dialogue gère le séquencement des entrées/sorties et agit comme médiateur
 *entre l’interface du noyau fonctionnel et la présentation
 *
 * IHM
 */
public class Dialog implements IPirates {
    
    private FunctionnalKernelAdapter adapter;     
    
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
        movablePawn.activate();
        
        rightDestination = (CasePanel) gridModel.getGridPanel().getComponent(box);
        rightDestination.putGreenBorder();
    }
    
    @Override
    public void movePirateAuto(int idNewPirate, int box){
        slidingPawn.slidePawnToBox(listPiratePawn.get(idNewPirate), gridModel.getGridPanel().getComponent(box));
        listPiratePawn.get(idNewPirate).setBox(gridModel.getGridPanel().getComponent(box));
    }
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
    
    public int getDiceResult(int idDice){
        return adapter.getNumberOnDice(idDice);
    }
    
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

    @Override
    public String toString() {
        return "Dialog{" + "adapter=" + adapter + ", listPirateFace=" + listPirateFace + ", listPiratePawn=" + listPiratePawn + ", listPirateHealth=" + listPirateHealth + ", diceCouple=" + diceCouple + ", gridModel=" + gridModel + ", mainFrame=" + mainFrame + ", idPirate=" + idPirate + ", slidingPawn=" + slidingPawn + ", movablePawn=" + movablePawn + ", rightDestination=" + rightDestination + ", nbDiceRunning=" + nbDiceRunning + '}';
    }

}
