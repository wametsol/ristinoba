/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinollaharkka.ristinolla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

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
        Pelaaja X = new Pelaaja(ekapelaaja.getText());
        Pelaaja O = new Pelaaja(tokapelaaja.getText());
        eka = X;
        toka = O;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //if (eka.i)
        if(e.getSource() == helppo){
            System.out.println("hei");
            Peli easy = new Peli(3, eka, toka);
            easy.luoPeli();
        }
        if (e.getSource() == normaali){
            System.out.println("kukka");
            Peli normal = new Peli(4, eka, toka);
            normal.luoPeli();
        }
        if (e.getSource() == vaikea){
        System.out.println("moi");
        Peli hard = new Peli(5, eka, toka);
        hard.luoPeli();
        }
    }
    
}
