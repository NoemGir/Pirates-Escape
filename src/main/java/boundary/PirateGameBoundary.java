package boundary;

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

    @Override
    public void startGame() {
        System.out.println("Le jeu peut commencer !!\n");
    }

    @Override
    public void movePirate( int idPirate, int boxNumber) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        String box = pirateGameControl.getCaseName(idPirate);
        System.out.println("Le pirate " + pirateName + " bouge sur la case : " + box);

    }
    
    
    @Override
    public void displayPV(int idPirate, int health) {
        String pirateName = pirateGameControl.getPirateName(idPirate);
        System.out.println("Le pirate " + pirateName + " possède  " + health + " coeurs");

    }

    @Override
    public void throwDoubleDice() {
        System.out.println("Lancement de dés ! ");
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
                
    
}
