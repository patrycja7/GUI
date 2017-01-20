/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.awt.Color;
import java.util.LinkedList;

       
public class Magazyn {
    public static LinkedList<Color> polka =  new LinkedList<Color>();
    public static Color kolor;
    private final int MAX = 19; 
    public static int wyprodukowano = 0, skonsumowano = 0;
    
    public void skonsumuj(){
        synchronized(polka){
            try{    
                while ( polka.isEmpty() )
                {
                    System.out.println("polka pusta, konsument czeka");
                    polka.wait();    
                }
                Thread.sleep((long)(Math.random() * 2000));  
                skonsumowano++;
                polka.remove(0);
                Okno.produkt.repaint();
                System.out.println("konsument zjadł " + polka.size());
                polka.notify();
            }catch (Exception e){}    
        }        
    } 
    
    public  void dodaj(){
        
        synchronized(polka){
            try{
                while(polka.size() == MAX)
                {
                    System.out.println("polka max, producent czeka");
                    polka.wait();       
                }              
                kolor = new Color((int)( ( Math.random() * 255 ) + 1), (int)( ( Math.random() * 255 ) + 1), 
                       (int)( ( Math.random() * 255 ) + 1)); 
                Okno.kwadrat.repaint();
                Okno.kolo.repaint(); 
                polka.add(kolor);   
                Okno.produkt.repaint();
                System.out.println("Producent wyprodukował " + polka.size()); 
                wyprodukowano++;
                polka.notify();
                Thread.sleep((long)(Math.random() * 1000));   
            }catch (Exception e){}      
        }  
    }
}
