package generation;

import javax.swing.*;

public class Player  
{
   private int col;
   private int row;
   private String Name;
   private ImageIcon Character;
   public Player(int r, int c, String x, ImageIcon a)
   {   
      col=c;
      row=r;
      Name=x;
      Character=a;
   }    
   public void changeCol(int x)//gives the ability to alter the player's horizontal position by a factor of x(Most common use of this method should be to change poistion by (+ or -) 1)

   {
      col= col+x;
   }
   public void changeRow(int x)//gives the ability to alter the player's verticle position by a factor of x(Most common use of this method should be to change poistion by (+ or -) 1)
   {
      row= row+x;
   }
   public int getRow()//returns the row of the main character
   {
      return row;
   }
      public int getCol()//returns the col of the main character
   {
      return col;
   }
   public ImageIcon getImageIcon()//Returns the image of the main player of the game
      {
      return Character;
   }

   public String getName()//String that returns the name of the main character of the game
   {
      return Name;
   }
   
 

}