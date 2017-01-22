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
import java.io.File;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class Okno extends JFrame implements ActionListener{

    public static Produkt produkt;
    public static JLabel lProdukcja,lKonsumpcja; 
    public static JPanel kwadrat, kolo;
    private JLabel lIloscP, lIloscK;
    private  int producent = 0, konsument = 0;  
    private JButton bDodajK, bDodajP,bDzwiek, bWyjdz;
    private URL obraz1 = getClass().getResource("on.jpg");
    private URL obraz2 = getClass().getResource("off.jpg");
    private URL obraz3 = getClass().getResource("sound.jpg");
    private final Icon ON = new ImageIcon(obraz1);
    private final Icon OFF = new ImageIcon(obraz2); 
    private final Icon MUTED = new ImageIcon(obraz3); 
    private final String PIOSENKA = "OriandtheBlindForest-CallingOut.wav";
    private JPanel liniaG, liniaD;
    private JLabel lProducent, lKonsument;
    private JLabel lWyprodukowano, lSkonsumowano;
    private JLabel lNapisP,lNapisK;
    private int klik = 0;
    private Muzyka muzyka;
    public  Okno() {
        setLayout(null);
        
        lProducent = new JLabel("");
        lProducent.setText("Producer");
        lProducent.setForeground(Color.BLACK);
        lProducent.setFont(new Font("Arial", Font.BOLD, 20));
        lProducent.setBounds(10, 0, 100, 50);
        add(lProducent);
        
        lIloscP = new JLabel("");
        lIloscP.setText("0");      
        lIloscP.setForeground(Color.BLACK);
        lIloscP.setFont(new Font("Arial", Font.BOLD, 20));
        lIloscP.setBounds(35, 85, 100, 50);
        add(lIloscP);
        
        lNapisP = new JLabel("");
        lNapisP.setText("Running");      
        lNapisP.setForeground(Color.BLACK);
        lNapisP.setFont(new Font("Arial", Font.BOLD, 20));
        lNapisP.setBounds(10, 105, 100, 50);
        add(lNapisP);
        
        lKonsument = new JLabel("");
        lKonsument.setText("Consumer");
        lKonsument.setForeground(Color.BLACK);
        lKonsument.setFont(new Font("Arial", Font.BOLD, 20));
        lKonsument.setBounds(560, 0, 100, 50);
        add(lKonsument);
                
        lIloscK = new JLabel("");
        lIloscK.setText("0");      
        lIloscK.setForeground(Color.BLACK);
        lIloscK.setFont(new Font("Arial", Font.BOLD, 20));
        lIloscK.setBounds(590, 85, 100, 50);
        add(lIloscK);
        
        lNapisK = new JLabel("");
        lNapisK.setText("Running");      
        lNapisK.setForeground(Color.BLACK);
        lNapisK.setFont(new Font("Arial", Font.BOLD, 20));
        lNapisK.setBounds(560, 105, 100, 50);
        add(lNapisK);
              
        kwadrat = new Kwadrat(true);
        kwadrat.setBounds(25, 40, 40, 55);
	add(kwadrat);
        
        kolo = new Kolo(true);
        kolo.setBounds(580, 40, 40, 55);
        add(kolo);
              
        produkt = new Produkt();
        produkt.setBounds(85, 40, 500, 30);
        add(produkt);
                 
        liniaG = new Linia();
        liniaG.setBounds(86, 12, 470, 55);
	add(liniaG);      
        
        liniaD = new Linia();
        liniaD.setBounds(86, 45, 470, 55);
	add(liniaD);
       
        bDodajP = new JButton("add Producer ");
        bDodajP.setBounds(0, 300, 150, 45);
        add(bDodajP);
        bDodajP.addActionListener(this);
     
        bDodajK = new JButton("add Consumer");
        bDodajK.setBounds(160, 300, 150, 45);
        add(bDodajK);
        bDodajK.addActionListener(this);
        
        
        bDzwiek = new JButton(MUTED);       
        bDzwiek.setBorder(null);
        bDzwiek.setBounds(100, 100, 33, 30);
        add(bDzwiek);
        bDzwiek.addActionListener(this);
        
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
        
         muzyka = new Muzyka(PIOSENKA);
 
        setSize(700,400);;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Producent/Konsument GUI");
        setVisible(true);       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Magazyn magazyn = new Magazyn();
        
        if (source == bDodajP )
        {          
           new Producent(magazyn).start(); 
            producent++;
            lIloscP.setText(producent + "");               
        }
        else if (source == bDodajK)
        {          
            new Konsument(magazyn).start();                               
            konsument++;
            lIloscK.setText(konsument + "");            
        }
        else if (source == bDzwiek)
        {
            
            if(klik == 0)
            {
                bDzwiek.setIcon(ON);
                muzyka.przygotuj();
                muzyka.start();
                klik = 1;   
            }
            else
            {  
               bDzwiek.setIcon(OFF);            
               muzyka.stop();
                klik = 0;
            }
        }
        else if(source == bWyjdz)
        {
            System.exit(0);
        }      
    }   
}
