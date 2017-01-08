/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static javafx.scene.paint.Color.color;
import javax.swing.JPanel;


public class Kolo extends JPanel {
   
   private boolean b = false;
    public void paint(Graphics g)
     { 
        g.setColor(Okno.kolor);
         if (b == false)
         {
           g.setColor(Color.BLACK);
           g.drawOval(10, 10, 20, 20);
           b = true;
         }
         else
         {
              g.fillOval(10, 10, 20, 20); 
         }       
     } 
}
