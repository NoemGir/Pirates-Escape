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
		public void movePirate(String pirateName, String box) {
			System.out.println("Le pirate " + pirateName + " bouge sur la case : " + box);
			
		}
		@Override
		public void displayPV(String pirateName, int health) {
			System.out.println("Le pirate " + pirateName + " possède  " + health + " coeurs");
			
		}
		@Override
		public void throwDice1(int display) {
			System.out.println("Le premier dé affiche " + display);
		}
		
		@Override
		public void throwDice2(int display) {
			System.out.println("Le second dé affiche " + display);
		}
		
		public String askPirateName() {
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
		public void changeTurn(String pirateName) {
			System.out.println("\nC'est au tour de " + pirateName + " de se bouger les fesses !" );
		}

}
