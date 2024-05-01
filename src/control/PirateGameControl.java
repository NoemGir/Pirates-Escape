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
	
	public final int NB_PLAYER = 2;
	public final int HEALTH_MAX = 6;

	
	private IBoundary boundary;
	private MoveControl controlMove;
	private VerifyEndGameControl verifyEndGameControl;
	
	public PirateGameControl(IBoundary boundary, MoveControl controlMove, VerifyEndGameControl verifyEndGameControl) {
		this.boundary = boundary;
		this.controlMove = controlMove;
		this.verifyEndGameControl = verifyEndGameControl;
	}
	
	public Pirate[] initGame() {
		Pirate[] players = new Pirate[NB_PLAYER];
		
		for(int i = 0; i < NB_PLAYER; i++) {
			Pirate newPirate = new Pirate(boundary.askPirateName(), HEALTH_MAX);
			players[i] = newPirate;
		}
		
		verifyEndGameControl.setPlayers(players);
		return players;
	}
	
	public void startGame() {
		
		Pirate[] players = initGame();
		
		boolean ended = false;
		
		for(int i = 0; !ended; i++) {
			Pirate player = players[i%NB_PLAYER];
			if(!player.isDead()) {
				boundary.changeTurn(player.getName());
				do {
					controlMove.throwAndMove(player);
					ended = verifyEndGameControl.gameEnded(player.getName());
				}
				while(controlMove.isPlayAgain() && !ended);
			}
		}
	}
	
	public void endGame() {
		
	}
}
