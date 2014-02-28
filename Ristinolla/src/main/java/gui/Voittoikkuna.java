/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import kuuntelijat.voittoIkkunanNapinKuuntelija;
import logiikka.Pelaaja;
import logiikka.Peli;

/**
 *
 * @author Wade
 */
public class Voittoikkuna {
    private Peli peli;
    private Pelaaja pelaaja;
    private JButton ok, joo, ei, scoret;
    private JFrame valiRuutu, voittoRuutu;
    voittoIkkunanNapinKuuntelija kuuntelija;
    public Voittoikkuna(Pelaaja pelaaja, Peli peli){
        this.pelaaja = pelaaja;
        this.peli = peli;
        voittoRuutu = new JFrame("Voittaja: " + pelaaja.pelaajanNimi());
        ok = new JButton("OK");
        joo = new JButton("Uusi peli");
        ei = new JButton("Sulje");
        scoret = new JButton("Tuloslista (tulossa)");
        kuuntelija = new voittoIkkunanNapinKuuntelija(this, ok, joo, ei, scoret, voittoRuutu, peli);
        
        }
    public void valiIkkuna(){
        valiRuutu = new JFrame("Voittaja: " + pelaaja.pelaajanNimi());
        valiRuutu.setPreferredSize(new Dimension(300, 200));
        valiRuutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Container container = valiRuutu.getContentPane();
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);
        
        container.add(new JLabel("Onneksi olkoon " + pelaaja.pelaajanNimi() + "! Voitit pelin!"));
        
        
        container.add(ok);
        ok.addActionListener(kuuntelija);
        
        valiRuutu.pack();
        valiRuutu.setLocationRelativeTo(null);
        valiRuutu.setVisible(true);
        //this.luoIkkuna();
    }
    public void luoIkkuna(){
        peli.suljeIkkuna();
        valiRuutu.setVisible(false);
        
        voittoRuutu.setPreferredSize(new Dimension(400, 300));
        
        voittoRuutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Container container = voittoRuutu.getContentPane();
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);
        
        
        
        JPanel alaPaneeli = new JPanel(new GridLayout(1, 3));
        
        
        //voittoIkkunanNapinKuuntelija kuuntelija = new voittoIkkunanNapinKuuntelija(this, ok, joo, ei, scoret, voittoRuutu, peli);
        joo.addActionListener(kuuntelija);
        ei.addActionListener(kuuntelija);
        scoret.addActionListener(kuuntelija);
        alaPaneeli.add(joo);
        alaPaneeli.add(ei);
        alaPaneeli.add(scoret);
        JLabel teksti = new JLabel("Pelataanko uudestaan?");
        teksti.setFont(new Font("Serif", Font.ROMAN_BASELINE, 38));
        
        container.add(teksti, BorderLayout.NORTH);
        container.add(alaPaneeli, BorderLayout.SOUTH);
        
        voittoRuutu.pack();
        voittoRuutu.setLocationRelativeTo(null);
        voittoRuutu.setVisible(true);
    }
    public void lisaaVoittajaTiedostoon(){
        
            if (pelaaja.pelaajanNimi().isEmpty()){
                
            }
            else{
            FileWriter kirjoittaja = null;
            
            try{
                kirjoittaja = new FileWriter("/C:/WADE-PC/Users/Wade/.ssh/ristinoba/Ristinolla/target/classes/teksti/scoret.txt", true);
                
                
            }
            catch(Exception e){
                System.out.println("asd");
            }
            
            
                try{
                kirjoittaja.append("" + pelaaja.pelaajanNimi().toUpperCase() + "\n");
                
                kirjoittaja.close();
                }
                catch(Exception e){
                    
                
                }
            }  
    }
        
    }
    

