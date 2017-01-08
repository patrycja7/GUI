/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
                @Override
               public void run() {
                new Okno();               
            }
            });
    }
}
