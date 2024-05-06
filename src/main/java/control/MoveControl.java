package control;

import java.util.Random;

import boundary.IBoundary;
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
	
	private boolean playAgain = false;
	

	public MoveControl(IBoundary boundary, ActivateBoxControl activateBoxControl, Board board) {
		this.boundary = boundary;
		this.activateBoxControl = activateBoxControl;
		this.board = board;
	}
	
	public void throwAndMove(Pirate pirate) {
		int resDice = throwDice();
		move(pirate, resDice);
	}

	@Override
	public void move(Pirate pirate, int value) {
		Case box = board.move(pirate.getName(), value);
		boundary.movePirate(pirate.getName(), box.getName());
		activateBoxControl.activateBox(pirate, box);
	}


	@Override
	public int throwDice() {
		Random ran = new Random();
		return ran.nextInt(6)+1;
	}

	public boolean isPlayAgain() {
		return playAgain;
	}
	
	
}