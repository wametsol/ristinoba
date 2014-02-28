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
import java.awt.Toolkit;
import logiikka.Peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class XONappi extends JButton implements ActionListener {
    ImageIcon X,O;
    
    
    Peli peli;
    public XONappi(Peli peli) {
        
        
//        if(peli.getVaikeus() == 3){
//        X = new ImageIcon((main.Main.class.getResource("/kuvat/xHelppo.png")));
//        O = new ImageIcon((main.Main.class.getResource("/kuvat/oHelppo.png")));
//        }
        if(peli.getVaikeus() == 3){
        X = new ImageIcon((getClass().getResource("/kuvat/xHelppo.png")));
        O = new ImageIcon((getClass().getResource("/kuvat/oHelppo.png")));
        }
        else if(peli.getVaikeus() == 4){
        X = new ImageIcon((getClass().getResource("/kuvat/xNormaali.png")));
        O = new ImageIcon((getClass().getResource("/kuvat/oNormaali.png")));
        }
        else if(peli.getVaikeus() == 5){
        X = new ImageIcon((getClass().getResource("/kuvat/xVaikea.png")));
        O = new ImageIcon((getClass().getResource("/kuvat/oVaikea.png")));
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
