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
import ristinollaharkka.ristinolla.Pelaaja;
import ristinollaharkka.ristinolla.Peli;

/**
 *
 * @author Wade
 */
public class PeliTest {
    
    public PeliTest() {
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
    public void konstruktoriLuoPelinOikein(){
        
        Pelaaja yksi = new Pelaaja("ykkonen");
        Pelaaja kaksi = new Pelaaja("kakkonen");
        Peli peli = new Peli(4, yksi, kaksi);
        
        assertEquals("Pelaaja X: ykkonen, Pelaaja O: kakkonen. Vaikeusaste: 4", peli.toString());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
