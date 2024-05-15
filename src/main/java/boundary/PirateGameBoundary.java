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
    private IMovePirate movePirateEffect;
    private IThrowDice throwDice;

    @Override
    public void startGame() {
        System.out.println("Le jeu peut commencer !!\n");
    }

    @Override
    public void movePirate( int idPirate, int boxNumber) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        String box = pirateGameControl.getCaseName(boxNumber);
        System.out.println("Le pirate " + pirateName + " doit bouger sur la case " + boxNumber + " : " + box);
      //Décommenter section suivante si déplacement manuelle avec console
        /*
        Scanner scan = new Scanner(System.in);
        String givenBox;
        do{
            System.out.println("Ecrivez le numéro de la case où bouger votre pirate :");
            givenBox = scan.next();
            
        }while (!givenBox.equals(String.valueOf(boxNumber)));
        */
        movePirate.moveFinished();
    }

    @Override
    public void movePirateAuto(int idPirate, int boxNumber){
        String pirateName = pirateGameControl.getPirateName(idPirate);
        String box = pirateGameControl.getCaseName(boxNumber);
        System.out.println("Le pirate " + pirateName + " bouge automatiquement sur la case " + boxNumber + " : " + box);
        movePirateEffect.moveFinished();
    }


    @Override
    public void displayPV(int idPirate, int health) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        System.out.println("Le pirate " + pirateName + " possède  " + health + " coeurs");

    }

    @Override
    public void throwDoubleDice() {
        System.out.println("Lancement de dés ! ");
        System.out.println("Le dé 1 tombe sur " + throwDice.getFirstDiceDisplay());
        System.out.println("Le dé 2 tombe sur " + throwDice.getSecondDiceDisplay());
        throwDice.doubleDicesFinished();
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
        
    @Override
    public void playAgain(int idPirate) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        System.out.println("Le pirate adverse viens de se fouler la cheville ! " + pirateName + " peut rejouer");
    }

    public void setMovePirateEffect(IMovePirate movePirateEffect) {
        this.movePirateEffect = movePirateEffect;
    }

    public void setPirateGameControl(PirateGameControl pirateGameControl) {
        this.pirateGameControl = pirateGameControl;
    }

    public void setMovePirate(IMovePirate movePirate) {
        this.movePirate = movePirate;
    }

    public void setThrowDice(IThrowDice throwDice) {
        this.throwDice = throwDice;
    }
}
