import javax.swing.*;

public class NPC  
{
   private int col;
   private int row;
   private String Name;
   private int intendedCol;
   private int intendedRow;
   private ImageIcon Character;
   private int state=0;
   private String[] Diologue;

   //WORK IN PROGRESS
   private int hp;
   private int atk;
   private int pdef;
   private int mdef;
   private int spd;
   private int mana;
   private int skills; //for later
   
   /*
    * BRAINSTORMING COMBAT
    * 
    * Each character that goes into combat needs certain stats (right now decided hp, attack, defense, speed, mana and skills). Each character's stats can 
    * then be augmented with gear that should be equipped during inventory. 
    * 
    * Hp (health points) is the character's health or damage that can be taken before they are killed. Atk (attack) is how much the character does per attack. 
    * Def (def) is how much damage the character mitigates (will split between magic and physical damage). Spd (speed/agility) determines who goes first in a combat
    * encounter and should increase chances to hit and crit chance and damage. Mana is the pool that will decrease with successive casts of spells. Skills are the 
    * spells that will be case
    */
   public NPC(int r, int c, String x, ImageIcon a)
   {   
      col=c;
      row=r;
      Name=x;
      Character=a;
   }    
   public int getCol()//returns the col of the main character
   {
      return col;
   }
   public int getRow()//returns the row of the main character
   {
      return row;
   }
   public void alterR(int x)//gives the ability to alter the player's verticle position by a factor of x(Most common use of this method should be to change poistion by (+ or -) 1)
   {
      row= row+x;
   }
   public void alterC(int x)//gives the ability to alter the player's horizontal position by a factor of x(Most common use of this method should be to change poistion by (+ or -) 1)
   {
      col=col+x;
   }
   public void setState(int x)//gives the ability to alter the player's horizontal position by a factor of x(Most common use of this method should be to change poistion by (+ or -) 1)
   {
      state=x;
   }
   public int getState()//gives the ability to alter the player's horizontal position by a factor of x(Most common use of this method should be to change poistion by (+ or -) 1)
   {
      return state;
   }
   public int getIntendedCol()
   {
      return intendedCol;
   }
   public int getIntendedRow()
   {
      return intendedRow;
   
   }
   public void setLocation(int x, int y)//gives the ability to alter the player's horizontal position by a factor of x(Most common use of this method should be to change poistion by (+ or -) 1)
   {
      intendedCol=x;
      intendedRow=y;
   }
   public String getName()//String that returns the name of the main character of the game
   {
      return Name;
   }
   public ImageIcon getImageIcon()//Returns the image of a npc of the game
   {
      return Character;
   }
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////
   //WORK IN PROGRESS
   
  public int getHp() {
	  return hp;
  }
  
  public int getAttack() {
	  return atk;
  }
  
  public int getPDefense() {
	  return pdef;
  }
  
  public int getMDefense() {
	  return mdef;
  }
  
  public int getSpeed() {
	  return spd;
  }

  public int getMana() {
	  return mana;
  }
 

}
