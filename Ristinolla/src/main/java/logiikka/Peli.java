/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author Wade
 */
import gui.Voittoikkuna;
import logiikka.Pelaaja;
import kuuntelijat.voittoIkkunanNapinKuuntelija;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import kuuntelijat.XONappi;

public class Peli extends JFrame {
    //public XONappi napit[] = new XONappi[9];
    private Pelaaja yksi, kaksi;
    private int vaikeus, vuoro;
    private JFrame frame;
    private XONappi nappeja[];
    private File tiedosto;
    public Peli(int vaikeustaso, Pelaaja yksi, Pelaaja kaksi){
        vaikeus = vaikeustaso;
        this.yksi = yksi;
        this.kaksi = kaksi;
        tiedosto = new File("scoret.txt");
    }
    
    /**
     * Metodi luo peliin ikkunan ja kutsuu luoKomponentit -metodia.
     * 
     */
    public void luoPeli(){
    frame = new JFrame("Pelaaja X: " + this.yksi + ", Pelaaja O: " + this.kaksi + ".");
        frame.setPreferredSize(new Dimension(800, 800));
       
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    

   
    
        }
    public int getVaikeus(){
        return vaikeus;
    }
        /**
         * Metodi luo XONapit peli-ikkunaan riipuen valitusta vaikeustasosta.
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
        public void vaihdaVuoroa(){
            vuoro++;
        }
        public int getVuoro(){
            return vuoro;
        }
        public void nollaaVuoro(){
        this.vuoro = 0;
    }
        /**
         * Metodiin tuodaan parametrina voittanut pelaaja, ja metodi kutsuu 
         * Voittoikkuna luokkaa luomaan voittoikkunan.
         * @param pelaaja Voittava pelaaja
         */
        public void voittaja(Pelaaja pelaaja) {
                
                
                Voittoikkuna voittoX = new Voittoikkuna(pelaaja, this);
                voittoX.lisaaVoittajaTiedostoon();
                voittoX.valiIkkuna();
                System.out.println("Onneksi olkoon " + pelaaja.pelaajanNimi() + "! VOITIT PELIN!");
            
        }
        
