import javax.swing.*;

public class Map  
{
   private NPC [] People;
   private int[][] Location;

   private NPC[] characters;
   
   public Map(NPC[] P,int [][] L)
   {   
      People=P;
      Location=L;
      
   }    

   public int [][] getBoard()//String that returns the name of the main character of the game
   {
      return Location;
   }

   public NPC [] getPeople()//String that returns the name of the main character of the game
   {
      return People;
   }
 

}
