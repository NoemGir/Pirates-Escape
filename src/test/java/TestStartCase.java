import java.util.ArrayList;
import java.util.List;
import model.entities.StartCase;
import model.entities.Pirate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class de test pour la classe StartCase.
 * 
 * @author Corentin JERE
 */
public class TestStartCase{
    private Pirate p1;
    private Pirate p2;
    private List<Pirate> pirates = new ArrayList();
    private StartCase nc;
    
    /**
     * @author Corentin JERE
     */
    @BeforeEach
    public void setUp(){
        p1 = new Pirate(2, "p1", 5);
        p1.setPosition(1);
        p2 = new Pirate(1, "p2", 5);
        nc = new StartCase(1);
        pirates.clear();
        pirates.add(p1);
        pirates.add(p2);
    }
        
    /**
     * @author Corentin JERE
     */
    @Test
    public void testEffect(){
        assertEquals(1, p1.getPosition());
        assertEquals(0, p2.getPosition());
        assertEquals(5, p1.getHp());
        assertEquals(5, p2.getHp());
        nc.effect().accept(pirates, p1);
        assertEquals(1, p1.getPosition());
        assertEquals(5, p1.getHp());
        nc.effect().accept(pirates, p2);
        assertEquals(0, p2.getPosition());
        assertEquals(5, p2.getHp());
        // MEME CASE => COMBAT
        p2.setPosition(1);
        nc.effect().accept(pirates, p1);
        assertEquals(1, p1.getPosition());
        assertEquals(4, p1.getHp());
        assertEquals(4, p2.getHp());
        nc.effect().accept(pirates, p2);
        assertEquals(1, p2.getPosition());
        assertEquals(3, p2.getHp());
        assertEquals(3, p1.getHp());
    }
}
