package boundary.graphics;

import boundary.IPirates;
import boundary.graphics.personalizedComponents.PirateFace;
import boundary.graphics.personalizedComponents.PiratePawn;

/*
 *  Va appeler des methodes implementés dans FunctionnalKernelAdapter
 * appel servir IBoundary codé avec les services de IPirate ?
 *
 *Le contrôleur de dialogue gère le séquencement des entrées/sorties et agit comme médiateur
 *entre l’interface du noyau fonctionnel et la présentation
 *
 * IHM
 */
public class Dialog implements IPirates {
    
    private PirateFace pirateFace1;
    private PirateFace pirateFace2;
    private PiratePawn piratePawn1;
    private PiratePawn piratePawn2;
    private int idPirate;
    
        
	@Override
	public void changePirate() {
        //switch réalisé si le jeu est adapté a plus de 2 joueurs 
		switch (idPirate){
                    case 0: 
                        pirateFace1.colorImage();
                        pirateFace2.greyImage();
                        piratePawn1.activate();
                        piratePawn2.desactivate();
                        break;
                    case 1:
                        pirateFace2.colorImage();
                        pirateFace1.greyImage();
                        piratePawn2.activate();
                        piratePawn1.desactivate();
                }
	}

	@Override
	public void activateThrowDice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(String message) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		
	}

}
