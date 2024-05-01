package control;

import java.util.Random;

import boundary.IBoundary;
import model.entities.Board;
import model.entities.Case;
import model.entities.Pirate;

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
		int resDice = throwDice(pirate.getName());
		move(pirate, resDice);
	}

	@Override
	public void move(Pirate pirate, int value) {
		Case box = board.move(pirate.getName(), value);
		boundary.movePirate(pirate.getName(), box.getName());
		activateBoxControl.activateBox(pirate, box);
	}



	@Override
	public int throwDice(String player) {
		Random ran = new Random();
		int de1 = ran.nextInt(6);
		int de2 = ran.nextInt(6);
		
		int movement = de1 + de2;
		boundary.throwDice(movement);
		
		if(de1 == de2) {
			playAgain = true;
		}
		else {
			playAgain = false;
		}
		return movement;
	}

	public boolean isPlayAgain() {
		return playAgain;
	}
	
	
}