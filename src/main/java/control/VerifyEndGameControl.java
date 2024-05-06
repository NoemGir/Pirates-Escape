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
	
	public boolean reachedEnd(String player) {
		if( board.getLocation().containsValue(board.getNbCase()-1)) {
			boundary.endGame(true, player, "il a atteint le bateau en premier ! :D");
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
	
	
	public boolean gameEnded(Pirate[] players, String actualPlayer) {
		return countDeath(List.of(players)) || reachedEnd(actualPlayer);
	}
}
