package scenario;

import boundary.graphics.Dialog;
import boundary.graphics.FunctionnalKernelAdapter;
import boundary.graphics.personalizedComponents.MainFrame;
import com.sun.tools.javac.Main;
import control.ActivateBoxControl;
import control.MoveControl;
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
			board.addCase(new Case("Case " + (i+1)));
		}
                
        FunctionnalKernelAdapter functionnalKernelAdapter = new FunctionnalKernelAdapter();
        Dialog dialog = new Dialog(functionnalKernelAdapter);
        ActivateBoxControl activateBoxControl = new ActivateBoxControl();
        MoveControl moveControl = new MoveControl(functionnalKernelAdapter,activateBoxControl, board);
        
        functionnalKernelAdapter.setThrowDice(moveControl);
        functionnalKernelAdapter.setDialog(dialog);
        
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDialog(dialog);
        mainFrame.showMainFrame();
        dialog.initGame();
        dialog.movePirate(0, 5);
    }
}
