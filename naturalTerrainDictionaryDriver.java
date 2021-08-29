import javax.swing.*;
import java.io.*;

public class naturalTerrainDictionaryDriver
{
   public static void extraInfo(BinarySearchTree t)
   {
      System.out.print("There are " + t.size() + " nodes, ");
      System.out.println("the tree is of height " + t.height());
   }

   public static void main(String[] arg) throws IOException
   {
      naturalTerrainDictionary t = new naturalTerrainDictionary();
      ImageIcon Grass1 = t.findImage("Grass1");
      System.out.println(t);
   
   }
}