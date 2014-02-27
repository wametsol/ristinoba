package logiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import logiikka.Pelaaja;

/**
 *
 * @author Wade
 */
public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaNimenOikein(){
        Pelaaja olli = new Pelaaja("olli");
        assertEquals("olli", olli.pelaajanNimi());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
