package scenario;

import boundary.graphics.Dialog;
import boundary.graphics.FunctionnalKernelAdapter;
import boundary.graphics.personalizedComponents.MainFrame;
import control.ActivateBoxControl;
import control.MoveControl;
import control.PirateGameControl;
import control.VerifyEndGameControl;
import model.entities.Board;
import model.entities.Case;
import static scenario.ConsoleScenario.NB_CASES;
import static scenario.ConsoleScenario.NB_PLAYERS;



/*
 *  Ici, on poura lancer l'application en mode GUI, avec
 *  interface graphique et possibilité de bouger les jetons
 * 
 */
public class GUIScenario {
    
    public static void main(String[] args) {
        Board board = new Board(NB_CASES, NB_PLAYERS);
		
        for(int i = 0; i < NB_CASES; i++) {
                board.addCase(new Case(i));
        }
                
        FunctionnalKernelAdapter functionnalKernelAdapter = new FunctionnalKernelAdapter();
        Dialog dialog = new Dialog(functionnalKernelAdapter);
        ActivateBoxControl activateBoxControl = new ActivateBoxControl();
        MoveControl moveControl = new MoveControl(functionnalKernelAdapter,activateBoxControl, board);
	VerifyEndGameControl verifyEndGameControl = new VerifyEndGameControl(functionnalKernelAdapter, board);
	PirateGameControl pirateGameControl = new PirateGameControl(board, functionnalKernelAdapter,moveControl, verifyEndGameControl);
        
        functionnalKernelAdapter.setThrowDice(moveControl);
        functionnalKernelAdapter.setDialog(dialog);
        functionnalKernelAdapter.setMovePirate(moveControl);
        moveControl.setPirateGameControl(pirateGameControl);
        
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDialog(dialog);
        
        pirateGameControl.startGame();
    }
}
