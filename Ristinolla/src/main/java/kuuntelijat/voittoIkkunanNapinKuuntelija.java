/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuuntelijat;

import gui.Pistetilasto;
import gui.Voittoikkuna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import logiikka.Peli;

/**
 *
 * @author Wade
 */
public class voittoIkkunanNapinKuuntelija implements ActionListener {

    JButton ok, joo, ei, scoret;
    JFrame raami;
    Peli peli;
    Voittoikkuna voittis;
    public voittoIkkunanNapinKuuntelija(Voittoikkuna voittoikkuna, JButton ok, JButton joo, JButton ei, JButton scoret, JFrame frame, Peli peli){
        this.ok = ok;
        this.joo = joo;
        this.ei = ei;
        this.scoret = scoret;
        raami = frame;
        this.peli = peli;
        voittis = voittoikkuna;
        
    }
    /**Kuuntelee napinpainalluksia ja joko luo uuden pelin, sulkee ohjelman tai tuo tuloslistan.
     * 
     * @param e Painettu nappi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ok){
            voittis.luoIkkuna();
        }
        if(e.getSource()==joo){
            peli.nollaaVuoro();
            raami.setVisible(false);
            
        }
        if (e.getSource()==ei){  
            System.exit(0);
        }
        if (e.getSource() == scoret){
            Pistetilasto tilasto = new Pistetilasto();
            tilasto.luoIkkuna();
        }
    }
    
}
