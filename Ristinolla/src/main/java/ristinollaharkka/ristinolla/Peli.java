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
    private XONappi nappeja[];
    public Peli(int vaikeustaso, Pelaaja yksi, Pelaaja kaksi){
        vaikeus = vaikeustaso;
        this.yksi = yksi;
        this.kaksi = kaksi;
    }
    
    public void luoPeli(){
    frame = new JFrame("Pelaaja X: " + this.yksi + ", Pelaaja O: " + this.kaksi + ".");
        frame.setPreferredSize(new Dimension(800, 800));
        
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    

   
    
        }
    
        public void luoKomponentit(Container container){
            this.nappeja = new XONappi[144];
            if (vaikeus == 3){
            GridLayout layout = new GridLayout(3,3);
            container.setLayout(layout);
            int i = 0;
            while (i<9){
               
                nappeja[i] = new XONappi(this);
                container.add(nappeja[i]);
                
                i++;
            }
           
            }
            if (vaikeus == 4){
                GridLayout layout = new GridLayout(8,8);
                container.setLayout(layout);
                int i = 0;
                while(i<64){
                    nappeja[i] = new XONappi(this);
                    container.add(nappeja[i]);
                    i++;
                }
            }
            if (vaikeus == 5){
                GridLayout layout = new GridLayout(12, 12);
                container.setLayout(layout);
                int i = 0;
                while(i<144){
                    nappeja[i] = new XONappi(this);
                    container.add(nappeja[i]);
                    i++;
                }
            }
            
           
        }
        
        public void tarkistaVoittaja(){
            if(vaikeus == 3){
                tarkistaHelppo();
            }
            if(vaikeus == 4){
                tarkistaNormaali();
            }
            if(vaikeus == 5){
                
            }
            
        }
        
        public void tarkistaHelppo(){
            int i = 0;
            String voittaja = "";
            String kirjain = "X";
            while (i<2){
                if (i == 1){
                    kirjain = "O";
                }
            if (nappeja[0].getText().equals(kirjain)){
                if (nappeja[1].getText().equals(kirjain)){
                    if (nappeja[2].getText().equals(kirjain)){
                        voittaja = kirjain;
                        
                    }
                }
                
            }
            
            if (nappeja[0].getText().equals(kirjain)){
                if (nappeja[3].getText().equals(kirjain)){
                    if (nappeja[6].getText().equals(kirjain)){
                        voittaja = kirjain;
                        
                    }
                }
                
            }
            
            if (nappeja[0].getText().equals(kirjain)){
                if (nappeja[4].getText().equals(kirjain)){
                    if (nappeja[8].getText().equals(kirjain)){
                        voittaja = kirjain;
                        
                    }
                }
                
            }
            if (nappeja[1].getText().equals(kirjain)){
                if (nappeja[4].getText().equals(kirjain)){
                    if (nappeja[7].getText().equals(kirjain)){
                        voittaja = kirjain;
                        
                    }
                }
                
            }
            if (nappeja[2].getText().equals(kirjain)){
                if (nappeja[5].getText().equals(kirjain)){
                    if (nappeja[8].getText().equals(kirjain)){
                        voittaja = kirjain;
                        
                    }
                }
                
            }
            if (nappeja[3].getText().equals(kirjain)){
                if (nappeja[4].getText().equals(kirjain)){
                    if (nappeja[5].getText().equals(kirjain)){
                        voittaja = kirjain;
                        
                    }
                }
                
            }
            
            if (nappeja[6].getText().equals(kirjain)){
                if (nappeja[7].getText().equals(kirjain)){
                    if (nappeja[8].getText().equals(kirjain)){
                        voittaja = kirjain;
                        
                    }
                }
                
            }
            if (nappeja[2].getText().equals(kirjain)){
                if (nappeja[4].getText().equals(kirjain)){
                    if (nappeja[6].getText().equals(kirjain)){
                        voittaja = kirjain;
                        
                    }
                }
                
            }
            
            if (voittaja.equals("X") && i == 0){
                System.out.println("Onneksi olkoon " + this.yksi.pelaajanNimi() + "! VOITIT PELIN!");
            }
            if (voittaja.equals("O") && i == 1){
                System.out.println("Onneksi olkoon " + this.kaksi.pelaajanNimi() + "! VOITIT PELIN!");
            }
            i++;
            }
            
        }
        
        public void tarkistaNormaali(){
            int i = 0;
            int u = 0;
            String voittaja = "";
            String kirjain = "X";
            while (i<2){
                if(i==1){
                    kirjain = "0";
                    u = 0;
                }
                while(u<64){
                    if (u>4 && u<8){
                        
                    }
                    else if(u>12 && u<16){
                        
                    }
                    else if(u>20 && u<24){
                        
                    }
                    else if(u>28 && u<32){
                        
                    }
                    else if(u>36 && u<40){
                        
                    }
                    else if(u>44 && u<48){
                        
                    }
                    else if(u>52 && u<46){
                        
                    }
                    else if(u>60 && u<64){
                        
                    }
                    else if (nappeja[u].getText().equals(kirjain)){
                        if (nappeja[u+1].getText().equals(kirjain)){
                            if(nappeja[u+2].getText().equals(kirjain)){
                                if(nappeja[u+3].getText().equals(kirjain)){
                                    voittaja = kirjain;
                                }
                            }
                        }
                    }
                    u++;
                    }
                        if (voittaja.equals("X") && i == 0){
                        System.out.println("Onneksi olkoon " + this.yksi.pelaajanNimi() + "! VOITIT PELIN!");
                    }
                    if (voittaja.equals("O") && i == 1){
                        System.out.println("Onneksi olkoon " + this.kaksi.pelaajanNimi() + "! VOITIT PELIN!");
                    }
                i++;
            }
        }
        
        public String toString(){
            return "Pelaaja X: " + this.yksi + ", Pelaaja O: " + this.kaksi + ". Vaikeusaste: " + this.vaikeus;
        }
    }

