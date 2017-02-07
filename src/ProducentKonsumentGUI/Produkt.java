
package ProducentKonsumentGUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Produkt  extends JPanel{
    private int rozmiar_X;
    private final int ROZMIAR_Y = 10; 
    private final int WIDTH = 20;
    private final int HEIGHT = 20;        
   
    @Override
    public void paint(Graphics g)
     { 
        super.paintComponent(g);
            rozmiar_X = 450;
            for (int i = 0; i < Magazyn.polka.size(); i++)
            {
                g.setColor(Magazyn.polka.get(i));  
                g.fillRect(rozmiar_X, ROZMIAR_Y, WIDTH, HEIGHT);
                rozmiar_X -= 25;
            }     
     }   
}
