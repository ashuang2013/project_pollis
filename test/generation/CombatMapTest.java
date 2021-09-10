package generation;

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import generation.combat.CombatNPC;
import generation.combat.Berserker;
import generation.combat.CombatMap;
import generation.combat.Slime;

   public class CombatMapTest								//Driver Program
   {
      public static CombatMap screen;					//Game window
   
   
      public static void main(String[]args)
      {
    	  
    	 CombatNPC[] party = {new Berserker(0, 0, "Ragnorak", new ImageIcon("src/generation/Childe Pull.png"))};//, new NPC(1, 0, "Party 2", new ImageIcon("src/generation/Albedo Pull 12-24.png")), 
    			 //new NPC(2, 0, "src/generation/Party 3", new ImageIcon("src/generation/Xiao Pull 12-27.jpg")), new NPC(3, 0, "Party 4", new ImageIcon("src/generation/Zhongli Pull 4-28.png"))};
    	 CombatNPC[] enemy = {new Slime(0, 3, "Slime 13", new ImageIcon("src/generation/Electro Slime.png"), 13), new Slime(1, 3, "Slime 20", new ImageIcon("src/generation/Electro Slime.png"), 20), 
    			 new Slime(2, 3, "Slime 11", new ImageIcon("src/generation/Electro Slime.png"), 11), new Slime(3, 3, "Slime 12", new ImageIcon("src/generation/Electro Slime.png"), 12)};
    	 
    	 
         screen = new CombatMap(party, enemy);
         JFrame frame = new JFrame("Arrays Represented in Graphics with Keyboard Input");	//window title
         frame.setSize(800, 800);					//Size of game window
         frame.setLocation(100, 50);				//location of game window on the screen
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(screen);		
         frame.setVisible(true);
         frame.addKeyListener(new listen());		//Get input from the keyboard
         
         screen.start(); //start the combat
      }
      
      public static class listen implements KeyListener 
      {
      
         public void keyTyped(KeyEvent e)
         {
         
         }
         
         public void keyPressed(KeyEvent e)
         {
         
         }
      
         public void keyReleased(KeyEvent e)
         {
            screen.processUserInput(e.getKeyCode());
         }
      }
   
   }
