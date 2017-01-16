/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Produkt  extends JPanel{
    private int rozmiarX;
    private final int ROZMIAR_Y = 10; 
    private final int WIDTH = 20;
    private final int HEIGHT = 20;        
   
    @Override
    public void paint(Graphics g)
     { 
        super.paintComponent(g);
            rozmiarX = 450;
            for (int i = 0; i < Magazyn.polka.size(); i++)
            {
                g.setColor(Magazyn.polka.get(i));  
                g.fillRect(rozmiarX, ROZMIAR_Y, WIDTH, HEIGHT);
                rozmiarX -= 25;
            }     
     }   
}
