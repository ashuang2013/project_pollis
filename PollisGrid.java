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
   private static int location;			//start row for the player

   private static int[][] board;	
   private static int[][] panel;	
   private static final int DELAY=1000;	//#miliseconds delay between each time the enemy moves and screen refreshes for the timer
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   private Timer t;							//used to set the speed of the program
   private int frame;
   private static int mouseX;			//locations for the mouse pointer
   private static int mouseY;
   private static int provX;
   private static int provY;
   private int tSEC=0;
   private naturalTerrainDictionary a = new naturalTerrainDictionary();
   private Player MainCharacter= new Player(0,0, "Helios", new ImageIcon("TutorialTed.png"));
 
 ////////////////////////////////////////////////////////////////////////////////////////////////
   private NPC NPC_Beta_A= new NPC(1,1, "Jake", new ImageIcon("TestNPC.png"));
   private NPC NPC_Beta_B= new NPC(1,1, "Elwood", new ImageIcon("TutorialTom.png"));
   private NPC NPC_Beta_C= new NPC(2,5, "Richard", new ImageIcon("TutorialTom.png"));

   private NPC NPC_Beta_D= new NPC(3,3, "Bill", new ImageIcon("TestNPC.png"));
   private NPC NPC_Beta_E= new NPC(4,4, "Jill", new ImageIcon("TutorialTom.png"));
   private NPC NPC_Beta_F= new NPC(2,9, "Phil", new ImageIcon("TutorialTom.png"));
         
   private NPC[] People={NPC_Beta_A,NPC_Beta_B,NPC_Beta_C};
   private NPC[] People2={NPC_Beta_D,NPC_Beta_E,NPC_Beta_F};

   private Map Location1;
   private Map Location2;
 ////////////////////////////////////////////////////////////////////////////////////////////////   
   private static int Zone=0;
   private static int diologue=-1;

   private static final int SIZE=40;	//size of cell being drawn change to 40 when done

