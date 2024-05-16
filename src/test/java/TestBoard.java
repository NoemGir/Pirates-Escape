import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entities.Board;
import model.entities.Case;
import model.entities.Pirate;

class TestBoard {
	
	
	private Board board;
	private Pirate pirateTest1;
	
	

	
	@BeforeEach
    public void setUp() {
		board = new Board(15);
		
		pirateTest1 = new Pirate(0, "PirateTest1", 5);
		board.addPlayer(pirateTest1);
		
		
		for(int i = 0; i < board.getNbCase(); i++) {
			board.addCase(new Case(i));
		}
	}

	@Test
	void testMove() {
		String nomTest;
		int distanceTest;
		//JT1
		nomTest = "PirateTest4";               //pirate inconnu -> invalide
		distanceTest = -3;                     // distance < 0 -> invalide
		testJeuDeTest(nomTest, distanceTest);
		//JT2
		pirateTest1.setPosition(-7);            // position < 0 -> invalide
		nomTest = "PirateTest1";                // pirate connu -> valide
		distanceTest = 2;                       // 0 <= distance < nbCase -> valide
		testJeuDeTest(nomTest, distanceTest);
		//JT3
		pirateTest1.setPosition(6);             // 0 <= position < nbCase -> valide
		nomTest = "PirateTest1";                // pirate connu -> valide
		distanceTest = 4;                       // 0 <= distance < nbCase -> valide
		testJeuDeTest(nomTest, distanceTest);
		//JT4
		pirateTest1.setPosition(2);             // 0 <= position < nbCase -> valide
		nomTest = "PirateTest5"; 				// pirate inconnu -> invalide
		distanceTest = 5; 						// position + distance < nbCase -> valide
		testJeuDeTest(nomTest, distanceTest);
		//JT5
		pirateTest1.setPosition(7); 			// 0 <= position < nbCase -> valide
		nomTest = "PirateTest1"; 				// pirate connu -> valide
		distanceTest = 5; 						// position + distance < nbCase -> valide
		testJeuDeTest(nomTest, distanceTest);
		//JT6
		pirateTest1.setPosition(13); 			// 0 <= position < nbCase -> valide
		nomTest = "PirateTest1"; 				// pirate connu -> valide
		distanceTest = 9; 						// position + distance >= nbCase -> valide
		testJeuDeTest(nomTest, distanceTest);		
		//JT7
		pirateTest1.setPosition(20); 			// position >= nbcase -> invalide
		nomTest = "PirateTest1"; 				// pirate connu -> valide
		distanceTest = 13; 						// position + distance >= nbCase -> valide
		testJeuDeTest(nomTest, distanceTest);
		//JT8
		pirateTest1.setPosition(60); 			// 0 <= position < nbCase -> valide
		nomTest = "PirateTest1";				// pirate connu -> valide
		distanceTest = 1; 						// distance >= nbCase -> invalide
		testJeuDeTest(nomTest, distanceTest);
		
	}

	public void testJeuDeTest(String nomTest, int distanceTest) {
		try {
			Case res = board.move(nomTest, distanceTest);
			System.out.println(" --> tombe sur " + res);
		}catch(Exception e) {
			System.err.println(" --> EXCEPTION ERROR");
		}
	}
}
