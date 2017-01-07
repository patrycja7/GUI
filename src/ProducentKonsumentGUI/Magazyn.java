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
    public static int wyprodukowano = 0, skonsumowano = 0;
    public Magazyn(){
        polka = new LinkedList<String>();
    }
    
    public  void skonsumuj(){
        try{
            semKon.acquire();
            synchronized (polka){
                    System.out.println("jess" );
                    //semKon.acquire();

                    Thread.sleep((long)(Math.random() * 2000));

                    System.out.println("Skonsumowano : "+ " przez  "+ Thread.currentThread().getName());
                    skonsumowano++;
                    polka.remove(0);


                }
        }catch (Exception e){}        
    } 
    
    public synchronized void dodaj(){
        
        //synchronized(polka){
            
            try{
                String t = new String();
                
                polka.add(t);
                
                System.out.println("Produkcja : "  + " przez " + Thread.currentThread().getName());
                wyprodukowano++;
                Thread.sleep((long)(Math.random() * 1000));
                
                polka.notify();  
            }catch (Exception e){   
            }finally{
                
                semKon.release();
            }
        //}  
    }  
}
