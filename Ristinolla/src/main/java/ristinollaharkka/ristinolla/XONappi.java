/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinollaharkka.ristinolla;
//package kuvat;
/**
 *
 * @author Wade
 * 
 * 
 */

//---
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class XONappi extends JButton implements ActionListener {
    ImageIcon X,O;
    
    private int vuoro;
    Peli peli;
    public XONappi(Peli peli){
        this.vuoro = 0;
        X = new ImageIcon("X.png");
        O = new ImageIcon("O.png");
        this.addActionListener(this);
        this.peli = peli;
    }
    
    public void nollaaVuoro(){
        this.vuoro = 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        vuoro++;
        String kirjain;
        if (vuoro%2==0){
            kirjain ="X";
//            setIcon(X);
        }
        else{
            kirjain = "O";
        }
//        else{
//            //setIcon(O);
//            setText("O");
//        }
        setText(kirjain);
        peli.tarkistaVoittaja();
        
        
    }
}
