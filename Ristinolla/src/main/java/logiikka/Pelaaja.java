/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author Wade
 */
public class Pelaaja {
    
    String nimi;
    Peli peli;
    public Pelaaja(String tuotuNimi){
        nimi = tuotuNimi;
        
    }
    public String pelaajanNimi(){
        return nimi;
    }
    
}
