package control;

import boundary.IBoundary;
import java.util.ListIterator;
import model.entities.Board;
import model.entities.Case;
import model.entities.Pirate;

/**
 * Controleur principal, chargé dde gerer l'ordre des évènements du jeu
 *
 * @author Noémie GIREAUD
 * @author Robin MOUNIÉ
 */
public class PirateGameControl{

    public static final int NB_PLAYER = 2;
    public static final int HEALTH_MAX = 5;

    private Board board;

    private IBoundary boundary;
    private MoveControl moveControl;
    private VerifyEndGameControl verifyEndControl;
    private ActivateBoxControl activateBoxControl;

    private Pirate activePirate = null;
    private ListIterator<Pirate> itPirate;

    /**
     * Créé une nouvelle instance de PirateGameControl
     *
     * @param board le plateau
     * @param boundary le boundary
     * @param moveControl le controleur de movement
     * @param verifyEndControl le controleur de vérification de fin de jeu
     */
    public PirateGameControl(Board board, IBoundary boundary, MoveControl moveControl, VerifyEndGameControl verifyEndControl, ActivateBoxControl activateBoxControl) {
        this.board = board;
        this.boundary = boundary;
        this.moveControl = moveControl;
        this.verifyEndControl = verifyEndControl;
        this.activateBoxControl = activateBoxControl;
    }

    /**
     *  Initie et commence le jeu
     */
    public void startGame() {
        activePirate = null;
        activateBoxControl.reset();
        boundary.startGame();
        initGame();
        newPlayerTurn();
    }

    /**
     * PirateGameControl : Vérifie si fin de jeu et 
     * lance un tour pour un nouveau joueur
     */
    public void newPlayerTurn(){
        if (!verifyEndGameManagement()){
            activePirate = changePlayer();
            moveControl.throwDiceMovement();
        }
    }
    
    public void moveFinished(Case box){
    	
        activateBoxControl.activateBox(board.getListPirate(), activePirate, box);
        
        if(! activateBoxControl.mustWait()){
            verifyPlayAgain();
        }
    }
    
    /**
     * Vérifie si le joueur actuelle doit rejouer ou non
     */
    public void verifyPlayAgain(){
        if(moveControl.playAgain()){
            if (!verifyEndGameManagement()){
                boundary.playAgain(activePirate.getIdPirate());
                moveControl.throwDiceMovement();
            }
        }
        else{
            newPlayerTurn();
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
        board.initBoard();
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
     * @return True si le jeu est terminé, false sinon
     */
    public boolean verifyEndGameManagement(){
        if(verifyEndControl.gameEnded(board.getListPirate(), activePirate )){
            return true;
        }
        return false;
    }
    
    /**
     * Récupère le nom du pirate associé à l'identifiant
     * 
     * @param idPirate l'identifiant du pirate
     * @return le nom du pirate
     */
    public String getPirateName(int idPirate){
        return board.getListPirate().get(idPirate).getName();
    }

    /**
     * Récupère le nom de la case associé à l'identifiant
     * 
     * @param idBox l'identifiant de la case
     * @return le nom de la case
     */
    public String getCaseName(int idBox){
        return board.getCases().get(idBox).getName();
    }

    /**
     * Récupère le pirate qui joue actuellement
     * 
     * @return le pirate entrain de faire son tour
     */
    public Pirate getActivePirate() {
        return activePirate;
    }
    
    /**
     * Récupère le nom de l'image associé à l'identifiant de la case
     * 
     * @param idBox l'identifiant de la case 
     * @return le nom de l'image associé à la case
     */
    public String getBoxLink(int idBox){
        return board.getCases().get(idBox).getImageLink();
    }

    /**
     * Méthode crée pour les test
     * 
     * @param activePlayer le joueur actif
     */
	public void setActivePlayer(Pirate activePlayer) {
		this.activePirate = activePlayer;
	}

	public void setItPirate(ListIterator<Pirate> itPirate) {
		this.itPirate = itPirate;
	}
}
