package boundary.graphics;

import boundary.IPirates;
import boundary.graphics.personalizedComponents.CasePanel;
import boundary.graphics.personalizedComponents.PirateFace;
import boundary.graphics.personalizedComponents.DiceCouple;
import boundary.graphics.personalizedComponents.GridModel;
import boundary.graphics.personalizedComponents.HealthBar;
import boundary.graphics.personalizedComponents.MainFrame;
import boundary.graphics.personalizedComponents.PiratePawn;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

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
    
    private PiratePawn movablePawn;
    private CasePanel rightCase;
    private Timer timerY = new Timer(10, (ActionEvent e) -> {moveY(e);});
    private Timer timerX = new Timer(10, (ActionEvent e) -> {moveX(e);});
    private Point location;
    private Point destination;
    
    private int nbDiceRunning = 0;

    public Dialog(FunctionnalKernelAdapter adapter) {
        this.adapter = adapter;
    }
    
    @Override
    public void changePirate(int idNewPirate) {
        listPirateFace.get(idPirate).greyImage();
        listPirateFace.get(idNewPirate).colorImage();
        
        JLayeredPane layeredPaneGrid = gridModel.getjLayeredPane1();
        layeredPaneGrid.setLayer(listPiratePawn.get(idPirate), javax.swing.JLayeredPane.PALETTE_LAYER);
        layeredPaneGrid.setLayer(listPiratePawn.get(idPirate), javax.swing.JLayeredPane.MODAL_LAYER);
        
        idPirate = idNewPirate;
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
    
    public int getDiceResult(){
        return adapter.getNumberOnDice();
    }
    
    public void diceFinished(){
        nbDiceRunning -= 1;
        if(nbDiceRunning == 0){
            adapter.diceFinished();
        }
    }
    
    @Override
    public void movePirate(int idNewPirate, int box){
        PiratePawn pawn = listPiratePawn.get(idNewPirate);
        movablePawn = pawn;
        pawn.activate();
        
        CasePanel panelBox = (CasePanel) gridModel.getGridPanel().getComponent(box);
        location = pawn.getLocation();
        panelBox.putGreenBorder();
        rightCase = panelBox;
    }
    
    public void eventMousePressedGrid(Point point){
        if(movablePawn != null){
            Component casePanel = gridModel.getGridPanel().getComponentAt(point);
            destination = computeLocationPawnInCase(casePanel);
            timerX.start();
            timerY.start();
        }
    }
    
    public Point computeLocationPawnInCase(Component box){
        int dest_x = box.getLocation().x + box.getSize().width/2;
        int dest_y = box.getLocation().y + box.getSize().height/2;
        return new Point(dest_x, dest_y);
    }
    private void moveX(ActionEvent e){
        if(location.x < destination.x){
            location.translate(1, 0);
        }
        else{
            location.translate(-1, 0);
        }
        movablePawn.moveTo(location); 
        if(location.x == destination.x){
            timerX.stop();
            if(!timerY.isRunning()){
                adapter.moveFinished();
            }
        }
    }
        
    private void moveY(ActionEvent e){
        if(location.y < destination.y){
            location.translate(0, 1);
        }
        else{
            location.translate(0, -1);
        }
        movablePawn.moveTo(location); 
        if(location.y == destination.y){
            timerY.stop();
            if(!timerX.isRunning()){
                adapter.moveFinished();
            }
        }
    }
    
    public void isRightCase(){
        movablePawn = null;
        rightCase.putBlackBorder();
        adapter.moveFinished();
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
