/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;


       
public class Magazyn {
    private static  LinkedList<String> polka;
    private static Semaphore semKon = new Semaphore(0);
    public static int wyprodukowano = 0;
    public Magazyn(){
        polka = new LinkedList<String>();
    }
    
    public void skonsumuj(){
        synchronized (polka){
            
            try{
                if (semKon.tryAcquire() == false)
                    polka.wait();
                
                Thread.sleep((long)(Math.random() * 2000));
                polka.remove(0);
   
            }catch (Exception e){} 
        }       
    } 
    
    public void dodaj(){
        
        synchronized(polka){
            
            try{
                String t = new String();
                polka.add(t);
                wyprodukowano++;
                Thread.sleep((long)(Math.random() * 1000));
                polka.notifyAll();   
            }catch (Exception e){   
            }finally{
                semKon.release();
            }
        }  
    }  
}
