/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

public class Konsument extends Thread {
    private Magazyn polka;
    
    public Konsument(Magazyn p){
        
        polka = p;
    }
    
    public void run(){
        
        while(true)
        {
            try{
                polka.skonsumuj();
                Okno.lKonsumpcja.setText(polka.skonsumowano + "");
	        Thread.sleep( (int)(Math.random() * 1000) );   
            }catch (InterruptedException e) {}  
        }
    }
 }    



  

