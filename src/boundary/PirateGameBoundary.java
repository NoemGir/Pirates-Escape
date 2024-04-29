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
		public void movePirate(String pirateName, int numCase) {
			System.out.println("Le pirate " + pirateName + " bouge sur la case " + numCase);
			
		}
		@Override
		public void displayPV(String pirateName, int health) {
			System.out.println("Le pirate " + pirateName + " possède  " + health + " coeurs");
			
		}
		@Override
		public void throwDice(int display) {
			System.out.println("Le dé affiche " + display);
		}
		
		public String askPirateName() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Donnez le nom de votre pirate :");
			return scan.next();
		}

}
