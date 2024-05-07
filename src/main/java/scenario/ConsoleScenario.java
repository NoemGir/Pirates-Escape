package scenario;

import boundary.PirateGameBoundary;
import control.ActivateBoxControl;
import control.MoveControl;
import control.PirateGameControl;
import control.VerifyEndGameControl;
import model.entities.Board;
import model.entities.Case;

/*
 *  Ici, on poura lancer l'application en mode console
 * 
 */
public class ConsoleScenario {
	
	public static final int NB_CASES = 30;
	public static final int NB_PLAYERS = 2;
	
	public static void main(String[] args) {
		
		Board board = new Board(NB_CASES, NB_PLAYERS);
		
		for(int i = 0; i < NB_CASES; i++) {
			board.addCase(new Case(i));
		}
		
		PirateGameBoundary pirateGameBoundary = new PirateGameBoundary();
		
		ActivateBoxControl activateBoxControl = new ActivateBoxControl();
		MoveControl moveControl = new MoveControl(pirateGameBoundary,activateBoxControl, board);
                VerifyEndGameControl verifyEndGameControl = new VerifyEndGameControl(pirateGameBoundary, board);
                PirateGameControl pirateGameControl = new PirateGameControl(board, pirateGameBoundary,moveControl, verifyEndGameControl);
     
		pirateGameControl.startGame();
	}
}
