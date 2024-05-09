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
	private ActivateBoxControl activateBoxControl;
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

	public void move(Pirate pirate, int value) {
            box = board.move(pirate.getName(), value);
            boundary.movePirate(pirate.getIdPirate(), box.getNumber());
	}

        public void throwDiceMovement(){
            dice1.throwDice();
            dice2.throwDice();

            boundary.throwDoubleDice();
        }

        @Override
        public void doubleDicesFinished() {
            int distance = dice1.getDisplayValue() + dice2.getDisplayValue();
            move(pirateGameControl.getActivPirate(), distance);
        }

        @Override
        public void moveFinished() {
            pirateGameControl.moveFinished(box);
        }
    
        
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

    public void setPirateGameControl(PirateGameControl pirateGameControl) {
        this.pirateGameControl = pirateGameControl;
    }
}