        public void suljeIkkuna(){
            frame.setVisible(false);
        }
        /**
         * Metodi kutsuu tarkista metodeja tarkistamaan voittajaa.
         * Jos tarkista metodi palauttaa true, on voittaja löytynyt
         * ja metodi kutsuu voittaja metodia.
         */
        public void tarkistaVoittaja(){
            int i = 0;
            
                while (i<2){
                    if(i==1){
                        if(tarkista("X")){
                            voittaja(this.yksi);
                        }
                    }
                    else{
                        if(tarkista("O")){
                            voittaja(this.kaksi);
                        }
                    }
                    i++;
                }
        }
        /**
         * Metodi kutsuu joko Helpon, Normaalin tai Vaikean peli tarkistajia
         * riippuen valitusta vaikeusasteesta.
         * @param kirjain tarkistaVoittaja luokan tuoma kirjain tarkistuksia
         * varten.
         * @return true/false
         */
        public boolean tarkista(String kirjain){
            if(vaikeus == 3){
                if(tarkistaHelppoO(kirjain)){
                    return true;
                }
            }
            if(vaikeus == 4){
                if(tarkistaNormaaliO(kirjain)){
                    return true;
                }
            }
            if(vaikeus == 5){
                if(tarkistaVaikeaO(kirjain)){
                    return true;
                }
            }
            return false;
        }
        /**
         * Metodi kutsuu tarkistaHelppoVaaka, -Pysty ja -Vino metodeja, jotka
         * palauttavat true, jos kolmen sarja löytyy.
         * 
         * @param kirjain tuotu kirjain.
         * @return true/false
         */
        public boolean tarkistaHelppoO(String kirjain){
            if(tarkistaHelppoVaaka(kirjain)||tarkistaHelppoPysty(kirjain)||tarkistaHelppoVino(kirjain)){
                return true;
            }
            return false;
        }
        /**
         * Metodi kutsuu tarkistaNormaaliVaaka, -Pysty ja -Vino metodea, jotka
         * palauttavat true, jos neljän sarja löytyy.
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaNormaaliO(String kirjain){
            if(tarkistaNormaaliVaaka(kirjain)||tarkistaNormaaliPysty(kirjain)||tarkistaNormaaliVino(kirjain)){
                return true;
            }
            return false;
        }
        /**
         * Metodi kutsuu tarkistaVaikeaVaaka, -Pysty ja -Vino metodea, jotka
         * palauttavat true, jos viiden sarja löytyy.
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaVaikeaO(String kirjain){
            if(tarkistaVaikeaPysty(kirjain)||tarkistaVaikeaVaaka(kirjain)||tarkistaVaikeaVino(kirjain)){
                return true;
            }
            return false;
        }
        /**
         * Metodi palauttaa true jos helposta pelistä löytyy kolmen suora
         * vaakatasossa.
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaHelppoVaaka(String kirjain){
            int i = 0;
            while(i<7){
                if (nappeja[i].getText().equals(kirjain)){
                    if (nappeja[i+1].getText().equals(kirjain)){
                        if (nappeja[i+2].getText().equals(kirjain)){
                            return true;
                        }
                    }
                }
                i = i+3;
            }
            
            return false;
            
        }
        /**
         * Metodi palauttaa true jos helposta pelistä löytyy kolmen suora
         * pystytasolla
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaHelppoPysty(String kirjain){
            int i = 0;
            while(i<3){
                if (nappeja[i].getText().equals(kirjain)){
                    if (nappeja[i+3].getText().equals(kirjain)){
                        if (nappeja[i+6].getText().equals(kirjain)){
                            return true;
                        }
                    }
                }
                i++;
            }

            return false;
        }
        /**
         * Metodi palauttaa true jos helposta pelistä löytyy kolmen suora
         * vinottain.
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaHelppoVino(String kirjain){
            if (nappeja[2].getText().equals(kirjain)){
                if (nappeja[4].getText().equals(kirjain)){
                    if (nappeja[6].getText().equals(kirjain)){
                        return true;
                    }
                }
            }
            if (nappeja[0].getText().equals(kirjain)){
                if (nappeja[4].getText().equals(kirjain)){
                    if (nappeja[8].getText().equals(kirjain)){
                        return true;
                    }
                }
            }
            return false;
        }
        /**
         * Metodi palauttaa true jos normaalista pelistä löytyy neljän suora
         * vaakatasosta
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaNormaaliVaaka(String kirjain){
           int i = 0; 
           while(i<64){
                if((i<5)||(i>7 && i<13)||(i>15 && i<21)||(i>23 && i<29)||(i>31 && i<37)||(i>39 && i<45)||(i>47 && i<53)||(i>55 && i<61)){
                    if (nappeja[i].getText().equals(kirjain)){
                            if (nappeja[i+1].getText().equals(kirjain)){
                                if(nappeja[i+2].getText().equals(kirjain)){
                                    if(nappeja[i+3].getText().equals(kirjain)){
                                        return true;
                                    }
                                }
                            }
                    }
                }
                i++;
           }
            
           
           return false;
        }
        /**
         * Metodi palauttaa true jos normaalista pelistä löytyy neljän suora 
         * pystytasosta.
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaNormaaliPysty(String kirjain){
            int i = 0;
            while (i<40){
                if(nappeja[i].getText().equals(kirjain)){
                    if(nappeja[i+8].getText().equals(kirjain)){
                        if(nappeja[i+16].getText().equals(kirjain)){
                            if(nappeja[i+24].getText().equals(kirjain)){
                                return true;
                                    }
                                }
                            }
                        }
                    i++;
                    }
            
                return false;
         }
        /**
         * Metodi palauttaa true jos normaalista pelistä löytyy neljän suora 
         * vinottain.
         * @param kirjain 
         * @return true/false
         */
        public boolean tarkistaNormaaliVino(String kirjain){
            int i = 0;
            while (i<40){
            if ((i>2&&i<8)||(i>10&&i<16)||(i>18&&i<24)||(i>26&&i<32)||(i>32&&i<40)){
                        if(nappeja[i].getText().equals(kirjain)){
                                if(nappeja[i+7].getText().equals(kirjain)){
                                    if(nappeja[i+14].getText().equals(kirjain)){
                                        if(nappeja[i+21].getText().equals(kirjain)){
                                            return true;
                                        }
                                    }
                                }
                            }
            }
            i++;
            }
            i = 0;
            while(i<40){
                if((i<5)||(i>7 && i<13)||(i>15 && i<21)||(i>23 && i<29)||(i>31 && i<37)||(i>39 && i<45)||(i>47 && i<53)||(i>55 && i<61)){
                    if(nappeja[i].getText().equals(kirjain)){
                        if(nappeja[i+9].getText().equals(kirjain)){
                            if(nappeja[i+18].getText().equals(kirjain)){
                                if(nappeja[i+27].getText().equals(kirjain)){
                                    return true;
                                }
                            }
                        }
                    }
                }
                i++;
            }
            
            return false;
        }
        /**
         * Metodi palauttaa true jos vaikeasta pelistä löytyy viiden suora 
         * pystytasolta
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaVaikeaPysty(String kirjain){
            int i = 0;
            while(i<96){
                if(nappeja[i].getText().equals(kirjain)){
                    if(nappeja[i+12].getText().equals(kirjain)){
                        if(nappeja[i+24].getText().equals(kirjain)){
                            if(nappeja[i+36].getText().equals(kirjain)){
                                if(nappeja[i+48].getText().equals(kirjain)){
                                    return true;
                                    }
                                }
                            }
                        }
                    }
                i++;
            }
            
            return false;
        }
        /**
         * Metodi palauttaa true jos vaikeasta pelistä löytyy viiden suora
         * vaakatasolta.
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaVaikeaVaaka(String kirjain){
            int i = 0;
            while(i<144){
            if ((i<8)||(i<20&&i>11)||(i<32&&i>23)||(i<44&&i>35)||(i<56&&i>47)||(i<68&&i>59)||(i<80&&i>71)||(i<92&&i>83)||(i<104&&i>95)||(i<116&&i>107)||(i<128&&i>119)||(i<140&&i>131)){
                    if(nappeja[i].getText().equals(kirjain)){
                        if(nappeja[i+1].getText().equals(kirjain)){
                            if(nappeja[i+2].getText().equals(kirjain)){
                                if(nappeja[i+3].getText().equals(kirjain)){
                                    if(nappeja[i+4].getText().equals(kirjain)){
                                        return true;
                                }
                            }
                        }
                    }
                }
            }
            i++;
            }
            
            return false;
        }
        /**
         * Metodi palauttaa true jos vaikeasta pelistä löytyy viiden suora 
         * vinottain.
         * @param kirjain
         * @return true/false
         */
        public boolean tarkistaVaikeaVino(String kirjain){
            int i = 0;
            while(i<92){
                if ((i<8)||(i<20&&i>11)||(i<32&&i>23)||(i<44&&i>35)||(i<56&&i>47)||(i<68&&i>59)||(i<80&&i>71)||(i<92&&i>83)||(i<104&&i>95)||(i<116&&i>107)||(i<128&&i>119)||(i<140&&i>131)){
                    if (i<92){
                        if(nappeja[i].getText().equals(kirjain)){
                            if(nappeja[i+13].getText().equals(kirjain)){
                                if(nappeja[i+26].getText().equals(kirjain)){
                                    if(nappeja[i+39].getText().equals(kirjain)){
                                        if(nappeja[i+52].getText().equals(kirjain)){
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if ((i>3&&i<12)||(i>15&&i<24)||(i>27&&i<36)||(i>39&&i<48)||(i>51&&i<60)||(i>63&&i<72)||(i>75&&i<84)||(i>87&&i<96)){
                    if(nappeja[i].getText().equals(kirjain)){
                                if(nappeja[i+11].getText().equals(kirjain)){
                                    if(nappeja[i+22].getText().equals(kirjain)){
                                        if(nappeja[i+33].getText().equals(kirjain)){
                                            if(nappeja[i+44].getText().equals(kirjain)){
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                    }
                i++;
            }
                return false;
            }
        
        
        public String toString(){
            return "Pelaaja X: " + this.yksi + ", Pelaaja O: " + this.kaksi + ". Vaikeusaste: " + this.vaikeus;
        }
    }

