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
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import kuuntelijat.NapinKuuntelija;

/**
 *
 * @author Wade
 */
public class Kayttoliittyma {
    private JFrame frame;
    public Kayttoliittyma(){
        
    }
    /**
     * 
     * Metodi luo ikkunan, kutsuu luoKomponentit -metodia
     * ja asettaa ikkunan näkyväksi.
     *  
     * 
     */
    public void run(){
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(400, 150));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Metodi luo ikkunaan painikkeita ja toiminnallisuutta.
     * Painikkeiden avulla voidaan siirtyä eteenpäin.
     * 
     * @param container 
     */
    private void luoKomponentit(Container container){
        
        GridLayout layout = new GridLayout(2, 2);
        container.setLayout(layout);
        JPanel paneeli  = new JPanel(new GridLayout(2, 2));
        paneeli.add(new JLabel("Pelaaja X: "));
        JTextField ekapelaaja = new JTextField();
        paneeli.add(ekapelaaja);
        JTextField tokapelaaja = new JTextField();
        paneeli.add(new JLabel("Pelaaja O: "));
        paneeli.add(tokapelaaja);
        
        JPanel alaPaneeli = new JPanel(new GridLayout(1, 3));
        
        JButton helppo = new JButton("Helppo(3)");
        JButton normaali = new JButton("Normaali(4)");
        JButton vaikea = new JButton("Vaikea(5)");
        
        NapinKuuntelija kuuntelija = new NapinKuuntelija(ekapelaaja, tokapelaaja, helppo, vaikea, normaali);
        
        helppo.addActionListener(kuuntelija);
        normaali.addActionListener(kuuntelija);
        vaikea.addActionListener(kuuntelija);
        
        alaPaneeli.add(helppo);
        alaPaneeli.add(normaali);
        alaPaneeli.add(vaikea);
        
        container.add(paneeli, BorderLayout.NORTH);
        container.add(alaPaneeli, BorderLayout.SOUTH);
    }
}
