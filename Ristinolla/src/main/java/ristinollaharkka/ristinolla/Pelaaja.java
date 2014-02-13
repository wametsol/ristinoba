/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinollaharkka.ristinolla;

/**
 *
 * @author Wade
 */
public class Pelaaja {
    
    String nimi;
    Peli peli;
    public Pelaaja(String tuotuNimi){
        nimi = tuotuNimi;
        //peli = tuotuPeli;
    }
    /**Metodi palauttaa pelaajan nimen.
     * 
     * @return Palauttaa pelaajan nimen.
     * 
     * Turha
     */
    public String pelaajanNimi(){
        return nimi;
    }
    /**
     * Metodi palauttaa pelaajan nimen.
     * 
     * @return Pelaajan nimi.
     */
    @Override
    public String toString(){
        return nimi;
    }
}
