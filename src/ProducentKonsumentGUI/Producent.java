/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;


public class Producent extends Thread {
    private Magazyn polka;
    
    public Producent (Magazyn p){
        
        polka = p;         
    }
    
    public void run(){
        
        for(int i = 0; i < 5; i++)
        {
            try{
                
                polka.dodaj();
                Okno.lProdukcja.setText(polka.wyprodukowano + "");
	        Thread.sleep( (int)(Math.random() * 1000) );   
            }catch (InterruptedException e) {}  
        }
        Okno.producent--;
        Okno.lIloscP.setText(Okno.producent + "");
    }
}