//////////////Collection of images used for program

   public PollisGrid()
   {
      addMouseListener(this);
      addMouseMotionListener(this);
      mouseX = 0;//#####
      mouseY = 0;//#####
      t = new Timer(DELAY, new Listener());	
      frame = 0;			
      t.start();
      
      createLocation1();
      Location1 = new Map(People, board);
      createLocation2();
      Location2 = new Map(People2, board);
      for(int r=0; r<panel.length; r++)
      {
         for(int c=0; c<panel[r].length-1; c++)
         {
            panel[r][c]= -1;
         }
      }
   }
   //Instantiates the world and the panel behind it
   //go to BoardIndex.txt in order to learn which numbers are meant to represent what lands
   public void createLocation1()
   {
      int numRows = 10;
      int numColumns = 10;
      board = new int[numRows][numColumns];
      panel = new int[numRows*3][numColumns*3];
      for(int r=0; r<board.length; r++)
      {
         for(int c=0; c<board[r].length; c++)
         {
            board[r][c]= 1;
         }
      }
      for(int r=0; r<panel.length; r++)
      {
         for(int c=0; c<panel[r].length-1; c++)
         {
            panel[r][c]= -1;
         }
      }
   }
   public void createLocation2()
   {
      int numRows = 10;
      int numColumns = 10;
      board = new int[numRows][numColumns];
      panel = new int[numRows*3][numColumns*3];
      for(int r=0; r<board.length; r++)
      {
         for(int c=0; c<board[r].length; c++)
         {
            if(r==0||c==0||r==board.length-1||c==board[r].length-1)
            {
               board[r][c]= 3;
            
            }
            else
               board[r][c]= 2;
         
         }
      }
      board[0][5]=4;
   
   
   }
   public void paintLocation1(Graphics g)
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
      for(int r=0;r<Location1.getBoard().length;r++)
      {
         x=0;
            			//reset the row distance
         for(int c=0;c<Location1.getBoard()[0].length;c++)
         {
            if(Location1.getBoard()[r][c]==1)
            {
               g.drawImage(a.findImage("Grass1").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
            }                  
            else
               if(Location1.getBoard()[r][c]==2)
               {
                  g.drawImage(a.findImage("BuildingFloor").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
               }  
               else
                  if(Location1.getBoard()[r][c]==3)
                  {
                     g.drawImage(a.findImage("BuildingWall").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
                  }      
                  else
                     if(Location1.getBoard()[r][c]==4)
                     {
                        g.drawImage(a.findImage("BuildingDoorOpened").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
                     }             
            x+=SIZE;
               
         }
         y+=SIZE;
            
            
      } 
      g.drawImage(MainCharacter.getImageIcon().getImage(),MainCharacter.getCol()*SIZE,MainCharacter.getRow()*SIZE , SIZE, SIZE, null);  //drawing the main character
      
      for(int i=0; i<Location1.getPeople().length;i++)
      {
         g.drawImage(Location1.getPeople()[i].getImageIcon().getImage(),Location1.getPeople()[i].getCol()*SIZE,Location1.getPeople()[i].getRow()*SIZE , SIZE, SIZE, null);  //drawing a test NPC
      }
   
   }
   
   /////////////////////////////////////////////
   public void paintLocation2(Graphics g)
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
      for(int r=0;r<Location2.getBoard().length;r++)
      {
         x=0;
            			//reset the row distance
         for(int c=0;c<Location2.getBoard()[0].length;c++)
         {
            if(Location2.getBoard()[r][c]==1)
            {
               g.drawImage(a.findImage("Grass1").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
            }                  
            else
               if(Location2.getBoard()[r][c]==2)
               {
                  g.drawImage(a.findImage("BuildingFloor").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
               }  
               else
                  if(Location2.getBoard()[r][c]==3)
                  {
                     g.drawImage(a.findImage("BuildingWall").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
                  }      
                  else
                     if(Location2.getBoard()[r][c]==4)
                     {
                        g.drawImage(a.findImage("BuildingDoorOpened").getImage(),x ,y , SIZE, SIZE, null);  //scaled image
                     }             
            x+=SIZE;
               
         }
         y+=SIZE;
            
            
      } 
      g.drawImage(MainCharacter.getImageIcon().getImage(),MainCharacter.getCol()*SIZE,MainCharacter.getRow()*SIZE , SIZE, SIZE, null);  //drawing the main character
      
      for(int i=0; i<Location2.getPeople().length;i++)
      {
         g.drawImage(Location2.getPeople()[i].getImageIcon().getImage(),Location2.getPeople()[i].getCol()*SIZE,Location2.getPeople()[i].getRow()*SIZE , SIZE, SIZE, null);  //drawing a test NPC
      }
   
   }

   /////////////////////////////////
   public void showDiologueLocation1(Graphics g)
   {
      if(diologue<100)
      {
         g.drawImage(Location1.getPeople()[diologue].getImageIcon().getImage(),0, 0 , SIZE*20, SIZE*20, null);  //scaled image
         g.drawString("My name is "+Location1.getPeople()[diologue].getName()+"", 25, 850);
         g.drawString("Where do you want me to go?", 25, 900);
         g.drawString("1) Left", 25, 950);
         g.drawString("2) Right", 25, 1000);         
      }
      else if(diologue>=100)
      {
         
         g.drawImage(Location2.getPeople()[diologue-100].getImageIcon().getImage(),0, 0 , SIZE*20, SIZE*20, null);  //scaled image
         g.drawString("My name is "+Location2.getPeople()[diologue-100].getName()+"", 25, 850);  
         g.drawString("Where do you want me to go?", 25, 900);
         g.drawString("1) Left", 25, 950);
         g.drawString("2) Right", 25, 1000);
      
      
         
      }
   
      
   }
   public void showTitle(Graphics g)
   {
      g.drawImage(a.findImage("Title").getImage(),0, 0 , SIZE*20, SIZE*20, null);  //scaled image
   
   }
   public void showBoard(Graphics g)//this is where all the graphics in the game take place, they are all printed in this showBoard method	
   {
   
   
      if(Zone!=0)
      {
      
         if(diologue==-1)
         {
            if(Zone==1)
               paintLocation1(g);//draw the board
            else if(Zone==2)
               paintLocation2(g);         
         }
         else
         {
            showDiologueLocation1(g);//write the diologue            
         }
      }
      else
      {
         showTitle(g);
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
         Zone=1;
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
      if(Zone!=0 && diologue==-1)
      {
         mainPlayerMovement(k);
      //Press Q to exit the game         
         if(k==KeyEvent.VK_Q)	
         {
            System.exit(1);//end
         }      
         if(k==32&&Zone==1)
         {
            Zone=2;
         }
         else if(k==32&&Zone==2)
         {
            Zone=1;
         }
      }
      else if(Zone==0)
      {
      
         menuOptions(k);
      
      }
      else if(diologue!=-1&&Zone!=0)
      {
         if(k==32)
         {
            diologue=-1;
         }
         else if(k==49)//1
         {
            if(diologue<100)
            {
               Location1.getPeople()[diologue].setLocation(0,0);
                              
               diologue=-1;
            
            }
            else if(diologue>=100)
            {
            
               Location2.getPeople()[diologue-100].setLocation(0,0);
                           
               diologue=-1;
            
            }
         
         }
         
         else if(k==50)//2
         {
            if(diologue<100)
            {
               Location1.getPeople()[diologue].setLocation(9,9);
                              
               diologue=-1;
            
            }
            else if(diologue>=100)
            {
               Location2.getPeople()[diologue-100].setLocation(9,9);
            
               diologue=-1;
            
            }
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
         if(Zone==2)
         {
            for(int i=0; i<Location2.getPeople().length;i++)
            {
               if(mouseR==Location2.getPeople()[i].getRow()&&mouseC==Location2.getPeople()[i].getCol())//make a button
               {
                  diologue=i+100;
               
               }
            
            
            }
         }
         else if(Zone==1)
         {
            for(int i=0; i<Location1.getPeople().length;i++)
            {
               if(mouseR==Location1.getPeople()[i].getRow()&&mouseC==Location1.getPeople()[i].getCol())//make a button
               {
                  diologue=i;
               
               }
            
            
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
      if(Zone==1&&diologue==-1)
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
         System.out.println(tSEC);//prints in command prompt how long the program has been active (in seconds)
         for(int a= 0; a<Location1.getPeople().length; a++)
         {
            moveNPCS(Location1.getPeople()[a]);
         }
         for(int a= 0; a<Location2.getPeople().length; a++)
         {
            moveNPCS(Location2.getPeople()[a]);
         }
         ////////////////////////////////////////
         repaint();
      }
   }
   
   
}

