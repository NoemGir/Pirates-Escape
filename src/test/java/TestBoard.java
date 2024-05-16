import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entities.Board;
import model.entities.Case;
import model.entities.Pirate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class de test pour la classe Board.
 * 
 * @author Noemie
 * @author Corentin JERE
 */
class TestBoard {
    private Board board;
    private Pirate pirateTest1;
    private Pirate pirateTest2;
    private Pirate pirateTest3;
    private List<LambdaTestStructure> listeDesTestsStruct = new ArrayList();

    /**
    * Class interne servant de structure pour l'utilisation des stream avec les assertEquals
    * 
    * @author Corentin JERE
    */ 
    public class LambdaTestStructure{
        protected Pirate pirate;
        protected String str;
        
        public LambdaTestStructure(Pirate pirate, String str){
            this.pirate = pirate;
            this.str = str;
        }
    }
    
    /**
     * @author Corentin JERE
     */
    @BeforeEach
    public void setUp() {
        board = new Board(15);

        pirateTest1 = new Pirate(0, "PirateTest1", 5);
        pirateTest2 = new Pirate(0, "PirateTest2", 5);
        pirateTest3 = new Pirate(0, "", 5);
        board.addPlayer(pirateTest1);
        board.addPlayer(pirateTest2);
        board.addPlayer(pirateTest3);
        listeDesTestsStruct.clear();


        for(int i = 0; i < board.getNbCase(); i++) {
            board.addCase(new Case(i));
        }
    }

    /**
     * @author Noemie
     */
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
        nomTest = "PirateTest5"; 		// pirate inconnu -> invalide
        distanceTest = 5; 			// position + distance < nbCase -> valide
        testJeuDeTest(nomTest, distanceTest);
        //JT5
        pirateTest1.setPosition(7); 		// 0 <= position < nbCase -> valide
        nomTest = "PirateTest1"; 		// pirate connu -> valide
        distanceTest = 5; 			// position + distance < nbCase -> valide
        testJeuDeTest(nomTest, distanceTest);
        //JT6
        pirateTest1.setPosition(13); 		// 0 <= position < nbCase -> valide
        nomTest = "PirateTest1"; 		// pirate connu -> valide
        distanceTest = 9; 			// position + distance >= nbCase -> valide
        testJeuDeTest(nomTest, distanceTest);		
        //JT7
        pirateTest1.setPosition(20);            // position >= nbcase -> invalide
        nomTest = "PirateTest1"; 		// pirate connu -> valide
        distanceTest = 13; 			// position + distance >= nbCase -> valide
        testJeuDeTest(nomTest, distanceTest);
        //JT8
        pirateTest1.setPosition(60);            // 0 <= position < nbCase -> valide
        nomTest = "PirateTest1";		// pirate connu -> valide
        distanceTest = 1; 			// distance >= nbCase -> invalide
        testJeuDeTest(nomTest, distanceTest);
    }
    
    /**
     * @author Corentin JERE
     */
    @Test
    public void testGetPlayer(){
        listeDesTestsStruct.add( new LambdaTestStructure(pirateTest1, "PirateTest1") );
        listeDesTestsStruct.add( new LambdaTestStructure(pirateTest2, "PirateTest2") );
        listeDesTestsStruct.add( new LambdaTestStructure(pirateTest3, "") );
        listeDesTestsStruct.add( new LambdaTestStructure(null, " ") );
        listeDesTestsStruct.add( new LambdaTestStructure(null, "La Normalement ça va trouver personne") );
        
        Consumer<LambdaTestStructure> consumerTest = (LambdaTestStructure elt) -> {
            assertEquals(elt.pirate, board.getPlayer(elt.str));
        };
        
        listeDesTestsStruct.stream().forEach( consumerTest );
    }
    
    /**
     * @author Noemie 
     * 
     * @param nomTest
     * @param distanceTest 
     */
    public void testJeuDeTest(String nomTest, int distanceTest) {
        try {
            Case res = board.move(nomTest, distanceTest);
            System.out.println(" --> tombe sur " + res);
        }catch(Exception e) {
            System.err.println(" --> EXCEPTION ERROR");
        }
    }
}
