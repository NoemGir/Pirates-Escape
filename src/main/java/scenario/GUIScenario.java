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
import model.entities.CliffCase;
import model.entities.GargamelleCase;
import model.entities.LuckyLukeShadowCase;
import model.entities.MrKrabsCase;
import model.entities.NurseCase;
import model.entities.SwapCase;
import static scenario.ConsoleScenario.NB_CASES;
import static scenario.ConsoleScenario.NB_PLAYERS;



/*
 *  Lancer l'application en mode GUI, avec interface graphique et possibilité de bouger les jetons
 */
public class GUIScenario {

    public static void main(String[] args) {
        Board board = new Board(NB_CASES, NB_PLAYERS);

        for(int i = 0; i < NB_CASES; i++) {
            switch(i){
                case 0:
                    board.addCase(new Case(i));
                    break;
                case 26:
                    board.addCase(new CliffCase(i));
                    break;
                case 25:
                    board.addCase(new GargamelleCase(i));
                    break;
                case 27:
                    board.addCase(new MrKrabsCase(i));
                    break;
                case 28:
                    board.addCase(new NurseCase(i));
                    break;
                case 29:
                   board.addCase(new LuckyLukeShadowCase(i));
                   break;
                default:
                   board.addCase(new Case(i));
            }

        }

        FunctionnalKernelAdapter functionnalKernelAdapter = new FunctionnalKernelAdapter();
        Dialog dialog = new Dialog(functionnalKernelAdapter);
        ActivateBoxControl activateBoxControl = new ActivateBoxControl(functionnalKernelAdapter);
        MoveControl moveControl = new MoveControl(functionnalKernelAdapter,activateBoxControl, board);
        VerifyEndGameControl verifyEndGameControl = new VerifyEndGameControl(functionnalKernelAdapter);
        PirateGameControl pirateGameControl = new PirateGameControl(board, functionnalKernelAdapter,moveControl, verifyEndGameControl);

        functionnalKernelAdapter.setThrowDice(moveControl);
        functionnalKernelAdapter.setDialog(dialog);
        functionnalKernelAdapter.setMovePirate(moveControl);
        functionnalKernelAdapter.setPirateGameControl(pirateGameControl);
        moveControl.setPirateGameControl(pirateGameControl);

        MainFrame mainFrame = new MainFrame();
        mainFrame.setDialog(dialog);

        pirateGameControl.startGame();
    }
}
