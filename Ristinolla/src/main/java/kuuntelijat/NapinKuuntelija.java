/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import logiikka.Pelaaja;
import logiikka.Peli;

/**
 *
 * @author Wade
 */
public class NapinKuuntelija implements ActionListener {

    JButton helppo, normaali, vaikea;
    Pelaaja eka, toka;
    JTextField pelaajaX, pelaajaO;
    public NapinKuuntelija(JTextField ekapelaaja, JTextField tokapelaaja, JButton helppo, JButton vaikea, JButton normaali){
        pelaajaX = ekapelaaja;
        pelaajaO = tokapelaaja;
        this.helppo = helppo;
        this.vaikea = vaikea;
        this.normaali = normaali;
        
        
    }
    /**Metodi lukee nappien painalluksia ja luo pelin valitulla vaikeustasolla.
     * 
     * 
     * @param e Käyttäjän painama nappi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        eka = new Pelaaja(pelaajaX.getText());
        toka = new Pelaaja(pelaajaO.getText());
        
        if(e.getSource() == helppo){
            Peli easy = new Peli(3, eka, toka);
            easy.luoPeli();
        }
        if (e.getSource() == normaali){
            Peli normal = new Peli(4, eka, toka);
            normal.luoPeli();
        }
        if (e.getSource() == vaikea){
        Peli hard = new Peli(5, eka, toka);
        hard.luoPeli();
        }
    }
    
}
