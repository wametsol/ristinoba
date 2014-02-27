/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Wade
 */
public class Pistetilasto {
    private HashMap<String, Integer>pelaajaKartta;
    public Pistetilasto(){
        pelaajaKartta = new HashMap<String, Integer>();
    }
    
    public void luoIkkuna(){
        JFrame pisteIkkuna = new JFrame("TULOKSET:");
        pisteIkkuna.setPreferredSize(new Dimension(300, 400));
       
        lataaTiedosto();
//        JPanel paneeli1 = new JPanel(new GridLayout(1,1)){
//            @Override
//           public void paintComponent(Graphics g){
//               g.drawLine(0, 250, 800, 250);
//               g.drawLine(291, 250, 291, 0);
//           } 
//            
//        };
//        
//        paneeli1.add(new JLabel("Pelaajat"));
//        
//        JPanel paneeli2 = new JPanel(new GridLayout(2,1)){
//            @Override
//            public void paintComponent(Graphics g){
//                g.drawLine(291, 250, 500, 250);
//            }
//        };
//        paneeli2.add(new JLabel("Voitot"));
        Container container = pisteIkkuna.getContentPane();
        GridLayout layout = new GridLayout(10,1);
        container.setLayout(layout);
        //container.add(new JLabel("Top 10"));
        ArrayList<String> pelaajaLista = new ArrayList<String>();
        
        
        for (String pelaaja : pelaajaKartta.keySet()){
            pelaajaLista.add(pelaaja + " : " + pelaajaKartta.get(pelaaja) + " voittoa.");
            
        }
        pelaajaLista.remove(pelaajaLista.size()-1);
        
        
        for (String pelaaja : pelaajaLista){
            container.add(new JLabel(pelaaja));
        }
        
        
        
        
        
        pisteIkkuna.pack();
        pisteIkkuna.setLocationRelativeTo(null);
        pisteIkkuna.setVisible(true);
    }
    public void lataaTiedosto(){
        File tiedosto = new File("scoret.txt");
        Scanner lukija = null;
        try{ 
            lukija = new Scanner(tiedosto);
        }
        catch(Exception e){
        }
        while(lukija.hasNextLine()){
            String rivi = lukija.nextLine();
            if (rivi == ""){
                
            }
            else{
                
            if (pelaajaKartta.containsKey(rivi.toUpperCase())){
                int voitot = pelaajaKartta.get(rivi);
                voitot++;
                pelaajaKartta.put(rivi, voitot);
            }
            else{
                pelaajaKartta.put(rivi, 1);
            }
            }
        }
        
    }
    
}
