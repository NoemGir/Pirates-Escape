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
        private Dice dice;

	private boolean playAgain = false;


	public MoveControl(IBoundary boundary, ActivateBoxControl activateBoxControl, Board board) {
		this.boundary = boundary;
		this.activateBoxControl = activateBoxControl;
		this.board = board;
                this.dice = new Dice();
	}

	public void throwAndMove(Pirate pirate) {
		int d1 = dice.throwDice();
                int d2 = dice.throwDice();
                int distance = d1+d2;
		move(pirate, dis"tance);
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
		int de1 = ran.nextInt(6)+1;
		int de2 = ran.nextInt(6)+1;
		int movement = de1 + de2;
		boundary.throwDice1(de1);
		boundary.throwDice2(de2);
		playAgain =de1 == de2;
		return movement;
	}

	public boolean isPlayAgain() {
		return playAgain;
	}


}
