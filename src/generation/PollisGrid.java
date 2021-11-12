package generation;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
/////////////////////////////////////////////
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


import java.io.*;
/////////////////////////////////////
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/////////////////////


//////////////////
// ineed to make all Land tiles gif because they need transperancy. RIP
public class PollisGrid extends JPanel implements MouseListener, MouseMotionListener
{     
   private static int[][] board=new int[5][5];	
   private static int[][] panel=new int[10][10];	
   private static final int DELAY=1000;	//#miliseconds delay between each time the enemy moves and screen refreshes for the timer
/////////////////////////////////////////////////////////////////////////////////////////////////
   private Timer t;							//used to set the speed of the program
   private static long lastFrame=0;
   private static int currentFrame=0;
   private static int totalFrame=0;

   private static int mouseX;			//locations for the mouse pointer
   private static int mouseY;
   private static int provX;
   private static int provY;
   private int tSEC=0;
   private naturalTerrainDictionary a = new naturalTerrainDictionary();
   private Player MainCharacter= new Player(0,0, "Helios", new ImageIcon("src/generation/TutorialTed.png")); 
 ////////////////////////////////////////////////////////////////////////////////////////////////         
   private NPC[] People= new NPC[6];
   int currLocation=1;
 ////////////////////////////////////////////////////////////////////////////////////////////////   
   private static String State="Start Menu";//"Start Menu", "Game", "Dialogue"
   private static int DialogueIndex=-1;

   private static final int SIZE=40;	//size of cell being drawn change to 40 when done

//////////////Collection of images used for program

