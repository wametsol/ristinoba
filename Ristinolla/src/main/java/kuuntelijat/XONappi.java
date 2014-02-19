/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuuntelijat;
//package kuvat;
/**
 *
 * @author Wade
 * 
 * 
 */

//---
import logiikka.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class XONappi extends JButton implements ActionListener {
    ImageIcon X,O;
    
    
    Peli peli;
    public XONappi(Peli peli){
        
        X = new ImageIcon("X.png");
        O = new ImageIcon("O.png");
        this.addActionListener(this);
        this.peli = peli;
    }
    /**Kuuntelee napinpainalluksia.
     * 
     * @param e Painettu nappi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int vuoro = peli.getVuoro();
        String kirjain;
        if (vuoro%2==0){
           kirjain ="X";
           setIcon(X);
           peli.vaihdaVuoroa();
        }
        else{
            kirjain = "O";
            setIcon(O);
            peli.vaihdaVuoroa();
        }

       
        setText(kirjain);
        peli.tarkistaVoittaja();
        
        
    }
}
