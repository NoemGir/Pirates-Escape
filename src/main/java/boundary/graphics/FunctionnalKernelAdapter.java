package boundary.graphics;

import boundary.IBoundary;
import control.IMovePirate;
import control.IThrowDice;
import control.PirateGameControl;
import java.util.List;

/*
 *  PAS A METTRE DANS BOUNDary -> DANS CONTROL
 *  UNIQUEMENT POUR IHM 
 *  
 *  Va appeler des methodes implementés dans Dialog
 *  
 *  
 *  quand controleur demande quelque chose, se met en attribut ( en fonction de l'interface)
 *  chaque controle va dire : je suis de cette interface la
 *  IHM repond par rapport a l'interface  = au controleur inscrit
 *  interface noyau va parler au control
 *  
 *  les controleurs ont juste des appels ?
 *  Les controleurs qui s'inscrivent se fait ici
 *  
 *  
 *  quand lance dé, fait IPirate
 *  
 *  fait coordination entre IHM et ECB
 *  
 *  brancher les controles entre IHM et les controleurs 
 *  
 */
public class FunctionnalKernelAdapter implements IFunctionnalKernel, IBoundary{

    private IPirates dialog;
    private PirateGameControl pirateGameControl;
    private IMovePirate movePirate;
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
    public List<String> getPirateNames() {
        return pirateGameControl.getPirateNames();
    }


    @Override
    public void throwDoubleDice() {
        dialog.activateThrowDice();
    }


    @Override
    public void displayPV(String pirateName, int idPirate, int health) {
        dialog.changeHeart(idPirate, health);
    }

    @Override
    public String askPirateName(int idPirate) {
            return dialog.askName(idPirate);
    }

    @Override
    public void endGame(boolean won, String pirateName, String reason) {
            dialog.endGame();
    }

    @Override
    public void changePlayer(String name, int idPirate) {
        dialog.changePirate(idPirate);
    }

    @Override
    public void movePirate(String pirateName, int idPirate, String box, int boxNumber) {
            dialog.movePirate( idPirate, boxNumber);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    } 

    public void setThrowDice(IThrowDice throwDice) {
        this.throwDice = throwDice;
    }

    public void setMovePirate(IMovePirate movePirate) {
        this.movePirate = movePirate;
    }
    
    
}
