package boundary;

import java.util.Scanner;

/*
 * Boundary connectée aux Contols présents dans le package
 * "control"
 * 
 * Boundary qui servira de sortie console
 */
public class PirateGameBoundary implements IBoundary{
    
                @Override
                public void startGame() {
                    System.out.println("Le jeu peut commencer !!\n");
                }

		@Override
		public void movePirate(String pirateName, int idPirate, String box, int boxNumber) {
			System.out.println("Le pirate " + pirateName + " bouge sur la case : " + box);
			
		}
		@Override
		public void displayPV(String pirateName, int idPirate, int health) {
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
		public void endGame(boolean won, String pirateName, String reason) {
			if(won) {
				System.out.println("La partie est terminée !\n Le pirate " + pirateName +" a gagné : " + reason);
			}
			else {
				System.out.println(reason);
			}

		}
		@Override
		public void changePlayer(String pirateName, int idPirate) {
			System.out.println("\nC'est au tour de " + pirateName + " de se bouger les fesses !" );
		}
                @Override
                public void movePirateAuto(String pirateName, int idPirate, String box, int boxNumber){
                    System.out.println("Le pirate " + pirateName + " bouge automatiquement sur la case : " + box);
                }
}
