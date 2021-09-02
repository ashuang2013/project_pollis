   import javax.swing.JFrame;
   import java.awt.event.KeyListener;
   import java.awt.event.KeyEvent;
   import javax.swing.*;
   import java.awt.Graphics;
   import java.awt.Color;
   import java.awt.Font;
   
   public class CombatMapTest								//Driver Program
   {
      public static CombatMap screen;					//Game window
   
   
      public static void main(String[]args)
      {
    	 NPC[] party = {new NPC(0, 0, "Party 1", new ImageIcon("Childe Pull.png")), new NPC(1, 0, "Party 2", new ImageIcon("Albedo Pull 12-24.png")), 
    			 new NPC(2, 0, "Party 3", new ImageIcon("Xiao Pull 12-27.jpg")), new NPC(3, 0, "Party 4", new ImageIcon("Zhongli Pull 4-28.png"))};
    	 NPC[] enemy = {new NPC(3, 3, "Enemy 1", new ImageIcon("Childe Pull.png"))};
    	 
         screen = new CombatMap(party, enemy);
         JFrame frame = new JFrame("Arrays Represented in Graphics with Keyboard Input");	//window title
         frame.setSize(800, 800);					//Size of game window
         frame.setLocation(100, 50);				//location of game window on the screen
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(screen);		
         frame.setVisible(true);
         frame.addKeyListener(new listen());		//Get input from the keyboard
      
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
