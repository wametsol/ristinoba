/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinollaharkka.ristinolla;

/**
 *
 * @author Wade
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Peli extends JFrame {
    //public XONappi napit[] = new XONappi[9];
    private Pelaaja yksi, kaksi;
    private int vaikeus;
    private JFrame frame;
    public Peli(int vaikeustaso, Pelaaja yksi, Pelaaja kaksi){
        vaikeus = vaikeustaso;
        this.yksi = yksi;
        this.kaksi = kaksi;
    }
    
    public void luoPeli(){
    frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(800, 800));
        
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    

   
    
        }
    
        public void luoKomponentit(Container container){
            if (vaikeus == 3){
            GridLayout layout = new GridLayout(3,3);
            container.setLayout(layout);
            int i = 0;
            while (i<9){
                container.add(new JButton());
                i++;
            }
            }
            if (vaikeus == 4){
                GridLayout layout = new GridLayout(8,8);
                container.setLayout(layout);
                int i = 0;
                while(i<64){
                    container.add(new JButton());
                    i++;
                }
            }
            if (vaikeus == 5){
                GridLayout layout = new GridLayout(12, 12);
                container.setLayout(layout);
                int i = 0;
                while(i<144){
                    container.add(new JButton());
                    i++;
                }
            }
        }
        
        public String toString(){
            return "Pelaaja X: " + this.yksi + ", Pelaaja O: " + this.kaksi + ". Vaikeusaste: " + this.vaikeus;
        }
    }

