import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.entities.*;

/**
 * Class regroupant toutes les méthodes de tests nécessaires pour la classe Pirate, avec l'utilisation de Stream pour ajouter un peu de lambda.
 * 
 * @author Corentin JERE
 */
public class TestPirate {
    private Pirate p1_1_5_0 = new Pirate(1, "p1", 5);
    private Pirate p1_2_5_0 = new Pirate(2, "p1", 5);
    private Pirate p3_1_5_0 = new Pirate(1, "Pirate 1", 5);
    private Pirate p1_1_4_0 = new Pirate(1, "p1", 4);
    private Pirate p1_1_5_10 = new Pirate(1, "p1", 5);
    private Pirate p1_2_5_30 = new Pirate(2, "p1", 5);
    private Pirate p = new Pirate(1, "p1", 5);
    private Pirate pDead = new Pirate(1, "p1", 0);
    private List<LambdaTestStructure> listeDesTestsStruct = new ArrayList();
    
    /**
    * Class interne servant de structure pour l'utilisation des stream avec les assertEquals
    * 
    * @author Corentin JERE
    */ 
    public class LambdaTestStructure{
        protected Pirate pirate;
        protected Object optionalArg;
        protected Object result;
        
        public LambdaTestStructure(Pirate pirate, Object result){
            this.pirate = pirate;
            this.result = result;
        }
        public LambdaTestStructure(Pirate pirate, Object optionalArg, Object result){
            this.pirate = pirate;
            this.optionalArg = optionalArg;
            this.result = result;
        }
    }
    
    /** 
    * @author Corentin JERE
    */
    @BeforeEach
    public void setUp() {
        p1_1_5_0 = new Pirate(1, "p1", 5);
        p1_2_5_0 = new Pirate(2, "p1", 5);
        p3_1_5_0 = new Pirate(1, "Pirate 1", 5);
        p1_1_4_0 = new Pirate(1, "p1", 4);
        p1_1_5_10 = new Pirate(1, "p1", 5);
        p1_1_5_10.ajustPosition((x)->x+10);
        p1_2_5_30 = new Pirate(2, "p1", 5);
        p1_2_5_30.ajustPosition((x)->x+30);
        p = new Pirate(1, "p1", 5);
        pDead = new Pirate(1, "p1", 0);
        listeDesTestsStruct.clear();
    }
  
