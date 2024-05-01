package scenario;

import boundary.PirateGameBoundary;
import control.ActivateBoxControl;
import control.MoveControl;
import control.PirateGameControl;
import control.VerifyEndGameControl;
import model.entities.Board;

/*
 *  Ici, on poura lancer l'application en mode console
 * 
 */
public class ConsoleScenario {
	
	public final int NB_CASES = 30;
	
	Board board = new Board(NB_CASES);
	PirateGameBoundary pirateGameBoundary = new PirateGameBoundary();
	
	ActivateBoxControl activateBoxControl = new ActivateBoxControl();
	VerifyEndGameControl VerifyEndGameControl = new VerifyEndGameControl(pirateGameBoundary, board);
	MoveControl moveControl = new MoveControl(pirateGameBoundary, activateBoxControl, board);
	PirateGameControl pirateGameControl = new PirateGameControl(pirateGameBoundary, moveControl, VerifyEndGameControl);
	
	PirateGameControl.startGame();
}
