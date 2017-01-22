/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

// tak wiem .... ale to silniejsze ode mnie ...


public class Muzyka {
    
    private String nazwaPliku; 
    private File plik, sciezka;
    private AudioInputStream ais ;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip klip ; 
    final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());     
    public Muzyka (String nazwa){
        nazwaPliku = nazwa; 
    }
    
    public  void start(){
        
        klip.loop(Clip.LOOP_CONTINUOUSLY);
        klip.start();
    }
    
    public void stop(){
        klip.stop();
        klip.flush();
    }

    public void przygotuj() {
       try
        { 
            if(jarFile.isFile())
            {
             // cos tu trzeba zrobic zeby muzyka i obrazki sie ladowaly w jarze, o ile ci sie wgl normalnie laduja ...

            }
            sciezka = new File(nazwaPliku);
            plik = new File(sciezka.getCanonicalPath());
            
            ais = AudioSystem.getAudioInputStream(plik);
            format = ais.getFormat();
            info = new DataLine.Info(Clip.class, format);
            klip = (Clip) AudioSystem.getLine(info); 
            klip.open(ais);
    }catch (Exception e) {}
    } 
  }
    
