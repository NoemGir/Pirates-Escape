package control;

import java.util.Iterator;
import java.util.List;

import boundary.IBoundary;
import model.entities.Board;
import model.entities.Pirate;

/**
 * Controleur chargé de vérifier la fin de jeu et de réagir en fonction
 * 
 * @author Noémie GIREAUD
 */
public class VerifyEndGameControl {

    private IBoundary boundary;


    /**
     *  Crée une instance de VerifyEndGameControl
     * @param boundary le boundary
     */
    public VerifyEndGameControl(IBoundary boundary) {
        this.boundary = boundary;
    }

    /**
     * Vérifie si le joueur à atteint la fin
     * 
     * @param player le joueur qui joue actuellement
     * @return un booleen indiquant si un joueur à atteint la fin ou non
     */
    public boolean reachedEnd(Pirate player) {
        if(player != null && player.getPosition() == 29) {
            boundary.endGame(player.getIdPirate(), "il a atteint le bateau en premier ! :D");
            return true;
        }
        return false;
    }

    /**
     * Vérifie le nombre de mort : indique si il y a un unique survivant, si tous les joueurs sont morts ou si le jeu continue
     *
     * @param players la liste des joueurs du jeu
     * @return True si la partie est terminée, sinon false
     */
    public boolean countDeath(List<Pirate> players) {
        Pirate survivor = null;

        for(Iterator<Pirate> itPlayers = players.iterator(); itPlayers.hasNext();) {
            Pirate pirate = itPlayers.next();
            if (!pirate.isDead()) {
                if(survivor != null) {
                    return false;
                }
                survivor = pirate;
            }
        }
        if(survivor == null) {
            boundary.endGame(-1, "génocide sur l'île... X|");
        }
        else {
            boundary.endGame(survivor.getIdPirate(), "tous les autres pirates sont mystérieusement décédés ! D:");
        }
        return true;
    }

    /**
     * Vérifie si le jeu est terminé ou non
     * Un jeu se termine si :
     *  - un joueur a atteint la fin
     *  - il ne reste plus que 1 joueur vivant
     *  - tous les joueurs sont morts
     * 
     * @param players la liste des joueurs du jeu
     * @param actualPlayer le joueur qui vient de jouer
     * @return True si le jeu est terminé, false sinon
     */
    public boolean gameEnded(List<Pirate> players, Pirate actualPlayer) {
        return countDeath(players) || reachedEnd(actualPlayer);
    }
}
