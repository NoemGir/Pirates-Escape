/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import model.entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author corentin
 */
public class TestCase {
    
    public TestCase() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Pirate p5 = new Pirate(5, "p5", 5);
        Pirate p4 = new Pirate(4, "p4", 4);
        Pirate p3 = new Pirate(3, "p3", 3);
        Pirate p2 = new Pirate(2, "p2", 2);
        Pirate p1 = new Pirate(1, "p1", 1);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
