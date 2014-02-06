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
    
    /**
     * Metodi luo peliin ikkunan ja kutsuu luoKomponentit -metodia.
     * 
     */
    public void luoPeli(){
    frame = new JFrame("Pelaaja X: " + this.yksi + ", Pelaaja O: " + this.kaksi + ".");
        frame.setPreferredSize(new Dimension(800, 800));
        
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    

   
    
        }
        /**Metodi luo ikkunaan painikkeet pelille, riippuen vaikeusasteesta.
         * Metodi luo XONappeja, jotka painettaessa luovat nappiin X:n tai O:n.
         * 
         * @param container 
         */
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
        /**
         * Riippuen vaikeusasteesta, metodi kutsuu tarkista-metodeja.
         */
        public void tarkistaVoittaja(){
            if(vaikeus == 3){
                tarkistaHelppo();
            }
            if(vaikeus == 4){
                tarkistaNormaali();
            }
            if(vaikeus == 5){
                tarkistaVaikea();
            }
            
        }
        /**
         * Metodi tarkistaa helpon vaikeusasteen (3x3) ja ilmoittaa voittajan.
         * 
         */
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
                frame.setVisible(false);
                voittoIkkuna(this.yksi);
                System.out.println("Onneksi olkoon " + this.yksi.pelaajanNimi() + "! VOITIT PELIN!");
            }
            if (voittaja.equals("O") && i == 1){
                frame.setVisible(false);
                voittoIkkuna(this.kaksi);
                System.out.println("Onneksi olkoon " + this.kaksi.pelaajanNimi() + "! VOITIT PELIN!");
            }
            i++;
            }
            
        }
        /**
         * Metodi tarkistaa normaalin (8x8) vaikeusasteen ja ilmoittaa voittajan.
         */
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
                        if(nappeja[u+9].getText().equals(kirjain)){
                                    if(nappeja[u+18].getText().equals(kirjain)){
                                        if(nappeja[u+27].getText().equals(kirjain)){
                                            voittaja = kirjain;
                                        }
                                    }
                                }
                        
                    }
