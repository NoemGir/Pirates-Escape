package control;

import boundary.IBoundary;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
        private MoveControl moveControl;
        private VerifyEndGameControl verifyEndControl;
        
        private List<String> pirateNames = new ArrayList<>();
        
        ListIterator<Pirate> itPirate;
	
	public PirateGameControl(Board board, IBoundary boundary, MoveControl moveControl, VerifyEndGameControl verifyEndControl) {
		this.board = board;
		this.boundary = boundary;
                this.moveControl = moveControl;
                this.verifyEndControl = verifyEndControl;
	}
        
        public void startGame() {
            boundary.startGame();
            initGame();  
            newPlayerTurn(null);
	}
        
        public void newPlayerTurn(Pirate pirate){
            if(verifyEndControl.gameEnded(board.getListPirate(), pirate )){
                System.out.println("jeux bien terminé !");
                return;
            }
            Pirate newPirate = changePlayer();
            moveControl.throwDiceMovement(newPirate);     
        }
        
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

            boundary.changePlayer(actualPlayer.getName(), actualPlayer.getIdPirate());
            return actualPlayer;
        }
	
	private void initGame() {
		
		for(int i = 0; i < NB_PLAYER; i++) {
			String newName = boundary.askPirateName(i);
                        
                        Pirate newPirate = new Pirate(i, newName, HEALTH_MAX);
                        pirateNames.add(newName);
			board.addPlayer(newPirate);
                }
                
                itPirate = board.getListPirate().listIterator();

	}

    public List<String> getPirateNames() {
        return pirateNames;
    }


}
