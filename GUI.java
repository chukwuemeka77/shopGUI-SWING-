/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlineshopgui2;

/**
 *
 * @author Chukwuemeka
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;  
class GUI 
{  
          
          JMenuItem home, about, contact, signup, cart; 
          JTextField search;
     
             JPanel panel;
        GUI(){    
          JFrame f= new JFrame("Menu and MenuItem Example");  
          JMenuBar mb=new JMenuBar();  
         
  Font menuFont = new Font("Arial", Font.PLAIN, 12);
                
          home=new JMenuItem("home");  
          about=new JMenuItem("About");  
          contact=new JMenuItem("Contact");  
          signup=new JMenuItem("Sign Up");  
          cart=new JMenuItem("Cart");  
          search=new JTextField("Search...");
          mb.add(home).setFont(menuFont); mb.add(about).setFont(menuFont); mb.add(contact).setFont(menuFont);  
       mb.add(signup).setFont(menuFont);  mb.add(search).setFont(menuFont);   mb.add(cart).setFont(menuFont);
        f.setJMenuBar(mb);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
  
         for (Component c : mb.getComponents()) {
        if (c instanceof JMenuItem) {
            c.addMouseListener(ml);
        }
    }
        }
       MouseListener ml = new MouseListener() {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
            boolean isMouseOut = true;
            timerMenuClear();
        }

        public void mouseEntered(MouseEvent e) {
            boolean isMouseOut = false;
            Object eSource = e.getSource();
          
            if(eSource ==home || eSource ==about || eSource == contact||eSource==signup||eSource==cart){
                ((JMenuItem) eSource).doClick();
            }
        }

              
    }; 
         public void timerMenuClear(){
    ActionListener task = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          boolean isMouseOut = false;
          if(isMouseOut == true){
              System.out.println("Timer");
          MenuSelectionManager.defaultManager().clearSelectedPath();
          }
      }
  };        
    //Delay timer half a second to ensure real mouseOUT
  Timer timer = new Timer(1000, task); 
  timer.setInitialDelay(500);        
  timer.setRepeats(false);
  timer.start();
}
         
public static void main(String args[])  
{  
new GUI();  
}} 