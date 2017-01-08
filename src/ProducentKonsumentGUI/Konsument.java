/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.awt.Color;


public class Konsument extends Thread {
    private Magazyn polka;
    
    public Konsument(Magazyn p){
        
        polka = p;
    }
    
    public void run(){
        
        for(int i = 0; i < 5; i++)
        {
            try{
                polka.skonsumuj();
                Okno.lKonsumpcja.setText(polka.skonsumowano + "");
	        Thread.sleep( (int)(Math.random() * 1000) );   
            }catch (InterruptedException e) {}  
        }
        Okno.konsument--;
        Okno.lIloscK.setText(Okno.konsument + ""); 
        // test, chce zrobić tak, że jak wątek skończy działać to jego kółko zniknie, a reszta tych jebanych kółek się przesunie 
        /*for (int i = Okno.i; i < Okno.shapeList.size(); i++)
        {
            Okno.shapeList.get(i).setBounds(Okno.x -= 25, 36, 40, 55);
        }*/
    }
    
}
