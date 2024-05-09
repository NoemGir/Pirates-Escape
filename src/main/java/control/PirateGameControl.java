package control;

import boundary.IBoundary;
import java.util.ListIterator;
import model.entities.Board;
import model.entities.Pirate;

/**
 * Controleur principal, chargé dde gerer l'ordre des évènements du jeu
 *
 * @author Noémie GIREAUD
 * @author Robin MOUNIÉ
 */
public class PirateGameControl{

    public final int NB_PLAYER = 2;
    public final int HEALTH_MAX = 5;

    private Board board;

    private IBoundary boundary;
    private MoveControl moveControl;
    private VerifyEndGameControl verifyEndControl;

    private Pirate activPirate;
    private ListIterator<Pirate> itPirate;

    /**
     * Créé une nouvelle instance de PirateGameControl
     *
     * @param board le plateau
     * @param boundary le boundary
     * @param moveControl le controleur de movement
     * @param verifyEndControl le controleur de vérification de fin de jeu
     */
    public PirateGameControl(Board board, IBoundary boundary, MoveControl moveControl, VerifyEndGameControl verifyEndControl) {
        this.board = board;
        this.boundary = boundary;
        this.moveControl = moveControl;
        this.verifyEndControl = verifyEndControl;
    }

    /**
     *  Initie et commence le jeu
     */
    public void startGame() {
        boundary.startGame();
        initGame();
        newPlayerTurn(null);
    }

    /**
     * Vérifie fin de jeu et lance un tour pour un nouveau joueur
     *
     * @param pirate le nouveau joueur
     */
    public void newPlayerTurn(Pirate pirate){
        if (!verifyEndGameManagement(pirate)){
            activPirate = changePlayer();
            moveControl.throwDiceMovement();
        }
    }

    /**
     * Change le joueur actuelle
     * Cette methode est necessaire pour adapter le code à un nombre de joueur suppérieur a 2
     *
     * @return le joueur suivant
     */
    private Pirate changePlayer(){
        if(!itPirate.hasNext()){
            itPirate = board.getListPirate().listIterator();
        }
        Pirate actualPlayer = itPirate.next();
        for( ;actualPlayer.isDead(); actualPlayer = itPirate.next()){
            if(!itPirate.hasNext()){
                itPirate = board.getListPirate().listIterator();
            }
        }

        boundary.changePlayer(actualPlayer.getIdPirate());
        return actualPlayer;
    }

    /**
     * Initie les joueurs présents dans le jeu
     */
    private void initGame() {
        for(int i = 0; i < NB_PLAYER; i++) {
            String newName = boundary.askPirateName(i);

            Pirate newPirate = new Pirate(i, newName, HEALTH_MAX);
            board.addPlayer(newPirate);
        }
        itPirate = board.getListPirate().listIterator();
    }

    /**
     * Vérifie si le jeu et terminé et continue en conséquence
     *
     * @param pirate le pirate qui vient de jouer
     * @return True si le jeu est terminé, false sinon
     */
    public boolean verifyEndGameManagement(Pirate pirate){
        if(verifyEndControl.gameEnded(board.getListPirate(), pirate )){
            System.out.println("jeux bien terminé !");
            return true;
        }
        return false;
    }

    public String getPirateName(int idPirate){
        return board.getListPirate().get(idPirate).getName();
    }

    public String getCaseName(int idBox){
        return board.getCases().get(idBox).getName();
    }

    public Pirate getActivPirate() {
        return activPirate;
    }
    
    public String getBoxLink(int idBox){
        return board.getCases().get(idBox).getImageLink();
    }


}
