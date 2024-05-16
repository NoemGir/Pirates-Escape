import java.util.ArrayList;
import java.util.List;
import model.entities.Pirate;
import model.entities.SwapCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Class de test pour la classe SwapCase.
 * 
 * @author Corentin JERE
 */
public class TestSwapCase{
    private Pirate p1;
    private Pirate p2;
    private List<Pirate> pirates = new ArrayList();
    private SwapCase nc;
    
    /**
     * @author Corentin JERE
     */
    @BeforeEach
    public void setUp(){
        p1 = new Pirate(2, "p1", 5);
        p1.setPosition(1);
        p2 = new Pirate(1, "p2", 5);
        nc = new SwapCase(1);
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
        assertEquals(1, p2.getPosition());
        assertEquals(0, p1.getPosition());
        nc.effect().accept(pirates, p2);
        assertEquals(1, p1.getPosition());
        assertEquals(0, p2.getPosition());
        // MEME CASE => COMBAT
        p2.setPosition(1);
        nc.effect().accept(pirates, p1);
        assertEquals(1, p1.getPosition());
        assertEquals(1, p1.getPosition());
        assertEquals(4, p1.getHp());
        assertEquals(4, p2.getHp());
        nc.effect().accept(pirates, p2);
        assertEquals(1, p2.getPosition());
        assertEquals(1, p1.getPosition());
        assertEquals(3, p2.getHp());
        assertEquals(3, p1.getHp());
    }
}
