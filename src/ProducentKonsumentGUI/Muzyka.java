/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

// tak wiem .... ale to silniejsze ode mnie ...


public class Muzyka{
    
    private String plik;
    private InputStream inputStream;
    private AudioStream audioStream ;
    
    public Muzyka (String plik){
        this.plik = plik; 
        przygotujPlik();
    }
    public  void przygotujPlik(){
       try
        {
          inputStream = Muzyka.class.getResourceAsStream(plik);
          audioStream = new AudioStream(inputStream);
          //if ()
          AudioPlayer.player.start(audioStream);
        }
        catch (Exception e) {}
  }
    
}
