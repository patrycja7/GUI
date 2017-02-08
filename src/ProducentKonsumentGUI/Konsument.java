
package ProducentKonsumentGUI;

public class Konsument extends Thread {
    private Magazyn polka;
    
    public Konsument(Magazyn p){
        
        polka = p;
    }
    
    @Override
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



  