    /** 
    * @author Corentin JERE
    */
    @Test
    public void testGettersSetters(){
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, new Object[]{(String)"p1",(Integer)1,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, new Object[]{(String)"p1",(Integer)2,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p3_1_5_0, new Object[]{(String)"Pirate 1",(Integer)1,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_4_0, new Object[]{(String)"p1",(Integer)1,(Integer)4,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_10, new Object[]{(String)"p1",(Integer)1,(Integer)5,(Integer)10}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_30, new Object[]{(String)"p1",(Integer)2,(Integer)5,(Integer)30}));
        listeDesTestsStruct.add(new LambdaTestStructure(p, new Object[]{(String)"p1",(Integer)1,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(pDead, new Object[]{(String)"p1",(Integer)1,(Integer)0,(Integer)0}));
        
        
        Consumer<LambdaTestStructure> consumerTest = (LambdaTestStructure elt) -> {
            assertEquals((String)((Object[])elt.result)[0], elt.pirate.getName());
            assertEquals((Integer)((Object[])elt.result)[1], elt.pirate.getIdPirate());
            assertEquals((Integer)((Object[])elt.result)[2], elt.pirate.getHp());
            assertEquals((Integer)((Object[])elt.result)[3], elt.pirate.getPosition());
        };
        
        // Utilisation d'un stream !!!
        listeDesTestsStruct.stream().forEach( consumerTest );
        
        p.setName("TestName");
        assertEquals("TestName", p.getName());
        p.setPosition(25);
        assertEquals(25, p.getPosition());
    }
    
    /** 
    * @author Corentin JERE
    */
    @Test
    public void testEquals(){
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, p1_1_5_0, true));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, p1_2_5_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, p3_1_5_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, p1_1_4_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, p1_1_5_10, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, p1_2_5_30, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, pDead, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, p, true));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, p1_1_5_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, p1_2_5_0, true));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, p3_1_5_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, p1_1_4_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, p1_1_5_10, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, p1_2_5_30, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, pDead, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, p, false));
        
        
        Consumer<LambdaTestStructure> consumerTest = (LambdaTestStructure elt) -> {
            assertEquals(elt.result, elt.pirate.equals(elt.optionalArg));
        };
        
        // Utilisation d'un stream !!!
        listeDesTestsStruct.stream().forEach( consumerTest );
    }
    
    /** 
    * @author Corentin JERE
    */
    @Test
    public void testIsDead(){
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p3_1_5_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_4_0, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_10, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_30, false));
        listeDesTestsStruct.add(new LambdaTestStructure(p, false));
        listeDesTestsStruct.add(new LambdaTestStructure(pDead, true));
        
        
        Consumer<LambdaTestStructure> consumerTest = (LambdaTestStructure elt) -> {
            assertEquals((Boolean)(elt.result), (Boolean)(elt.pirate.isDead()));
        };
        
        // Utilisation d'un stream !!!
        listeDesTestsStruct.stream().forEach( consumerTest );
    }
    
    /** 
    * @author Corentin JERE
    */
    @Test
    public void testAjustHp(){
        Function<Integer, Integer> fP1 = (Integer x) -> x+1;
        Function<Integer, Integer> fM1 = (Integer x) -> x-1;
        Function<Integer, Integer> fP3 = (Integer x) -> x+3;
        Function<Integer, Integer> fM7 = (Integer x) -> x-7;
        Function<Integer, Integer>[] fonctions = new Function[]{fM1, fP1, fP3, fM7};
        
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, fonctions, new Object[]{(Integer)4,(Integer)5,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, fonctions, new Object[]{(Integer)4,(Integer)5,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p3_1_5_0, fonctions, new Object[]{(Integer)4,(Integer)5,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_4_0, fonctions, new Object[]{(Integer)3,(Integer)4,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_10, fonctions, new Object[]{(Integer)4,(Integer)5,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_30, fonctions, new Object[]{(Integer)4,(Integer)5,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(p, fonctions, new Object[]{(Integer)4,(Integer)5,(Integer)5,(Integer)0}));
        listeDesTestsStruct.add(new LambdaTestStructure(pDead, fonctions, new Object[]{(Integer)0,(Integer)1,(Integer)4,(Integer)0}));
        
        
        Consumer<LambdaTestStructure> consumerTest = (LambdaTestStructure elt) -> {
            for (int i=0; i<4; i++){
                elt.pirate.ajustHp((Function<Integer,Integer>)( ((Object[])elt.optionalArg)[i] ));
                assertEquals((Integer)( ((Object[])elt.result)[i] ), elt.pirate.getHp());
            }
        };
        
        // Utilisation d'un stream !!!
        listeDesTestsStruct.stream().forEach( consumerTest );
    }
    
    /** 
    * @author Corentin JERE
    */
    @Test
    public void testAjustPosition(){
        Function<Integer, Integer> fP10 = (Integer x) -> x+10;
        Function<Integer, Integer> fM5 = (Integer x) -> x-5;
        Function<Integer, Integer>[] fonctions = new Function[]{fP10, fM5};
        
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_0, fonctions, new Object[]{(Integer)10,(Integer)5}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_0, fonctions, new Object[]{(Integer)10,(Integer)5}));
        listeDesTestsStruct.add(new LambdaTestStructure(p3_1_5_0, fonctions, new Object[]{(Integer)10,(Integer)5}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_4_0, fonctions, new Object[]{(Integer)10,(Integer)5}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_1_5_10, fonctions, new Object[]{(Integer)20,(Integer)15}));
        listeDesTestsStruct.add(new LambdaTestStructure(p1_2_5_30, fonctions, new Object[]{(Integer)40,(Integer)35}));
        listeDesTestsStruct.add(new LambdaTestStructure(p, fonctions, new Object[]{(Integer)10,(Integer)5}));
        listeDesTestsStruct.add(new LambdaTestStructure(pDead, fonctions, new Object[]{(Integer)10,(Integer)5}));
        
        
        Consumer<LambdaTestStructure> consumerTest = (LambdaTestStructure elt) -> {
            for (int i=0; i<2; i++){
                elt.pirate.ajustPosition((Function<Integer,Integer>)( ((Object[])elt.optionalArg)[i] ));
                assertEquals((Integer)( ((Object[])elt.result)[i] ), elt.pirate.getPosition());
            }
        };
        
        // Utilisation d'un stream !!!
        listeDesTestsStruct.stream().forEach( consumerTest );
    }
}
