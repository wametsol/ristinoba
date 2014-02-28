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
import logiikka.Peli;


/**
 *
 * @author Wade
 */
public class PeliTest {
    
    Pelaaja yksi,kaksi;
    Peli peli1,peli2,peli3;
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
        yksi = new Pelaaja("ykkonen");
        kaksi = new Pelaaja("kakkonen");
        peli2 = new Peli(3, yksi, kaksi);
        peli1 = new Peli(4, yksi, kaksi);
        peli3 = new Peli(5, yksi, kaksi);
        peli1.luoPeli();
        peli2.luoPeli();
        peli3.luoPeli();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tarkistaNormaaliVaakaEiVoittojaTyhjallaPelilla(){
        assertEquals(peli1.tarkistaNormaaliVaaka("X"),false);
        assertEquals(peli1.tarkistaNormaaliVaaka("O"),false);
    }
    @Test
    public void tarkistaNormaaliPystyEiVoittojaTyhjallaPelilla(){
        assertEquals(peli1.tarkistaNormaaliPysty("X"),false);
        assertEquals(peli1.tarkistaNormaaliPysty("O"),false);
    }
    @Test
    public void tarkistaNormaaliVinoEiVoittojaTyhjallaPelilla(){
        assertEquals(peli1.tarkistaNormaaliVino("X"),false);
        assertEquals(peli1.tarkistaNormaaliVino("O"),false);
    }
    @Test
    public void tarkistaHelppoVaakaEiVoittojaTyhjallaPelilla(){
        assertEquals(peli2.tarkistaHelppoVaaka("X"),false);
        assertEquals(peli2.tarkistaHelppoVaaka("O"),false);
    }
    @Test
    public void tarkistaHelppoPystyEiVoittojaTyhjallaPelilla(){
        assertEquals(peli2.tarkistaHelppoPysty("X"),false);
        assertEquals(peli2.tarkistaHelppoPysty("O"),false);
    }
    @Test
    public void tarkistaHelppoVinoEiVoittojaTyhjallaPelilla(){
        assertEquals(peli2.tarkistaHelppoVino("X"),false);
        assertEquals(peli2.tarkistaHelppoVino("O"),false);
    }
    @Test
    public void tarkistaVaikeaPystyEiVoittojaTyhjallaPelilla(){
        assertEquals(peli3.tarkistaVaikeaPysty("X"),false);
        assertEquals(peli3.tarkistaVaikeaPysty("O"),false);
    }
    @Test
    public void tarkistaVaikeaVaakaEiVoittojaTyhjallaPelilla(){
        assertEquals(peli3.tarkistaVaikeaVaaka("X"),false);
        assertEquals(peli3.tarkistaVaikeaVaaka("O"),false);
    }
    @Test
    public void tarkistaVaikeaVinoEiVoittojaTyhjallaPelilla(){
        assertEquals(peli3.tarkistaVaikeaVino("X"),false);
        assertEquals(peli3.tarkistaVaikeaVino("O"),false);
    }
    @Test
    public void tarkistaEiVoittojaTyhjallaPelilla(){
        assertEquals(peli1.tarkista("X"),false);
        assertEquals(peli1.tarkista("O"),false);
        assertEquals(peli2.tarkista("X"),false);
        assertEquals(peli2.tarkista("O"),false);
        assertEquals(peli3.tarkista("X"),false);
        assertEquals(peli3.tarkista("O"),false);
    }
    @Test
    public void tarkistaVoittaminenToimii(){
        assertEquals(peli1.tarkista(""),true);
    }
    @Test
    public void tarkistaHelppoVaakaToimii(){
        assertEquals(peli1.tarkistaHelppoVaaka(""),true);
    }
    @Test
    public void tarkistaHelppoPystyToimii(){
        assertEquals(peli1.tarkistaHelppoPysty(""),true);
    }
    @Test
    public void tarkistaHelppoVinoToimii(){
        assertEquals(peli1.tarkistaHelppoVino(""),true);
    }
    @Test
    public void tarkistaNormaaliVaakaToimii(){
        assertEquals(peli1.tarkistaNormaaliVaaka(""),true);
    }
    @Test
    public void tarkistaNormaaliPystyToimii(){
        assertEquals(peli1.tarkistaNormaaliPysty(""),true);
    }
    @Test
    public void tarkistaNormaaliVainoToimii(){
        assertEquals(peli1.tarkistaNormaaliVino(""),true);
    }
    @Test
    public void tarkistaVaikeaVaakaToimii(){
        assertEquals(peli1.tarkistaVaikeaVaaka(""),true);
    }
    @Test
    public void tarkistaVaikeaPystyToimii(){
        assertEquals(peli1.tarkistaVaikeaPysty(""),true);
    }
    @Test
    public void tarkistaVaikeaVinoToimii(){
        assertEquals(peli1.tarkistaVaikeaVino(""),true);
    }
    }
    
    
