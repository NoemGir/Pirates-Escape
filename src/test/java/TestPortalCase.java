import java.util.ArrayList;
import java.util.List;
import model.entities.Pirate;
import model.entities.PortalCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Class de test pour la classe PortalCase.
 * 
 * @author Corentin JERE
 */
public class TestPortalCase{
    private Pirate p1;
    private Pirate p2;
    private List<Pirate> pirates = new ArrayList();
    private PortalCase nc;
    
    /**
     * @author Corentin JERE
     */
    @BeforeEach
    public void setUp(){
        p1 = new Pirate(2, "p1", 5);
        p1.setPosition(1);
        p2 = new Pirate(1, "p2", 5);
        nc = new PortalCase(1);
        pirates.clear();
        pirates.add(p1);
        pirates.add(p2);
    }
        
    /**
     * @author Corentin JERE
     */
    @Test
    public void testEffect(){
        p2.setPosition(1);
        assertEquals(1, p1.getPosition());
        assertEquals(1, p2.getPosition());
        assertEquals(5, p1.getHp());
        assertEquals(5, p2.getHp());
        nc.effect().accept(pirates, p1);
        assertEquals(1, p2.getPosition());
        assertEquals(6, p1.getPosition());
        assertEquals(5, p2.getHp());
        assertEquals(2, p1.getHp());
        nc.effect().accept(pirates, p2);
        assertEquals(6, p1.getPosition());
        assertEquals(6, p2.getPosition());
        assertEquals(1, p2.getHp());
        assertEquals(1, p1.getHp());
    }
}
