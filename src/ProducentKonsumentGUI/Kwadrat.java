/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Kwadrat extends JPanel {
    
    private boolean wypelnij = false;
    private boolean b;
    
    public Kwadrat(boolean b){
        this.b = b;
    } 
    @Override
    public void paint(Graphics g)
     {  
        super.paintComponent(g);
        g.setColor(Magazyn.kolor);
         if (wypelnij == false && b == false )
         {            
           g.setColor(Color.BLACK);
           g.drawRect(10, 10, 20, 20);
           wypelnij = true;
         }
         else 
         {
             g.fillRect(10, 10, 20, 20);
         }  
     }
    
}
