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
 * s
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
        
        if(peli.getVaikeus() == 3){
        X = new ImageIcon("xHelppo.png");
        O = new ImageIcon("oHelppo.png");
        }
        else if(peli.getVaikeus() == 4){
        X = new ImageIcon("xNormaali.png");
        O = new ImageIcon("oNormaali.png");
        }
        else if(peli.getVaikeus() == 5){
        X = new ImageIcon("xVaikea.png");
        O = new ImageIcon("oVaikea.png");
        }
        this.addActionListener(this);
        this.peli = peli;
    }
    /**Kuuntelee napinpainalluksia.
     * 
     * @param e Painettu nappi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.getText()!= ""){
            // Varattu
        }
        else{
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
    public void poistaKuuntelija(){
       // this.setEnabled(false);
    }
}
