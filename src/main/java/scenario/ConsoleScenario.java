package scenario;

import boundary.PirateGameBoundary;
import boundary.graphics.Dialog;
import boundary.graphics.FunctionnalKernelAdapter;
import boundary.graphics.personalizedComponents.GameFrame;
import control.ActivateBoxControl;
import control.MoveControl;
import control.PirateGameControl;
import control.VerifyEndGameControl;
import model.entities.Board;
import model.entities.Case;
import model.entities.FinishLine;
import model.entities.GargamelleCase;
import model.entities.LuckyLukeShadowCase;
import model.entities.MrKrabsCase;
import model.entities.NurseCase;
import model.entities.PortalCase;
import model.entities.StartCase;

/*
 *  Classe permettant de lancer le jeu en mode console
 */
public class ConsoleScenario {
	
    public static final int NB_CASES = 30;
    public static final int NB_PLAYERS = 2;

    public static void main(String[] args) {
        Board board = new Board(NB_CASES);
        
        for(int i = 0; i < NB_CASES; i++) {
            switch(i){
                case 0:
                    board.addCase(new StartCase(i));
                    break;
                case 6:
                    board.addCase(new PortalCase(i));
                    break;
                case 15:
                    board.addCase(new GargamelleCase(i));
                    break;
                case 23:
                    board.addCase(new MrKrabsCase(i));
                    break;
                case 7:
                    board.addCase(new NurseCase(i));
                    break;
                case 27:
                    board.addCase(new LuckyLukeShadowCase(i));
                    break;
                case 29:
                   board.addCase(new FinishLine(i));
                   break;
                default:
                   board.addCase(new Case(i));
            }
        }

        PirateGameBoundary pirateGameBoundary = new PirateGameBoundary();
        ActivateBoxControl activateBoxControl = new ActivateBoxControl(pirateGameBoundary);
        MoveControl moveControl = new MoveControl(pirateGameBoundary, board);
        VerifyEndGameControl verifyEndGameControl = new VerifyEndGameControl(pirateGameBoundary);
        PirateGameControl pirateGameControl = new PirateGameControl(board, pirateGameBoundary,moveControl, verifyEndGameControl, activateBoxControl);

        pirateGameBoundary.setThrowDice(moveControl);
        pirateGameBoundary.setMovePirate(moveControl);
        pirateGameBoundary.setPirateGameControl(pirateGameControl);
        pirateGameBoundary.setMovePirateEffect(activateBoxControl);
        moveControl.setPirateGameControl(pirateGameControl);
        activateBoxControl.setPirateGameControl(pirateGameControl);
        
        pirateGameControl.startGame();
    }
}
