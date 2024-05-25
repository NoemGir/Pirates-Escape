import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BoundaryForTestingPurpose.TestPirateGameBoundary;
import control.ActivateBoxControl;
import control.MoveControl;
import control.PirateGameControl;
import control.VerifyEndGameControl;
import model.entities.Board;
import model.entities.Case;
import model.entities.FinishLine;
import model.entities.GargamelleCase;
import model.entities.LuckyLukeShadowCase;
import model.entities.MrKrabsCase;
import model.entities.NurseCase;
import model.entities.Pirate;
import model.entities.PortalCase;
import model.entities.StartCase;
import model.entities.SwapCase;

class TestMoveControl {
	
	 private int NB_CASES = 30;
     private Board board ;
     private LinkedList<Pirate> listPirate ;
     private TestPirateGameBoundary boundary;
     private ActivateBoxControl activateBoxControl ;
     private MoveControl moveControl;
     private VerifyEndGameControl verifyEndGameControl ;
     private PirateGameControl pirateGameControl;
     
    public TestMoveControl() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board(NB_CASES);
         for(int i = 0; i < NB_CASES; i++) {
            switch(i){
                case 0:
                    board.addCase(new StartCase(i));
                    break;
                case 6:
                    board.addCase(new PortalCase(i));
                    break;
                case 15:
                    board.addCase(new GargamelleCase(i));
                    break;
                case 23:
                    board.addCase(new MrKrabsCase(i));
                    break;
                case 7:
                    board.addCase(new NurseCase(i));
                    break;
                case 27:
                    board.addCase(new LuckyLukeShadowCase(i));
                    break;
                case 28:
                    board.addCase(new SwapCase(i));
                    break;
                case 29:
                   board.addCase(new FinishLine(i));
                   break;
                default:
                   board.addCase(new Case(i));
            }
         }
        boundary = new TestPirateGameBoundary();
        activateBoxControl = new ActivateBoxControl(boundary);
        moveControl = new MoveControl(boundary, board);
        verifyEndGameControl = new VerifyEndGameControl(boundary);
        pirateGameControl = new PirateGameControl(board, boundary,moveControl, verifyEndGameControl, activateBoxControl);
       
        moveControl.setPirateGameControl(pirateGameControl);
        listPirate = new LinkedList<>();
        listPirate.add(new Pirate(0, "Toto", 5));
        listPirate.add(new Pirate(1, "Tata", 5));
        for(Pirate p : listPirate) {
        	board.addPlayer(p);
        }
    }
    
    
    @Test
    void testMove(){
    	Pirate toto = listPirate.get(0);
    	Pirate tata = listPirate.get(1);
    	
    	moveControl.move(toto, 1);
    	assertEquals(toto.getPosition(),1);
    	
    	moveControl.move(tata, 30);
    	assertEquals(tata.getPosition(),28);
    	
    	moveControl.move(toto, 7);
    	assertEquals(toto.getPosition(),8);
    	
    	moveControl.move(tata, 9);
    	assertEquals(tata.getPosition(),21);
    }
    
    @Test
    void testThrowDiceMovement(){
    	assertEquals(moveControl.getFirstDiceDisplay(), 1);
    	assertEquals(moveControl.getFirstDiceDisplay(), 1);
    	
    	boolean different = false;
    	//vérification si le premier dé change 
    	for(int i = 0; i < 10 && !different; i++) {
        	moveControl.throwDiceMovement();
        	if(moveControl.getFirstDiceDisplay() != 1) {
        		different = true;
        	}
    	}
    	//vérification si le second dé change 
    	for(int i = 0; i < 10; i++) {
        	moveControl.throwDiceMovement();
        	if(moveControl.getSecondDiceDisplay() != 1) {
        		different = different & true;
        		break;
        	}
    	}
    	//vérification si les deux dés sont différents
    	for(int i = 0; i < 10; i++) {
        	moveControl.throwDiceMovement();
        	if(moveControl.getSecondDiceDisplay() != moveControl.getFirstDiceDisplay()) {
        		different = different & true;
        		break;
        	}
    	}
    	
    	assertTrue(different);
    }
    
    @Test
    void testDoubleDicesFinished(){   	
    	Pirate toto = listPirate.get(0);
    	Pirate tata = listPirate.get(1);
    	pirateGameControl.setActivePlayer(toto);
    	
    	moveControl.setFirstDiceDisplay(2);
    	moveControl.setSecondDiceDisplay(2);
    	
    	moveControl.doubleDicesFinished();
    	assertEquals(toto.getPosition(),4);

    	moveControl.setFirstDiceDisplay(9);
    	moveControl.setSecondDiceDisplay(10);
    	
    	moveControl.doubleDicesFinished();
    	assertEquals(toto.getPosition(),23);
    	
    	moveControl.setFirstDiceDisplay(5);
    	moveControl.setSecondDiceDisplay(6);
    	
    	moveControl.doubleDicesFinished();
    	assertEquals(toto.getPosition(),24);
    	
    	pirateGameControl.setActivePlayer(tata);

    	moveControl.doubleDicesFinished();
    	assertEquals(tata.getPosition(),11);
    	assertEquals(toto.getPosition(),24);
    	
    }
    
    @Test
    void testPlayAgain(){
    	assertTrue(moveControl.playAgain());
    	
    	moveControl.setFirstDiceDisplay(2);
    	moveControl.setSecondDiceDisplay(2);
    	
    	assertTrue(moveControl.playAgain());
    	
    	moveControl.setFirstDiceDisplay(1);
    	
    	assertFalse(moveControl.playAgain());
    	
    	moveControl.setSecondDiceDisplay(5);
    	
    	assertFalse(moveControl.playAgain());
    
    	moveControl.setFirstDiceDisplay(5);
    	
    	assertTrue(moveControl.playAgain());
    }
    
    @Test
    void testMoveFinished(){
    	pirateGameControl.setActivePlayer(listPirate.get(0));
    	moveControl.move(listPirate.get(0), 29);
    	moveControl.setFirstDiceDisplay(-1);
    	moveControl.setSecondDiceDisplay(-1);
    	
    	moveControl.moveFinished();
    	
    	assertEquals(-1, moveControl.getFirstDiceDisplay());
    	assertEquals(-1, moveControl.getSecondDiceDisplay());
    	assertEquals(listPirate.get(0), pirateGameControl.getActivePirate());
    	
    }
    
    
    

}
