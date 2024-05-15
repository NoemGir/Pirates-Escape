import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BoundaryForTestingPurpose.TestPirateGameBoundary;
import control.VerifyEndGameControl;
import model.entities.Pirate;

class testVerifyEndControl {
	
	private LinkedList<Pirate> listPirate ;
    private VerifyEndGameControl verifyEndGameControl ;
    private TestPirateGameBoundary boundary;

    private Pirate toto;
    private Pirate tata;
    private Pirate titi;
    private Pirate tutu;
    private Pirate tete;
	
    @BeforeEach
    public void setUp() {
       
        boundary = new TestPirateGameBoundary();
        verifyEndGameControl = new VerifyEndGameControl(boundary);
       
        toto = new Pirate(0, "Toto", 5);
        tata = new Pirate(1, "Tata", 5);
		titi = new Pirate(2, "Titi", 5);
		tutu = new Pirate(3, "Tutu", 5);
		tete = new Pirate(4, "Tete", 5);
		
        listPirate = new LinkedList<>();
        listPirate.add(toto);
        listPirate.add(tata);
        listPirate.add(titi);
        listPirate.add(tutu);
        listPirate.add(tete);
    }

	@Test
	void testGameEnded() {
		toto.setPosition(29);
		assertTrue(verifyEndGameControl.gameEnded(listPirate, toto));
		assertFalse(verifyEndGameControl.gameEnded(listPirate, tata));
		toto.setPosition(5);
		assertFalse(verifyEndGameControl.gameEnded(listPirate, toto));
		tata.ajustHp((e) -> e-2);
		assertFalse(verifyEndGameControl.gameEnded(listPirate, toto));
		assertFalse(verifyEndGameControl.gameEnded(listPirate, tata));
		titi.ajustHp((e) -> e-5);
		assertFalse(verifyEndGameControl.gameEnded(listPirate, titi));
		tata.ajustHp((e) -> e-3);
		assertFalse(verifyEndGameControl.gameEnded(listPirate, tete));
		toto.ajustHp((e) -> e-5);
		assertFalse(verifyEndGameControl.gameEnded(listPirate, tata));
		tete.ajustHp((e) -> e-5);
		assertTrue(verifyEndGameControl.gameEnded(listPirate, toto));
		tutu.ajustHp((e) -> e-5);
		assertTrue(verifyEndGameControl.gameEnded(listPirate, tutu));
		assertTrue(verifyEndGameControl.gameEnded(listPirate, toto));
		assertTrue(verifyEndGameControl.gameEnded(listPirate, tata));
		assertTrue(verifyEndGameControl.gameEnded(listPirate, titi));
		assertTrue(verifyEndGameControl.gameEnded(listPirate, tete));
		titi.ajustHp((e) -> e+4);
		assertTrue(verifyEndGameControl.gameEnded(listPirate, titi));
		toto.ajustHp((e) -> e+1);
		assertFalse(verifyEndGameControl.gameEnded(listPirate, titi));
		titi.setPosition(29);
		assertTrue(verifyEndGameControl.gameEnded(listPirate, titi));
	}
	
	@Test
	void testCountDeath() {
		for(Pirate pirate : listPirate) {
			pirate.ajustHp((e) -> e-5);
		}
		
		assertTrue(verifyEndGameControl.countDeath(listPirate));
		
		toto.ajustHp((e) -> e+1);
		
		assertTrue(verifyEndGameControl.countDeath(listPirate));
		
		toto.ajustHp((e) -> e+1);
		
		assertTrue(verifyEndGameControl.countDeath(listPirate));
		
		tutu.ajustHp((e) -> e+1);
		
		assertFalse(verifyEndGameControl.countDeath(listPirate));
		
		tutu.ajustHp((e) -> e-1);
		
		assertTrue(verifyEndGameControl.countDeath(listPirate));

	}
	
	@Test
	void testReachedEnd() {
		toto.setPosition(5);
		
		assertFalse(verifyEndGameControl.reachedEnd(titi));
		assertFalse(verifyEndGameControl.reachedEnd( toto));

		tata.setPosition(30);
		
		assertFalse(verifyEndGameControl.reachedEnd(tata));
		
		tete.setPosition(28);
		
		assertFalse(verifyEndGameControl.reachedEnd(tete));
		
		titi.setPosition(29);
		
		assertTrue(verifyEndGameControl.reachedEnd(titi));
		assertFalse(verifyEndGameControl.reachedEnd(tata));
		assertFalse(verifyEndGameControl.reachedEnd(tete));
		assertFalse(verifyEndGameControl.reachedEnd(toto));
		assertFalse(verifyEndGameControl.reachedEnd(tutu));

	}
	
	
	
	

}
