package control;

import java.util.Iterator;
import java.util.List;

import boundary.IBoundary;
import model.entities.Board;
import model.entities.Pirate;

public class VerifyEndGameControl {
	
	IBoundary boundary;
	Board board;

	public VerifyEndGameControl(IBoundary boundary, Board board) {
		this.board = board;
		this.boundary = boundary;
	}
	
	public boolean reachedEnd(Pirate player) {
		if(player != null && player.getPosition() == 29) {
			boundary.endGame(true, player.getName(), "il a atteint le bateau en premier ! :D");
			return true;
		}
		return false;
	}
	
	public boolean countDeath(List<Pirate> players) {
		String survivor = null;
		
		for(Iterator<Pirate> itPlayers = players.iterator(); itPlayers.hasNext();) {
			Pirate pirate = itPlayers.next();
			if (!pirate.isDead()) {
				if(survivor != null) {
					return false;
				}
				survivor = pirate.getName();
			}
		}
		if(survivor == null) {
			boundary.endGame(false, null, "génocide sur l'île... X|");
		}
		else {
			boundary.endGame(true, survivor, "tous les autres pirates sont mystérieusement décédés ! D:");
		}
		return true;
	}
	
	
	public boolean gameEnded(List<Pirate> players, Pirate actualPlayer) {
		return countDeath(players) || reachedEnd(actualPlayer);
	}
}
