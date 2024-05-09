package scenario;

import boundary.PirateGameBoundary;
import control.ActivateBoxControl;
import control.MoveControl;
import control.PirateGameControl;
import control.VerifyEndGameControl;
import model.entities.Board;
import model.entities.Case;

/*
 *  Classe permettant de lancer le jeu en mode console
 */
public class ConsoleScenario {
	
    public static final int NB_CASES = 30;
    public static final int NB_PLAYERS = 2;

    public static void main(String[] args) {

        Board board = new Board(NB_CASES);

        for(int i = 0; i < NB_CASES; i++) {
                board.addCase(new Case(i));
        }

        PirateGameBoundary pirateGameBoundary = new PirateGameBoundary();

        ActivateBoxControl activateBoxControl = new ActivateBoxControl(pirateGameBoundary);
        MoveControl moveControl = new MoveControl(pirateGameBoundary,activateBoxControl, board);
        VerifyEndGameControl verifyEndGameControl = new VerifyEndGameControl(pirateGameBoundary);
        PirateGameControl pirateGameControl = new PirateGameControl(board, pirateGameBoundary,moveControl, verifyEndGameControl);

        pirateGameBoundary.setMovePirate(moveControl);
        pirateGameBoundary.setThrowDIce(moveControl);
        pirateGameBoundary.setPirateGameControl(pirateGameControl);
        
        moveControl.setPirateGameControl(pirateGameControl);
        
        pirateGameControl.startGame();
    }
}
