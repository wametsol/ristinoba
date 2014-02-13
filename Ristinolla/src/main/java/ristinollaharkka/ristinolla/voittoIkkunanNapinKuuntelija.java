/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinollaharkka.ristinolla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Wade
 */
public class voittoIkkunanNapinKuuntelija implements ActionListener {

    JButton joo, ei, scoret;
    JFrame raami;
    Peli peli;
    public voittoIkkunanNapinKuuntelija(JButton joo, JButton ei, JButton scoret, JFrame frame, Peli peli){
        this.joo = joo;
        this.ei = ei;
        this.scoret = scoret;
        raami = frame;
        this.peli = peli;
        
    }
    /**Kuuntelee napinpainalluksia ja joko luo uuden pelin, sulkee ohjelman tai tuo tuloslistan.
     * 
     * @param e Painettu nappi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==joo){
            peli.nollaaVuoro();
            raami.setVisible(false);
            
        }
        if (e.getSource()==ei){
            System.exit(0);
        }
        if (e.getSource() == scoret){
            
        }
    }
    
}
