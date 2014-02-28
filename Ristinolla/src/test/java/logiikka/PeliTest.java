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
    Peli peliNormaali,peliHelppo,peliVaikea;
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
        peliHelppo = new Peli(3, yksi, kaksi);
        peliNormaali = new Peli(4, yksi, kaksi);
        peliVaikea = new Peli(5, yksi, kaksi);
        peliNormaali.luoPeli();
        peliHelppo.luoPeli();
        peliVaikea.luoPeli();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tarkistaNormaaliVaakaEiVoittojaTyhjallaPelilla(){
        assertEquals(peliNormaali.tarkistaNormaaliVaaka("X"),false);
        assertEquals(peliNormaali.tarkistaNormaaliVaaka("O"),false);
    }
    @Test
    public void tarkistaNormaaliPystyEiVoittojaTyhjallaPelilla(){
        assertEquals(peliNormaali.tarkistaNormaaliPysty("X"),false);
        assertEquals(peliNormaali.tarkistaNormaaliPysty("O"),false);
    }
    @Test
    public void tarkistaNormaaliVinoEiVoittojaTyhjallaPelilla(){
        assertEquals(peliNormaali.tarkistaNormaaliVino("X"),false);
        assertEquals(peliNormaali.tarkistaNormaaliVino("O"),false);
    }
    @Test
    public void tarkistaHelppoVaakaEiVoittojaTyhjallaPelilla(){
        assertEquals(peliHelppo.tarkistaHelppoVaaka("X"),false);
        assertEquals(peliHelppo.tarkistaHelppoVaaka("O"),false);
    }
    @Test
    public void tarkistaHelppoPystyEiVoittojaTyhjallaPelilla(){
        assertEquals(peliHelppo.tarkistaHelppoPysty("X"),false);
        assertEquals(peliHelppo.tarkistaHelppoPysty("O"),false);
    }
    @Test
    public void tarkistaHelppoVinoEiVoittojaTyhjallaPelilla(){
        assertEquals(peliHelppo.tarkistaHelppoVino("X"),false);
        assertEquals(peliHelppo.tarkistaHelppoVino("O"),false);
    }
    @Test
    public void tarkistaVaikeaPystyEiVoittojaTyhjallaPelilla(){
        assertEquals(peliVaikea.tarkistaVaikeaPysty("X"),false);
        assertEquals(peliVaikea.tarkistaVaikeaPysty("O"),false);
    }
    @Test
    public void tarkistaVaikeaVaakaEiVoittojaTyhjallaPelilla(){
        assertEquals(peliVaikea.tarkistaVaikeaVaaka("X"),false);
        assertEquals(peliVaikea.tarkistaVaikeaVaaka("O"),false);
    }
    @Test
    public void tarkistaVaikeaVinoEiVoittojaTyhjallaPelilla(){
        assertEquals(peliVaikea.tarkistaVaikeaVino("X"),false);
        assertEquals(peliVaikea.tarkistaVaikeaVino("O"),false);
    }
    @Test
    public void tarkistaEiVoittojaTyhjallaPelilla(){
        assertEquals(peliNormaali.tarkista("X"),false);
        assertEquals(peliNormaali.tarkista("O"),false);
        assertEquals(peliHelppo.tarkista("X"),false);
        assertEquals(peliHelppo.tarkista("O"),false);
        assertEquals(peliVaikea.tarkista("X"),false);
        assertEquals(peliVaikea.tarkista("O"),false);
    }
    @Test
    public void tarkistaVoittaminenToimii(){
        assertEquals(peliNormaali.tarkista(""),true);
    }
    @Test
    public void tarkistaHelppoVaakaToimii(){
        assertEquals(peliNormaali.tarkistaHelppoVaaka(""),true);
    }
    @Test
    public void tarkistaHelppoPystyToimii(){
        assertEquals(peliNormaali.tarkistaHelppoPysty(""),true);
    }
    @Test
    public void tarkistaHelppoVinoToimii(){
        assertEquals(peliNormaali.tarkistaHelppoVino(""),true);
    }
    @Test
    public void tarkistaNormaaliVaakaToimii(){
        assertEquals(peliNormaali.tarkistaNormaaliVaaka(""),true);
    }
    @Test
    public void tarkistaNormaaliPystyToimii(){
        assertEquals(peliNormaali.tarkistaNormaaliPysty(""),true);
    }
    @Test
    public void tarkistaNormaaliVainoToimii(){
        assertEquals(peliNormaali.tarkistaNormaaliVino(""),true);
    }
    @Test
    public void tarkistaVaikeaVaakaToimii(){
        assertEquals(peliNormaali.tarkistaVaikeaVaaka(""),true);
    }
    @Test
    public void tarkistaVaikeaPystyToimii(){
        assertEquals(peliNormaali.tarkistaVaikeaPysty(""),true);
    }
    @Test
    public void tarkistaVaikeaVinoToimii(){
        assertEquals(peliNormaali.tarkistaVaikeaVino(""),true);
    }
    }
    
    
