import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BoundaryForTestingPurpose.TestPirateGameBoundary;
import control.ActivateBoxControl;
import control.MoveControl;
import control.PirateGameControl;
import control.VerifyEndGameControl;
import model.entities.Board;
import model.entities.Case;
import model.entities.Pirate;
import model.entities.PortalCase;
import model.entities.SwapCase;

class TestPirateGameControl {
     private Board board ;
     private LinkedList<Pirate> listPirate ;
     private TestPirateGameBoundary boundaryTest;
     private ActivateBoxControl activateBoxControl ;
     private MoveControl moveControl;
     private VerifyEndGameControl verifyEndGameControl ;
     private PirateGameControl pirateGameControl;
	 
    @BeforeEach
    public void setUp() {
        board = new Board(10);
         for(int i = 0; i < 10; i++) {
            board.addCase(new Case(i));
         }
        boundaryTest = new TestPirateGameBoundary();
        activateBoxControl = new ActivateBoxControl(boundaryTest);
        moveControl = new MoveControl(boundaryTest, board);
        verifyEndGameControl = new VerifyEndGameControl(boundaryTest);
        pirateGameControl = new PirateGameControl(board, boundaryTest,moveControl, verifyEndGameControl, activateBoxControl);
       
        listPirate = new LinkedList<>();
        listPirate.add(new Pirate(0, "Toto", 5));
        listPirate.add(new Pirate(1, "Tata", 5));
        listPirate.add(new Pirate(2, "Titi", 5));
        for(Pirate p : listPirate) {
        	board.addPlayer(p);
        }  
    }
    
    @Test
    void testStartGame() {
    	pirateGameControl.startGame();
    	assertFalse(activateBoxControl.mustWait());
    	assertEquals(new Pirate(0, "Pirate0", 5), board.getListPirate().get(0));
    	assertEquals(new Pirate(1, "Pirate1", 5), board.getListPirate().get(1));
    	assertEquals(2, board.getListPirate().size());
    	assertEquals(pirateGameControl.getActivePirate(), board.getListPirate().get(0));
    }
    
    @Test
    void testNewPlayerTurn() {
    	pirateGameControl.setActivePlayer(listPirate.get(2));
    	pirateGameControl.setItPirate(board.getListPirate().listIterator());
    	listPirate.get(2).setPosition(29);
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(2), pirateGameControl.getActivePirate());
    	assertEquals(listPirate.get(2), board.getListPirate().get(2));
    	assertEquals(1, moveControl.getFirstDiceDisplay());
    	assertEquals(1, moveControl.getSecondDiceDisplay());
    	listPirate.get(2).setPosition(20);
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(0), pirateGameControl.getActivePirate());
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(1), pirateGameControl.getActivePirate());
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(2), pirateGameControl.getActivePirate());
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(0), pirateGameControl.getActivePirate());
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(1), pirateGameControl.getActivePirate());
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(2), pirateGameControl.getActivePirate());
    	listPirate.get(0).ajustHp((e) -> e-5);
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(1), pirateGameControl.getActivePirate());
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(2), pirateGameControl.getActivePirate());
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(1), pirateGameControl.getActivePirate());
    	listPirate.get(0).ajustHp((e) -> e+5);
    	listPirate.get(2).ajustHp((e) -> e-5);
    	System.out.println("new player turn");
    	pirateGameControl.newPlayerTurn();
    	assertEquals(listPirate.get(0), pirateGameControl.getActivePirate());
    	
    }
    
    @Test
    void testVerifyEndGameManagement() {
    	pirateGameControl.setActivePlayer(listPirate.get(0));
    	listPirate.get(0).setPosition(20);
    	assertFalse(pirateGameControl.verifyEndGameManagement());
    	listPirate.get(0).setPosition(29);
    	assertTrue(pirateGameControl.verifyEndGameManagement());
    	listPirate.get(1).setPosition(6);
    	assertTrue(pirateGameControl.verifyEndGameManagement());
    	listPirate.get(0).setPosition(28);
    	assertFalse(pirateGameControl.verifyEndGameManagement());
    	listPirate.get(0).setPosition(30);
    	assertFalse(pirateGameControl.verifyEndGameManagement());
    	listPirate.get(0).ajustHp((e) -> e-5);
    	assertFalse(pirateGameControl.verifyEndGameManagement());
    	listPirate.get(1).ajustHp((e) -> e-5);
    	assertTrue(pirateGameControl.verifyEndGameManagement());
    	listPirate.get(2).ajustHp((e) -> e-5);
    	assertTrue(pirateGameControl.verifyEndGameManagement());
    	listPirate.get(1).ajustHp((e) -> e+5);
    	listPirate.get(0).ajustHp((e) -> e+5);
    	assertFalse(pirateGameControl.verifyEndGameManagement());
    }
    
    
    @Test
    void testMoveFinished() {
    	pirateGameControl.setActivePlayer(listPirate.get(1));
    	listPirate.get(1).setPosition(29);
    	pirateGameControl.moveFinished(new Case(0));
    	assertEquals(1, moveControl.getFirstDiceDisplay());
    	assertEquals(1, moveControl.getSecondDiceDisplay());
    	assertEquals(listPirate.get(1), pirateGameControl.getActivePirate());
    	
    	listPirate.get(1).setPosition(20);
    	
    	moveControl.setFirstDiceDisplay(-1);
    	moveControl.setSecondDiceDisplay(-1);
    	
    	pirateGameControl.moveFinished(new Case(0));
    	assertEquals(listPirate.get(1), pirateGameControl.getActivePirate());
    	assertFalse(-1 == moveControl.getFirstDiceDisplay() && -1 == moveControl.getSecondDiceDisplay());

    	moveControl.setFirstDiceDisplay(-1);
    	moveControl.setSecondDiceDisplay(-6);
    	
    	pirateGameControl.setItPirate(listPirate.listIterator());
    	pirateGameControl.moveFinished(new Case(0));
    	assertEquals(listPirate.get(0), pirateGameControl.getActivePirate());
    	assertFalse(-1 == moveControl.getFirstDiceDisplay() && -6 == moveControl.getSecondDiceDisplay());

    	
    	moveControl.setFirstDiceDisplay(-1);
    	moveControl.setSecondDiceDisplay(-1);
    	
    	pirateGameControl.moveFinished(new PortalCase(0));
    	assertEquals(2, listPirate.get(0).getHp());
    	assertEquals(listPirate.get(0), pirateGameControl.getActivePirate());
    	assertEquals(-1, moveControl.getFirstDiceDisplay());
    	assertEquals(-1, moveControl.getSecondDiceDisplay());	
    }
    
    @Test
    void testGettersAndSetters() {
    	for(int i = 0; i < 10; i++) {
    		assertEquals(null, pirateGameControl.getBoxLink(i));
    		assertEquals(new Case(0).getName(), pirateGameControl.getCaseName(i));
    	}
    	board.addCase(new PortalCase(0));
    	assertNotEquals(null, pirateGameControl.getBoxLink(10));
    	assertEquals(new PortalCase(0).getName(), pirateGameControl.getCaseName(10));
    	
    	board.addCase(new SwapCase(0));
    	assertNotEquals(null, pirateGameControl.getBoxLink(11));
    	assertEquals(new SwapCase(0).getName(), pirateGameControl.getCaseName(11));
    	
    	assertEquals(listPirate.get(0).getName(), pirateGameControl.getPirateName(0));
    	assertEquals(listPirate.get(1).getName(), pirateGameControl.getPirateName(1));
    	assertEquals(listPirate.get(2).getName(), pirateGameControl.getPirateName(2));
    }
}
