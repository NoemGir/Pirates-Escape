package control;

import boundary.IBoundary;
import model.entities.Pirate;

/*
 * Utilise d'autre Controls tels que MoveControl, VerifyEndGameControl, ActivateBoxControl....
 * 
 */

/**
 * 
 * @author Noémie GIREAUD
 * @author Robin MOUNIÉ
 */
public class PirateGameControl {
	
	private final int NB_PLAYER = 2;
	
	private IBoundary boundary;
	private IThrowDice controlThrowDice;
	private IMovePirate controlMovePirate;
	
	public PirateGameControl(IBoundary boundary, IThrowDice controlThrowDice, IMovePirate controlMovePirate) {
		this.boundary = boundary;
		this.controlThrowDice = controlThrowDice;
		this.controlMovePirate = controlMovePirate;
	}
	
	public void startGame() {
		
		Pirate players[] = new Pirate[NB_PLAYER];
		for(int i = 0; i < NB_PLAYER; i++) {
			Pirate p = new Pirate(boundary.askPirateName());
			players[i] = p;
		}
		
		boolean fini = false;
		
		for(int i = 0; !fini; i++) {
			Pirate player = players[i%NB_PLAYER];
			int move = controlThrowDice.throwDice(player.getName());
			controlMovePirate.move(player.getName(), move);
			
		}
	}
	
	public void endGame() {
		
	}
}