//                    if (u<40){
//                        if(nappeja[u].getText().equals(kirjain)){
//                                if(nappeja[u+9].getText().equals(kirjain)){
//                                    if(nappeja[u+18].getText().equals(kirjain)){
//                                        if(nappeja[u+27].getText().equals(kirjain)){
//                                            voittaja = kirjain;
//                                        }
//                                    }
//                                }
//                            }
//                        }
                    if ((u>2&&u<7)||(u>10&&u<15)||(u>18&&u<23)||(u>26&&u<31)||(u>32&&u<39)){
                        if(nappeja[u].getText().equals(kirjain)){
                                if(nappeja[u+7].getText().equals(kirjain)){
                                    if(nappeja[u+14].getText().equals(kirjain)){
                                        if(nappeja[u+21].getText().equals(kirjain)){
                                            voittaja = kirjain;
                                        }
                                    }
                                }
                            }
                        
                        }
                    if(u<40){
                        if(nappeja[u].getText().equals(kirjain)){
                            if(nappeja[u+8].getText().equals(kirjain)){
                                if(nappeja[u+16].getText().equals(kirjain)){
                                    if(nappeja[u+24].getText().equals(kirjain)){
                                        voittaja = kirjain;
                                    }
                                }
                            }
                            
                        }
                    }
                    u++;
                    }
                        if (voittaja.equals("X") && i == 0){
                            frame.setVisible(false);
                            voittoIkkuna(this.yksi);
                        System.out.println("Onneksi olkoon " + this.yksi.pelaajanNimi() + "! VOITIT PELIN!");
                    }
                    if (voittaja.equals("O") && i == 1){
                        System.out.println("Onneksi olkoon " + this.kaksi.pelaajanNimi() + "! VOITIT PELIN!");
                    }
                i++;
            }
        }
        /**
         * Metodi tarkistaa vaikean (12x12) vaikeusasteen ja ilmoittaa voittajan.
         */
        public void tarkistaVaikea(){
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
                if(u<96){
                if(nappeja[u].getText().equals(kirjain)){
                                if(nappeja[u+12].getText().equals(kirjain)){
                                    if(nappeja[u+24].getText().equals(kirjain)){
                                        if(nappeja[u+36].getText().equals(kirjain)){
                                            if(nappeja[u+48].getText().equals(kirjain)){
                                                voittaja = kirjain;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                if ((u>3&&u<12)||(u>15&&u<24)||(u>27&&u<36)||(u>39&&u<48)||(u>51&&u<60)||(u>63&&u<72)||(u>75&&u<84)||(u>87&&u<96)){
                    if(nappeja[u].getText().equals(kirjain)){
                                if(nappeja[u+11].getText().equals(kirjain)){
                                    if(nappeja[u+22].getText().equals(kirjain)){
                                        if(nappeja[u+33].getText().equals(kirjain)){
                                            if(nappeja[u+44].getText().equals(kirjain)){
                                                voittaja = kirjain;
                                            }
                                        }
                                    }
                                }
                            }
                    }
                if ((u<8)||(u<20&&u>11)||(u<32&&u>23)||(u<44&&u>35)||(u<56&&u>47)||(u<68&&u>59)||(u<80&&u>71)||(u<92&&u>83)||(u<104&&u>95)||(u<116&&u>107)||(u<128&&u>119)||(u<140&&u>131)){
                    if(nappeja[u].getText().equals(kirjain)){
                        if(nappeja[u+1].getText().equals(kirjain)){
                            if(nappeja[u+2].getText().equals(kirjain)){
                                if(nappeja[u+3].getText().equals(kirjain)){
                                    if(nappeja[u+4].getText().equals(kirjain)){
                                        voittaja = kirjain;
                                }
                            }
                        }
                    }
                }
                    if (u<92){
                        if(nappeja[u].getText().equals(kirjain)){
                            if(nappeja[u+13].getText().equals(kirjain)){
                                if(nappeja[u+26].getText().equals(kirjain)){
                                    if(nappeja[u+39].getText().equals(kirjain)){
                                        if(nappeja[u+52].getText().equals(kirjain)){
                                            voittaja = kirjain;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
            
        
                u++;
                }    
                if (voittaja.equals("X") && i == 0){
                    frame.setVisible(false);
                    voittoIkkuna(this.yksi);
                    System.out.println("Onneksi olkoon " + this.yksi.pelaajanNimi() + "! VOITIT PELIN!");
                }
                if (voittaja.equals("O") && i == 1){
                    System.out.println("Onneksi olkoon " + this.kaksi.pelaajanNimi() + "! VOITIT PELIN!");
                }
                i++;
            }
        }
        /**Metodi luo voittoikkunan, ilmoittaa voittajan ja kysyy pelataanko uudelleen, suljetaanko
         * vai tuodaanko tuloslista.
         * 
         * @param pelaaja Voittanut pelaaja
         */
        public void voittoIkkuna(Pelaaja pelaaja){
            JFrame voittoRuutu = new JFrame("Voittaja: " + pelaaja.pelaajanNimi());
        voittoRuutu.setPreferredSize(new Dimension(400, 300));
        
        voittoRuutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Container container = voittoRuutu.getContentPane();
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);
        
        
        
        JPanel alaPaneeli = new JPanel(new GridLayout(1, 3));
        
        JButton joo = new JButton("Uusi peli");
        JButton ei = new JButton("Sulje");
        JButton scoret = new JButton("Tuloslista (tulossa)");
        voittoIkkunanNapinKuuntelija kuuntelija = new voittoIkkunanNapinKuuntelija(joo, ei, scoret, voittoRuutu);
        joo.addActionListener(kuuntelija);
        ei.addActionListener(kuuntelija);
        scoret.addActionListener(kuuntelija);
        alaPaneeli.add(joo);
        alaPaneeli.add(ei);
        alaPaneeli.add(scoret);
        
        container.add(new JLabel("Onneksi olkoon " + pelaaja.pelaajanNimi() + "! Voitit pelin! Pelataanko uudestaan?"), BorderLayout.NORTH);
        container.add(alaPaneeli, BorderLayout.SOUTH);
        
        voittoRuutu.pack();
        voittoRuutu.setVisible(true);
        }
        public String toString(){
            return "Pelaaja X: " + this.yksi + ", Pelaaja O: " + this.kaksi + ". Vaikeusaste: " + this.vaikeus;
        }
    }