   public PollisGrid()
   {
      addMouseListener(this);
      addMouseMotionListener(this);
      mouseX = 0;//#####
      mouseY = 0;//#####
      t = new Timer(DELAY, new Listener());	
      t.start();
      loadNPCSandLocation(1);
      for(int r=0; r<panel.length; r++)
      {
         for(int c=0; c<panel[r].length-1; c++)
         {
            panel[r][c]= -1;
         }
      }
      
   }
   public void loadNPCSandLocation(int desiredLocation)
   {
	   //TODO: Updates File of NPC STATUS FROM PREV INPUT
	   
	   if(desiredLocation==1)
	   {
	    try {
	 	   int index=0;
	    	File myObj = new File("src/generation/NPCs.txt");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	   	   	  String[] arrOfStr = data.split(",");
	   	      People[index]=new NPC(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]),arrOfStr[2],new ImageIcon("src/generation/"+arrOfStr[3]));
	   	      index++;
	        }
	        myReader.close();
	        for(int i = 0; i<People.length;i++)
	        {
	        String nameOfNPC=People[i].getName();
	    	File obj2 = new File("src/generation/"+nameOfNPC+".txt");
	        Scanner myReader2 = new Scanner(obj2);
	        
	        while (myReader2.hasNextLine()) {
	          String data = myReader2.nextLine();
	   	   	  String[] arrOfStr = data.split(",");
	   	      People[i].setDiologue(arrOfStr);
	        }
	        myReader2.close();
	        }
	    }
	    catch (FileNotFoundException e) {
	        System.out.println("NPC ERROR");
	        e.printStackTrace();
	      }
	    try {
	 	   int index=0;
	        File myObj = new File("src/generation/Location.txt");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	   	   	  String[] arrOfStr = data.split(" ");
	   	   	  for(int i=0; i<arrOfStr.length;i++)
	   	   	  {
	   	   		  board[index][i]= Integer.parseInt((arrOfStr[i]));
	   	   	  }
	   	      index++;
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("MAP ERROR");
	        e.printStackTrace();
	      }
	    
		   currLocation=desiredLocation;
		   

	    
	   }
   }
   

   //Instantiates the world and the panel behind it
   //go to BoardIndex.txt in order to learn which numbers are meant to represent what land
   public void paintLocation(Graphics g)
   {
      int x=0;
      int y=0;
      for(int r=0;r<panel.length;r++)
      {
         x=0;
  			//reset the row distance
         for(int c=0;c<panel[0].length;c++)
         {
            if(panel[r][c]==-1)
            {
               g.drawImage(a.findImage("Background").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
            }                              
            x+=SIZE;   
         }
         y+=SIZE;
   
      } 
      x=0;
      y=0;
      for(int r=0;r<board.length;r++)
      {
         x=0;
            			//reset the row distance
         for(int c=0;c<board[0].length;c++)
         {
            if(board[r][c]==1)
            {
               g.drawImage(a.findImage("Grass1").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
            }                  
            else
               if(board[r][c]==2)
               {
                  g.drawImage(a.findImage("BuildingFloor").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
               }  
               else
                  if(board[r][c]==3)
                  {
                     g.drawImage(a.findImage("BuildingWall").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
                  }      
                  else
                     if(board[r][c]==4)
                     {
                        g.drawImage(a.findImage("BuildingDoorOpened").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
                     }             
            x+=SIZE;
         }
         y+=SIZE;   
      } 
      g.drawImage(MainCharacter.getImageIcon().getImage(),MainCharacter.getCol()*SIZE,MainCharacter.getRow()*SIZE , SIZE, SIZE, null);  //drawing the main character
      
      for(int i=0; i<People.length;i++)
      {
         g.drawImage(People[i].getImageIcon().getImage(),People[i].getCol()*SIZE,People[i].getRow()*SIZE , SIZE, SIZE, null);  //drawing a test NPC
      }
     // g.setColor(Color.BLACK);
     // g.drawString(String.valueOf(currentFrame),  25, 1000);
   }
   
   /////////////////////////////////////////////

   /////////////////////////////////
   public void showDiologueLocation(Graphics g)
   {

         g.drawImage(People[DialogueIndex].getImageIcon().getImage(),0, 0 , SIZE*20, SIZE*20, null);  //scaled image
         //PRINT THE NPC AT INDEX DIOLOGUE, and their lines
         g.drawString("My name is "+People[DialogueIndex].getName()+"", 25, 850);
         g.drawString(People[DialogueIndex].getDiologue()[0], 25, 900);
         g.drawString("1) Left", 25, 950);
         g.drawString("2) Right", 25, 1000);         
      

      
   }
   public void showBoard(Graphics g)//this is where all the graphics in the game take place, they are all printed in this showBoard method	
   {
   

         if(State=="Game")
         {
            paintLocation(g);//draw the board
         }
         else if(State=="Dialogue")
         {
            showDiologueLocation(g);//write the diologue            
         }
         else if(State=="Start Menu")
	      {
	          g.drawImage(a.findImage("Title").getImage(),0, 0 , SIZE*20, SIZE*20, null);  //scaled image
	      }
   }
     
   public void mainPlayerMovement(int k)
   {
      if(k==KeyEvent.VK_W)
      {
         if(MainCharacter.getRow()>0)
            MainCharacter.changeRow(-1);
      }
      else
         if(k==KeyEvent.VK_A)
         {
            if(MainCharacter.getCol()>0)
               MainCharacter.changeCol(-1);
            
         }
         else
            if(k==KeyEvent.VK_S)
            {
               if(MainCharacter.getRow()<board.length-1)
                  MainCharacter.changeRow(1);
               
            }
            else
               if(k==KeyEvent.VK_D)
               {
                  if(MainCharacter.getCol()<board[0].length-1)
                  
                     MainCharacter.changeCol(1);
                  
               }
   }
   ///////////////////////////////////////////////////////
   
   
   public void menuOptions(int k)
   {
      if(k==49)//start new game
      {
    	  State= "Game";
      }
      else
         if(k==50)//start load game
         {
            
         }
         else
            if(k==51)
            {
               System.exit(1);//end game                  
            }
      
   }
   
   
      	//THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
	//pre:   k is a valid keyCode
	//post:  changes the players position depending on the key that was pressed (sent from the driver)
	//			keeps the player in the bounds of the size of the array board, then the enemy moves

   public void processUserInput(int k)
   {
   //player movement abilities(use WASD to move)
      if(State=="Game")
      {
         mainPlayerMovement(k);
      //Press Q to exit the game         
         if(k==KeyEvent.VK_Q)	
         {
        	 State="Start Menu";
         }      
      }
      else if(State == "Start Menu")
      {
      
         menuOptions(k);
      
      }
      else if(State=="Dialogue")
      {
         if(k==32)
         {
        	 DialogueIndex=-1;
        	 State="Game";
         }
         else if(k==49)//1
         {
	    	People[DialogueIndex].setLocation(0,0);             
	    	DialogueIndex=-1;
       	 	State="Game";
         }
         else if(k==50)//2
         {
        	 People[DialogueIndex].setLocation(9,9);                
        	 DialogueIndex=-1;
        	 State="Game";
         }
         }
      repaint();			//refresh the screen
      System.out.println(k);
   }
     
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
               
         
      showBoard(g);					//draw the contents of of showboard (Including characters, board, the menu, and the background panel )
   }

    
   public void mousePressed( MouseEvent e )//#####
   {}

   public void mouseReleased( MouseEvent e )//#####
   {}

   public void mouseEntered( MouseEvent e )//#####
   {}

   public void mouseMoved( MouseEvent e)//#####
   {
      mouseX = e.getX();
      mouseY = e.getY();
      
      int mouseR = (mouseY/SIZE);
      int mouseC = (mouseX/SIZE);
     // System.out.println(mouseR+":"+mouseC);
   
      // repaint();			//refresh the screen
   }

   public void mouseDragged( MouseEvent e)//#####
   {}

   public void mouseExited( MouseEvent e )//#####
   {}
    
   public void mouseClicked( MouseEvent e )//#####
   {
      int button = e.getButton();
      if(button == MouseEvent.BUTTON1 /*|| button == MouseEvent.BUTTON3*/)
      {
         int mouseR = (mouseY/SIZE);
         int mouseC = (mouseX/SIZE);
         for(int i=0; i<People.length;i++)
           {
             if(mouseR==People[i].getRow()&&mouseC==People[i].getCol())//make a button
             {
            	 DialogueIndex=i; 
            	 State="Dialogue";
             }
           }
      }
      repaint();
   }
   

//////////////////////////////////////////////////////////
/*This section contains methods that are meant to be used in real time(Ie. Constant ticks on the game will activiate the methods)
*/
   //This method will alter the locations of the NPCs in the game.
   //TODO: Create NPC MOVEMENT using an array format, instead of hard coded for Erik
   public void moveNPCS(NPC A)
   {
      if(State=="Game")
      {
         if(A.getIntendedRow()!=A.getRow()||A.getIntendedCol()!=A.getCol())
         {
            if(A.getIntendedRow()!=A.getRow())
            {
               if(A.getIntendedRow()<A.getRow())
                  A.alterR(-1);   
               else
                  A.alterR(1);   
            }
            if(A.getIntendedCol()!=A.getCol())
            {
               if(A.getIntendedCol()<A.getCol())
                  A.alterC(-1);   
               else
                  A.alterC(1);   
            }
         }
         else
            A.setState(1);
      }
   }
   
   

   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)	//this is called for each timer iteration
      {
         tSEC++;//tracks how long the game has been running (in seconds)  
       //  totalFrame++;
       //  if(System.nanoTime()>lastFrame+1000000000)
        // {
        	// lastFrame= System.nanoTime();
        	// currentFrame= totalFrame;
        	// totalFrame=0;
        // }
         for(int a= 0; a<People.length; a++)
         {
            moveNPCS(People[a]);
         }
         ////////////////////////////////////////
         repaint();
      }
   }
   
   
}

