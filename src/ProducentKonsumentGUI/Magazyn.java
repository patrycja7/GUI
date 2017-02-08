
package ProducentKonsumentGUI;

import java.awt.Color;
import java.util.LinkedList;
       
public class Magazyn {
    public static LinkedList<Color> polka =  new LinkedList<>();
    public static Color kolor;
    private final int MAX = 19; 
    public static int wyprodukowano = 0, skonsumowano = 0;
    
    public void skonsumuj(){
        synchronized(polka){
            try{    
                while ( polka.isEmpty() )
                {
                    Okno.taPole.append("polka pusta, konsument czeka\n");
                    polka.wait();    
                }
                Thread.sleep((long)(Math.random() * 2000));  
                skonsumowano++;
                polka.remove(0);
                Okno.produkt.repaint();
                Okno.taPole.append("konsument zjadł\n");
                polka.notify();
            }catch (Exception e){}    
        }        
    } 
    
    public  void dodaj(){
        
        synchronized(polka){
            try{
                while(polka.size() == MAX)
                {
                    Okno.taPole.append("Brak miejsca, producent czeka\n");
                    polka.wait();       
                }              
                kolor = new Color((int)( ( Math.random() * 255 ) + 1), (int)( ( Math.random() * 255 ) + 1), 
                       (int)( ( Math.random() * 255 ) + 1)); 
                Okno.kwadrat.repaint();
                polka.add(kolor);   
                Okno.produkt.repaint();
                Okno.taPole.append("Producent wyprodukował \n"); 
                wyprodukowano++;
                polka.notify();
                Thread.sleep((long)(Math.random() * 1000));   
            }catch (Exception e){}      
        }  
    }  
}
