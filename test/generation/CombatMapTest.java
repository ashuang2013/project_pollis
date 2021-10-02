package generation;

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import generation.combat.CombatStats;
import generation.combat.CombatNPC;
import generation.combat.Berserker;
import generation.combat.CombatMap;
import generation.combat.Slime;

   public class CombatMapTest								//Driver Program
   {
      public static CombatMap screen;					//Game window
   
      public static void main(String[]args)
      {
    	 ArrayList<CombatNPC> party = new ArrayList<CombatNPC>();
    	 ArrayList<CombatNPC> enemy = new ArrayList<CombatNPC>();
    	 
    	 party.add(new Berserker(0, 2, "Ragnorak", new ImageIcon("src/generation/Childe Pull.png"), CombatStats.Side.Ally)); 
    	 enemy.add(new Slime(0, 3, "Slime 13", new ImageIcon("src/generation/Electro Slime.png"), CombatStats.Side.Enemy, 13));
    	 enemy.add(new Slime(1, 3, "Slime 20", new ImageIcon("src/generation/Electro Slime.png"), CombatStats.Side.Enemy, 20));
    	 enemy.add(new Slime(2, 3, "Slime 11", new ImageIcon("src/generation/Electro Slime.png"), CombatStats.Side.Enemy, 11));
    	 enemy.add(new Slime(3, 3, "Slime 12", new ImageIcon("src/generation/Electro Slime.png"), CombatStats.Side.Enemy, 12));
    	 
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
