package generation;
import javax.swing.JFrame;

import java.awt.Toolkit; //Screen resolution
import java.awt.Dimension;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;


public class PollisDriver							//Driver Program
{
   public static PollisGrid screen;					//Game window


   public static void main(String[]args)
   {
      screen = new PollisGrid();
      JFrame frame = new JFrame("Project Pollis");	//window title
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int screenHeight = screenSize.height;
      int screenWidth = screenSize.width;
      frame.setSize(screenWidth, screenHeight);
      frame.setLocation(0, 0);				//location of game window on the screen////////////////////////gamestate 1
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); /////////////////gamestate 2
    // frame.setUndecorated(true);/////////////////////////////gamestate 2
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


//TODO:
//1/17/2021
//Create Map Class that contains both array of boards, and NPCs
//make an array of these map classes

//create a chapter class, that contains the array of maps

//THIS IS A TEST Type 2