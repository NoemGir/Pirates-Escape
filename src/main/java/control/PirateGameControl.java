package control;

import boundary.IBoundary;
import model.entities.Board;
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

	private Board board;
	private IBoundary boundary;
	private MoveControl controlMove;
	private VerifyEndGameControl verifyEndGameControl;
	
	public PirateGameControl(Board board, IBoundary boundary, MoveControl controlMove, VerifyEndGameControl verifyEndGameControl) {
		this.board = board;
		this.boundary = boundary;
		this.controlMove = controlMove;
		this.verifyEndGameControl = verifyEndGameControl;
	}
	
	public Pirate[] initGame() {
		Pirate[] players = new Pirate[NB_PLAYER];
		
		for(int i = 0; i < NB_PLAYER; i++) {
			String newName = boundary.askPirateName();
			Pirate newPirate = new Pirate(newName, HEALTH_MAX);
			board.addPlayer(newName);
			players[i] = newPirate;
		}
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
					ended = verifyEndGameControl.gameEnded(players, player.getName());
				}
				while(controlMove.isPlayAgain() && !ended);
			}
		}
	}
}
