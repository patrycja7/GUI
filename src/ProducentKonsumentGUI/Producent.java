
package ProducentKonsumentGUI;


public class Producent extends Thread {
    private Magazyn polka;
    
    public Producent (Magazyn p){
        
        polka = p;         
    }
    
    public void run(){
        
       while(true)
        {
            try{                
                polka.dodaj();
                Okno.lProdukcja.setText(polka.wyprodukowano + "");
	        Thread.sleep( (int)(Math.random() * 1000) );   
            }catch (InterruptedException e) {}  
        }
    }
}
