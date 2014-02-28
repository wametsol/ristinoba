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
import java.net.URL;
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
    /**
     * Konstruktori luo tuloksia varten HashMapin, johon tiedostoon
     * lisätyt pelaajat voidaan lisätä ja tulostaa.
     */
    public Pistetilasto(){
        pelaajaKartta = new HashMap<String, Integer>();
    }
    /**
     * Metodi luo pisteiden tulostusta varten ikkunan, kutsuu metodia 
     * lataaTiedosto() ja lisää pelaajat pelaajaKartta-HashMapista ArrayList:iin.
     * Tämän jälkeen metodi lisää pelaajat ikkunaan.
     */
    public void luoIkkuna(){
        JFrame pisteIkkuna = new JFrame("TULOKSET:");
        pisteIkkuna.setPreferredSize(new Dimension(300, 400));
        try{
        lataaTiedosto();
        }
        catch (Exception e){
            System.out.println("Virhe ladattaessa tiedostoa");
        }

        Container container = pisteIkkuna.getContentPane();
        GridLayout layout = new GridLayout(10,1);
        container.setLayout(layout);
        ArrayList<String> pelaajaLista = new ArrayList<String>();
        
        
        for (String pelaaja : pelaajaKartta.keySet()){
            if(pelaaja.equals("")){
                
            }
            else{
            pelaajaLista.add(pelaaja + " : " + pelaajaKartta.get(pelaaja) + " voittoa.");
            }
            
        }
        for (String pelaaja : pelaajaLista){
            container.add(new JLabel(pelaaja));
        }
        pisteIkkuna.pack();
        pisteIkkuna.setLocationRelativeTo(null);
        pisteIkkuna.setVisible(true);
    }
    /**Metodi lataa tiedostosta sinne talletettuja nimiä, jotka se lisää 
     * pelaajaKartta:an, jos pelaajaKarta:ssa on jo kyseinen nimi, lisätään
     * tälle henkilölle uusi voitto.
     * 
     * @throws Exception Metodi heittää Exceptionin jos tiedoston lataaminen
     * epäonnistuu.
     */
    public void lataaTiedosto() throws Exception{
        URL url = getClass().getResource("/teksti/scoret.txt");
        File tiedosto;
        Scanner lukija = null;
        
        tiedosto = new File(url.toURI());
        lukija = new Scanner(tiedosto, "UTF-8");
        
        try{
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
        catch(Exception e){
            System.out.println("Virhe pistetilaston latauksessa");
        }
        
    }
    
}
