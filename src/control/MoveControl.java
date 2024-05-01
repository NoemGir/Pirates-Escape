package control;

import boundary.IBoundary;
import model.entities.Board;
import model.entities.Case;
import model.entities.Pirate;

public class MoveControl implements IMovePirate, IThrowDice {
	
	Board board;
	IBoundary boundary;
	ActivateBoxControl activateBoxControl;

	public MoveControl(IBoundary boundary, ActivateBoxControl activateBoxControl, Board board) {
		this.boundary = boundary;
		this.activateBoxControl = activateBoxControl;
		this.board = board;
	}

	@Override
	public void move(Pirate pirate, int value) {
		Case box = board.move(pirate.getName(), value);
		boundary.movePirate(pirate.getName(), box.getName());
		activateBoxControl.activateBox(pirate, box);
	}



	@Override
	public int throwDice(String player) {
		//TODO
		return 0;
	}


}