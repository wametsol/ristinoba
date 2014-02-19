/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    public Voittoikkuna(Pelaaja pelaaja, Peli peli){
        this.pelaaja = pelaaja;
        this.peli = peli;
        
        }
    public void luoIkkuna(){
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
        voittoIkkunanNapinKuuntelija kuuntelija = new voittoIkkunanNapinKuuntelija(joo, ei, scoret, voittoRuutu, peli);
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
        
    }
    

