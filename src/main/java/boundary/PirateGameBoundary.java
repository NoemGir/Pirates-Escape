package boundary;

import control.IMovePirate;
import control.IThrowDice;
import control.PirateGameControl;
import java.util.Scanner;

/*
 * Boundary connectée aux Contols présents dans le package
 * "control"
 * 
 * Boundary qui servira de sortie console
 */
public class PirateGameBoundary implements IBoundary{
    
    private PirateGameControl pirateGameControl;
    private IMovePirate movePirate;
    private IThrowDice throwDIce;

    @Override
    public void startGame() {
        System.out.println("Le jeu peut commencer !!\n");
    }

    @Override
    public void movePirate( int idPirate, int boxNumber) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        String box = pirateGameControl.getCaseName(idPirate);
        System.out.println("Le pirate " + pirateName + " bouge sur la case : " + box);
        movePirate.moveFinished();
    }
    
    
    @Override
    public void displayPV(int idPirate, int health) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        System.out.println("Le pirate " + pirateName + " possède  " + health + " coeurs");

    }

    @Override
    public void throwDoubleDice() {
        System.out.println("Lancement de dés ! ");
        System.out.println("Le dé 1 tombe sur " + throwDIce.getFirstDiceDisplay());
        System.out.println("Le dé 2 tombe sur " + throwDIce.getSecondDiceDisplay());
        throwDIce.doubleDicesFinished();
    }

    @Override
    public String askPirateName(int idPirate) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Donnez le nom de votre pirate :");
        return scan.next();
    }
    
    @Override
    public void endGame(int idPirate, String reason) {
        if(idPirate != -1) {
            String pirateName = pirateGameControl.getPirateName(idPirate);
            System.out.println("La partie est terminée !\n Le pirate " + pirateName +" a gagné : " + reason);
        }
        else {
            System.out.println(reason);
        }
    }
    
    
    @Override
    public void changePlayer(int idPirate) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        System.out.println("\nC'est au tour de " + pirateName + " de se bouger les fesses !" );
    }

    public void setPirateGameControl(PirateGameControl pirateGameControl) {
        this.pirateGameControl = pirateGameControl;
    }

    public void setMovePirate(IMovePirate movePirate) {
        this.movePirate = movePirate;
    }

    public void setThrowDIce(IThrowDice throwDIce) {
        this.throwDIce = throwDIce;
    }
}
