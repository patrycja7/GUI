/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.JarFile;
import static javax.sound.midi.MidiSystem.getSequence;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

// tak wiem .... ale to silniejsze ode mnie ...


public class Muzyka {
    
    private String nazwaPliku; 
    private File plik;
    private AudioInputStream ais;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip klip ; 
    private URL sciezka;
    final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()); 
    InputStream is;
    
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
            if (jarFile.isFile())
            { 
             sciezka = getClass().getResource(nazwaPliku); 
             ais = AudioSystem.getAudioInputStream(sciezka);  
            }
            else
            {
                 sciezka = getClass().getResource(nazwaPliku);
                plik = new File(String.valueOf(sciezka).substring(6));
                ais = AudioSystem.getAudioInputStream(plik);
               // format = ais.getFormat(); potencjalnie do wyjebania
            }
            info = new DataLine.Info(Clip.class, format);
            klip = (Clip) AudioSystem.getLine(info); 
            klip.open(ais);
    }catch (Exception e) {}
    } 
  }
    
