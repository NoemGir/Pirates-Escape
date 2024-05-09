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
import model.entities.PortalCase;
import model.entities.GargamelleCase;
import model.entities.LuckyLukeShadowCase;
import model.entities.MrKrabsCase;
import model.entities.NurseCase;
import model.entities.SwapCase;
import static scenario.ConsoleScenario.NB_CASES;


/*
 *  Lancer l'application en mode GUI, avec interface graphique et possibilité de bouger les jetons
 */
public class GUIScenario {

    public static void main(String[] args) {
        Board board = new Board(NB_CASES);

        for(int i = 0; i < NB_CASES; i++) {
            switch(i){
                case 0:
                    board.addCase(new Case(i));
                    break;
                case 26:
                    board.addCase(new NurseCase(i));
                    break;
                case 25:
                    board.addCase(new NurseCase(i));
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
                   board.addCase(new GargamelleCase(i));
            }
        }

        FunctionnalKernelAdapter functionnalKernelAdapter = new FunctionnalKernelAdapter();
        Dialog dialog = new Dialog(functionnalKernelAdapter);
        ActivateBoxControl activateBoxControl = new ActivateBoxControl(functionnalKernelAdapter);
        MoveControl moveControl = new MoveControl(functionnalKernelAdapter, board);
        VerifyEndGameControl verifyEndGameControl = new VerifyEndGameControl(functionnalKernelAdapter);
        PirateGameControl pirateGameControl = new PirateGameControl(board, functionnalKernelAdapter,moveControl, verifyEndGameControl, activateBoxControl);

        functionnalKernelAdapter.setThrowDice(moveControl);
        functionnalKernelAdapter.setDialog(dialog);
        functionnalKernelAdapter.setMovePirate(moveControl);
        functionnalKernelAdapter.setPirateGameControl(pirateGameControl);
        functionnalKernelAdapter.setMovePirateEffect(activateBoxControl);
        moveControl.setPirateGameControl(pirateGameControl);
        activateBoxControl.setPirateGameControl(pirateGameControl);

        MainFrame mainFrame = new MainFrame();
        mainFrame.setDialog(dialog);

        pirateGameControl.startGame();
    }
}
