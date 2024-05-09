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
    private IMovePirate movePirateEffect;
    private PirateGameControl pirateGameControl;
    private IThrowDice throwDice;


    @Override
    public void startGame() {
        dialog.startGame();
        dialog.display("Le jeu peut commencer !!");
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
        throwDice.doubleDicesFinished();
    }

    @Override
    public void moveFinished() {
        movePirate.moveFinished();
    }
    
    @Override
    public void moveEffectFinished() {
        movePirateEffect.moveFinished();    
    }

    @Override
    public void throwDoubleDice() {
        dialog.activateThrowDice();
        dialog.display("Les dés peuvent être lancés !");
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
        dialog.display("La partie est terminée ! :D");
        if(idPirate == -1){
            dialog.display("Il n'y a aucun vainqueur ..." + reason);
        }
        else{
            String pirateName = pirateGameControl.getPirateName(idPirate);
            dialog.display(pirateName + " a gagné !! " + reason);
        }
        dialog.endGame();
    }

    @Override
    public void changePlayer( int idPirate) {
        dialog.changePirate(idPirate);
        String pirateName = pirateGameControl.getPirateName(idPirate);
        System.out.println("\nC'est au tour de " + pirateName + " de jouer. AArggh !! " );

    }

    @Override
    public void movePirate(int idPirate, int boxNumber) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        String box = pirateGameControl.getCaseName(boxNumber);
        dialog.movePirate( idPirate, boxNumber);
        dialog.display("Le pirate " + pirateName + " doit bouger sur la case " + boxNumber + " : " + box);
    }

    
    @Override
    public void movePirateAuto(int idPirate, int boxNumber){
        String pirateName = pirateGameControl.getPirateName(idPirate);
        String box = pirateGameControl.getCaseName(boxNumber);
        this.dialog.movePirateAuto( idPirate, boxNumber);
        dialog.display("Le pirate " + pirateName + " glisse sur la case " + boxNumber + " : " + box);
    }

    @Override
    public void playAgain(int idPirate) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        dialog.display("Le pirate adverse viens de se fouler la cheville ! " + pirateName + " peut rejouer");
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

    public void setMovePirateEffect(IMovePirate movePirateEffect) {
        this.movePirateEffect = movePirateEffect;
    }
}
