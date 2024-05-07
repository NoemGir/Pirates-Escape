package control;

import java.util.Random;

import boundary.IBoundary;
import model.entities.Dice;
import model.entities.Board;
import model.entities.Case;
import model.entities.Pirate;
/*
 *  @author Noémie GIREAUD
 *
 *
 *
**/
public class MoveControl implements IMovePirate, IThrowDice {

	private Board board;
	private IBoundary boundary;
	private ActivateBoxControl activateBoxControl;
        private PirateGameControl pirateGameControl;
        
        private Pirate actualPirate;
        
        private Dice dice1;
        private Dice dice2;

	private boolean playAgain = false;

	public MoveControl(IBoundary boundary, ActivateBoxControl activateBoxControl, Board board) {
		this.boundary = boundary;
		this.activateBoxControl = activateBoxControl;
		this.board = board;
                this.dice1 = new Dice();
                this.dice2 = new Dice();
	}

	@Override
	public void move(Pirate pirate, int value) {
            Case box = board.move(pirate.getName(), value);
            boundary.movePirate(pirate.getName(), pirate.getIdPirate(), box.getName(), box.getNumber());
            activateBoxControl.activateBox(pirate, box);
	}
        
        public void throwDiceMovement(Pirate pirate){
            actualPirate = pirate;
            dice1.throwDice();
            dice2.throwDice();
            
            boundary.throwDoubleDice();
        }
        
        @Override
        public void doubleDicesFinished() {
            int distance = dice1.getDisplayValue() + dice2.getDisplayValue();
            move(actualPirate, distance);
        }
    
        @Override
        public void moveFinished() {
            if(dice1.getDisplayValue() == dice2.getDisplayValue()){
               throwDiceMovement(actualPirate);
            }
            else{
                pirateGameControl.newPlayerTurn(actualPirate);
            }
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
