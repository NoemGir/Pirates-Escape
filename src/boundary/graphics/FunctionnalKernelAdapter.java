package boundary.graphics;

import boundary.IBoundary;

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

	@Override
	public void getNumberOnDice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void diceFinished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPirateNames() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void throwDice(int affichage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movePirate(String pirateName, int numeroCase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayPV(String pirateName, int health) {
		// TODO Auto-generated method stub
		
	}

}
