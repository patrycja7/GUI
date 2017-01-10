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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


class Okno extends JFrame implements ActionListener {
    
    
    public  JPanel kwadrat, kolo;
    public static JLabel lProdukcja,lKonsumpcja, lIloscP, lIloscK;
    public static int producent = 0, konsument = 0;
    public static ArrayList<JPanel> linia = new ArrayList<JPanel>();
    public static int x = 535;
    public static Color kolor;
    
    private JButton bDodajK, bDodajP, bWyjdz;
    private JPanel liniaG, liniaD;
    private JLabel lProducent, lKonsument;
    private JLabel lWyprodukowano, lSkonsumowano;
    private JLabel lWP,lWK;
    
    private Timer timer; 
    public static  ArrayList<Thread> listaWatkow = new ArrayList<Thread>();
    private  Kwadrat liniaKwadrat, liniaKolo;
    
    public  Okno(){
        setLayout(null);
        
        lProducent = new JLabel("");
        lProducent.setText("Producer");
        lProducent.setForeground(Color.BLACK);
        lProducent.setFont(new Font("Arial", Font.BOLD, 20));
        lProducent.setBounds(10, 0, 100, 50);
        add(lProducent);
        
        kwadrat = new Kwadrat(false);
        kwadrat.setBounds(25, 40, 40, 55);
	add(kwadrat);
        
        
        lIloscP = new JLabel("");
        lIloscP.setText("0");      
        lIloscP.setForeground(Color.BLACK);
        lIloscP.setFont(new Font("Arial", Font.BOLD, 20));
        lIloscP.setBounds(35, 85, 100, 50);
        add(lIloscP);
        
        lWP = new JLabel("");
        lWP.setText("Running");      
        lWP.setForeground(Color.BLACK);
        lWP.setFont(new Font("Arial", Font.BOLD, 20));
        lWP.setBounds(10, 105, 100, 50);
        add(lWP);
        
        liniaG = new Linia();
        liniaG.setBounds(90, 18, 450, 55);
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
        
        
        kolo = new Kolo(false);
        kolo.setBounds(580, 40, 40, 55);
        add(kolo);
        
        
        lIloscK = new JLabel("");
        lIloscK.setText("0");      
        lIloscK.setForeground(Color.BLACK);
        lIloscK.setFont(new Font("Arial", Font.BOLD, 20));
        lIloscK.setBounds(590, 85, 100, 50);
        add(lIloscK);
        
        lWK = new JLabel("");
        lWK.setText("Running");      
        lWK.setForeground(Color.BLACK);
        lWK.setFont(new Font("Arial", Font.BOLD, 20));
        lWK.setBounds(560, 105, 100, 50);
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
        
        //getContentPane().setBackground(Color.WHITE);
        
        
        
        setSize(700,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Producent/Konsument GUI  ");
         setVisible(true);
         
         ActionListener zadanie = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                aktualizuj(); 
               //repaint();
            }
        };
        timer = new Timer(20, zadanie);
       
         
    }

   
   
    
    
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Magazyn magazyn = new Magazyn();
        timer.start();
        if (x == 110)
            {
                bDodajK.setEnabled(false);
                bDodajP.setEnabled(false);
            }
          
        if (source == bDodajK )
        {   // test        
            Konsument watekKonsument = new Konsument(magazyn);
            watekKonsument.setName("kolo");
            listaWatkow.add(watekKonsument );
            watekKonsument.start();

            kolor = new Color((int)( ( Math.random() * 255 ) + 1), (int)( ( Math.random() * 255 ) + 1), (int)( ( Math.random() * 255 ) + 1));
            Kolo liniaKolo = new Kolo(true);
             
            liniaKolo.setBounds(x -= 25, 36, 40, 55);
            linia.add(liniaKolo);
            this.add(liniaKolo );
            liniaKolo.repaint(10, 10, 20, 20); 
            kolo.repaint();
            
            // koniec testu
            konsument++;
            lIloscK.setText(konsument + "");
            
           
        }
        else if (source == bDodajP)
        {
            Producent watekProducent = new Producent(magazyn); 
            //test
             watekProducent.setName("kwadrat");
            listaWatkow.add(watekProducent);
            watekProducent.start();
            
          
           
           
            kolor = new Color((int)( ( Math.random() * 255 ) + 1), (int)( ( Math.random() * 255 ) + 1), (int)( ( Math.random() * 255 ) + 1));
             liniaKwadrat = new Kwadrat(true);
            liniaKwadrat.setBounds(x -= 25, 36, 40, 55);
            linia.add(liniaKwadrat);
            
            this.add(liniaKwadrat );
            liniaKwadrat.repaint(10, 10, 20, 20); 
            kwadrat.repaint();
            
            //koniec testu 
            producent++;
            lIloscP.setText(producent + "");
            
            
        }
        else if(source == bWyjdz)
        {
            System.exit(0);
        }
       
        //setContentPane(lm);
       //lm.setBounds(85, 36, 500, 55);
        //add(lm);
    }
    
    public void aktualizuj(){
        for (int i = 0; i < listaWatkow.size(); i++)
        {
            if(listaWatkow.get(i).isAlive() == false)
            {
                x +=25; // źle ale niech se działa na razie 
                System.out.println(" x +25 = " + x);
               if (String.valueOf(listaWatkow.get(i).getName()).equals("kwadrat"))
               {
                    
                  // liniaKwadrat.setBounds(x -= 25, 36, 40, 55);
                   //System.out.println("kwadrat x - 25 = " + x);
                   //add(liniaKwadrat);
                   //repaint(10, 10, 20, 20);
                   listaWatkow.remove(i);
                   
               }
               else 
               {
                   //liniaKolo.setBounds(x -= 25, 36, 40, 55);
                   //System.out.println("kolo x -25 = " + x);
                   //repaint(10, 10, 20, 20);
                   listaWatkow.remove(i);  
                   
                   //add(liniaKolo);
               } 
               bDodajK.setEnabled(true);
                bDodajP.setEnabled(true);
            }  
            
            
        }
    }
    
}
