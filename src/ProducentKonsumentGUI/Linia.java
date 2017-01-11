/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Linia extends JPanel{
    public void paint(Graphics g)
     {
         Dimension d = this.getSize();
         g.setColor(Color.BLACK);
         g.drawLine(0,d.height/2,d.width,d.height/2);
     }
    
}
