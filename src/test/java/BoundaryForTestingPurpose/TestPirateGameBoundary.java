package BoundaryForTestingPurpose;

import control.IMovePirate;
import control.IThrowDice;
import control.PirateGameControl;
import java.util.Scanner;

import boundary.IBoundary;

/*
 * Boundary connectée aux Contols présents dans le package
 * "control"
 *
 * Boundary qui servira de sortie console
 */
public class TestPirateGameBoundary implements IBoundary{

    private PirateGameControl pirateGameControl;
    private IMovePirate movePirate;
    private IThrowDice throwDIce;

    @Override
    public void startGame() {
    }

    @Override
    public void movePirate( int idPirate, int boxNumber) {

    }

    @Override
    public void movePirateAuto(int idPirate, int boxNumber){

    }


    @Override
    public void displayPV(int idPirate, int health) {


    }

    @Override
    public void throwDoubleDice() {

    }

    @Override
    	public String askPirateName(int idPirate) {
    		return null;
    	}
    

    @Override
    public void endGame(int idPirate, String reason) {

    }


    @Override
    public void changePlayer(int idPirate) {

    }
        
    @Override
    public void playAgain(int idPirate) {
       
    }

    public void setPirateGameControl(PirateGameControl pirateGameControl) {
    }

    public void setMovePirate(IMovePirate movePirate) {
    }

    public void setThrowDIce(IThrowDice throwDIce) {
    }
}
