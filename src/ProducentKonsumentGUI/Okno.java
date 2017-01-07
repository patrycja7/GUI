/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducentKonsumentGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class Okno extends JFrame implements ActionListener {
    
    public static int producent = 0;
    private JButton bDodajK, bDodajP, bWyjdz;
    private JPanel liniaG, liniaD, kwadrat, kolo;
    private JLabel lProducent, lKonsument;
    public static JLabel lProdukcja,lKonsumpcja, lIloscP, lIloscK;
    private JLabel lWyprodukowano, lSkonsumowano;
    private JLabel lWP,lWK;
    public  Okno(){
        setLayout(null);
        
        lProducent = new JLabel("");
        lProducent.setText("Producer");
        lProducent.setForeground(Color.BLACK);
        lProducent.setFont(new Font("Arial", Font.BOLD, 20));
        lProducent.setBounds(10, 0, 100, 50);
        add(lProducent);
        
        kwadrat = new Kwadrat();
        kwadrat.setBounds(25, 40, 40, 55);
	add(kwadrat);
        pack();
        
        lIloscP = new JLabel("");
        lIloscP.setText("0");      
        lIloscP.setForeground(Color.BLACK);
        lIloscP.setFont(new Font("Arial", Font.BOLD, 20));
        lIloscP.setBounds(35, 65, 100, 50);
        add(lIloscP);
        
        lWP = new JLabel("");
        lWP.setText("Running");      
        lWP.setForeground(Color.BLACK);
        lWP.setFont(new Font("Arial", Font.BOLD, 20));
        lWP.setBounds(10, 85, 100, 50);
        add(lWP);
        
        liniaG = new Linia();
        liniaG.setBounds(90, 20, 450, 55);
	add(liniaG);
        pack();
        
        liniaD = new Linia();
        liniaD.setBounds(90, 40, 450, 55);
	add(liniaD);
        pack();
        
        lKonsument = new JLabel("");
        lKonsument.setText("Consumer");
        lKonsument.setForeground(Color.BLACK);
        lKonsument.setFont(new Font("Arial", Font.BOLD, 20));
        lKonsument.setBounds(560, 0, 100, 50);
        add(lKonsument);
        
        kolo = new Kolo();
        kolo.setBounds(580, 40, 40, 55);
	add(kolo);
        pack();
        
        lIloscK = new JLabel("");
        lIloscK.setText("0");      
        lIloscK.setForeground(Color.BLACK);
        lIloscK.setFont(new Font("Arial", Font.BOLD, 20));
        lIloscK.setBounds(590, 65, 100, 50);
        add(lIloscK);
        
        lWK = new JLabel("");
        lWK.setText("Running");      
        lWK.setForeground(Color.BLACK);
        lWK.setFont(new Font("Arial", Font.BOLD, 20));
        lWK.setBounds(560, 85, 100, 50);
        add(lWK);
        
        bDodajK = new JButton("add Consumer ");
        bDodajK.setBounds(0, 300, 150, 45);
        add(bDodajK);
        bDodajK.addActionListener(this);
     
        bDodajP = new JButton("add Producer");
        bDodajP.setBounds(160, 300, 150, 45);
        add(bDodajP);
        bDodajP.addActionListener(this);
        
        bWyjdz = new JButton("Quit");
        bWyjdz.setBounds(320, 300, 100, 45);
        add(bWyjdz);
        bWyjdz.addActionListener(this);
        lWyprodukowano = new JLabel("");
        lWyprodukowano.setText("Produce:");
        lWyprodukowano.setForeground(Color.BLACK);
        lWyprodukowano.setBounds(430, 300, 75, 50);
        add(lWyprodukowano);
        
        lProdukcja = new JLabel("");
        lProdukcja.setText("0");
        lProdukcja.setForeground(Color.BLACK);
        lProdukcja.setBounds(490, 300, 75, 50);
        add(lProdukcja);
        
        lSkonsumowano = new JLabel("");
        lSkonsumowano.setText("Consume:");
        lSkonsumowano.setForeground(Color.BLACK);
        lSkonsumowano.setBounds(560, 300, 75, 50);
        add(lSkonsumowano);
        
        lKonsumpcja = new JLabel("");
        lKonsumpcja.setText("0");
        lKonsumpcja.setForeground(Color.BLACK);
        lKonsumpcja.setBounds(630, 300, 75, 50);
        add(lKonsumpcja);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(700,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Producent/Konsument GUI  ");
         setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Magazyn magazyn = new Magazyn();
        if (source == bDodajK )
        {
            new Konsument(magazyn).start();
            
            //lIloscK.setText(konsument + "");
            
        }
        else if (source == bDodajP)
        {
            new Producent(magazyn).start(); 
            producent++;
            lIloscP.setText(producent + "");
        }
        else if(source == bWyjdz)
        {
            dispose();
        }
        
    }
        
}
