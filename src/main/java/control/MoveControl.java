package control;

import boundary.IBoundary;
import model.entities.Dice;
import model.entities.Board;
import model.entities.Case;
import model.entities.Pirate;

/**
 * Controleur servant à générer les déplacements du joueur actuelle sur le plateau
 *
 *  @author Robin MOUNIÉ
 *  @author Noémie GIREAUD
*/
public class MoveControl implements IMovePirate, IThrowDice {

	private Board board;
	private IBoundary boundary;
        private PirateGameControl pirateGameControl;


        private Case box;
        private Dice dice1;
        private Dice dice2;

        /**
         * Crée une nouvelle instance de MoveControl
         *
         * @param boundary
         * @param board
         */
	public MoveControl(IBoundary boundary, Board board) {
		this.boundary = boundary;
		this.board = board;
                this.dice1 = new Dice();
                this.dice2 = new Dice();
	}
        
        /**
         * lance le mouvement du pirate
         * 
         * @param pirate le pirate à bouger
         * @param distance la distance surlaquelle doit avancer le pirate
         */
	public void move(Pirate pirate, int distance) {
            box = board.move(pirate.getName(), distance);
            boundary.movePirate(pirate.getIdPirate(), box.getNumber());
	}

        /**
         * Lance le tirage des dés liées au mouvement
         */
        public void throwDiceMovement(){
            dice1.throwDice();
            dice2.throwDice();

            boundary.throwDoubleDice();
        }

        @Override
        public void doubleDicesFinished() {
            int distance = dice1.getDisplayValue() + dice2.getDisplayValue();
            move(pirateGameControl.getActivePirate(), distance);
        }

        @Override
        public void moveFinished() {
            pirateGameControl.moveFinished(box);
        }
    
        /**
         * Indique si le pirate actuelle peut rejouer ( si il a fait un double dé )
         * 
         * @return un boolean indiquant si le pirate rejoue
         */
        public boolean playAgain(){
            return dice1.getDisplayValue() == dice2.getDisplayValue();
        }


	@Override
	public int getFirstDiceDisplay() {
            return dice1.getDisplayValue();
	}

	@Override
	public int getSecondDiceDisplay() {
            return dice2.getDisplayValue();
	}
	
	/**
	 * méthode utilisée dans les tests
	 * 
	 * @param value la valeur qui sera inscrite sur le dé 1
	 */
	public void setFirstDiceDisplay(int value) {
        dice1.setDisplayValue(value);
	}
	
	/**
	 * méthode utilisée dans les tests
	 * 
	 * @param value la valeur qui sera inscrite sur le dé 2
	 */
	public void setSecondDiceDisplay(int value) {
	        dice2.setDisplayValue(value);
	}
        
    /**
     * défini le pirateGameControl
     * @param pirateGameControl 
     */
    public void setPirateGameControl(PirateGameControl pirateGameControl) {
        this.pirateGameControl = pirateGameControl;
    }
}
