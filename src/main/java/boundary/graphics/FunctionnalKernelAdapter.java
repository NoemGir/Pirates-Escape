package boundary.graphics;

import boundary.IBoundary;
import control.IMovePirate;
import control.IThrowDice;
import control.PirateGameControl;

/**
 * Fait le lien entre les controleurs et le dialog IHM grace à son implémentation de IBoundary
 * Il appellera les methodes de IPirates pour demander des services aux Dialog,
 * et le Dialog passera par lui pour communiquer avec les controleurs grace à son implentation de IFunctionnalKernel
 * 
 * @author Noémie GIREAUD
 */
public class FunctionnalKernelAdapter implements IFunctionnalKernel, IBoundary{

    private IPirates dialog;
    private IMovePirate movePirate;
    private PirateGameControl pirateGameControl;
    private IThrowDice throwDice;
    
    
    @Override
    public void startGame() {
        dialog.startGame();
    }
    
    @Override
    public int getNumberOnDice(int idDice) {
        if(idDice == 0){
            return throwDice.getFirstDiceDisplay();
        }
        else{
            return throwDice.getSecondDiceDisplay();
        }
    }

    @Override
    public void diceFinished() {
        dialog.desactivateThrowDice();
        throwDice.doubleDicesFinished();
    }

    @Override
    public void moveFinished() {
        movePirate.moveFinished();
    }



    @Override
    public void throwDoubleDice() {
        dialog.activateThrowDice();
    }


    @Override
    public void displayPV(int idPirate, int health) {
        dialog.changeHeart(idPirate, health);
    }

    @Override
    public String askPirateName(int idPirate) {
            return dialog.askName(idPirate);
    }

    @Override
    public void endGame(int idPirate, String reason) {
            dialog.endGame();
    }

    @Override
    public void changePlayer( int idPirate) {
        dialog.changePirate(idPirate);
    }

    @Override
    public void movePirate(int idPirate, int boxNumber) {
            dialog.movePirate( idPirate, boxNumber);
    }

    @Override
    public String getPirateName(int idPirate) {
        return pirateGameControl.getPirateName(idPirate);
    }
    
    @Override
    public String getCaseName(int idCase) {
        return pirateGameControl.getCaseName(idCase);
    }
    
    public void setDialog(IPirates dialog) {
        this.dialog = dialog;
    } 

    public void setThrowDice(IThrowDice throwDice) {
        this.throwDice = throwDice;
    }

    public void setMovePirate(IMovePirate movePirate) {
        this.movePirate = movePirate;
    }

    public void setPirateGameControl(PirateGameControl pirateGameControl) {
        this.pirateGameControl = pirateGameControl;
    }
    
}
