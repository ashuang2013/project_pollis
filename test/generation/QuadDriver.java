package generation;

import java.io.*;

public class QuadDriver
{
   /*public static void extraInfo(QuadTreeTest t)
   {
      System.out.print("There are " + t.size() + " nodes, ");
      System.out.println("the tree is of height " + t.height());
   }*/

   public static void main(String[] arg) throws IOException
   {
      QuadTree t = new QuadTree();
      System.out.println(t);  //should be: []
      int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
      t.add(new Story("hello", intArray, 1)); //parent node
      t.add(new Story("1", intArray, 11)); //parent node
      t.add(new Story("2", intArray, 12)); //parent node
      t.add(new Story("3", intArray, 13)); //parent node
      t.add(new Story("4", intArray, 14)); //parent node
   
      /*
      System.out.println(t);  //should be: [A, B, D, R, S, T, W, Y]
      t.showPreOrder();       //should be: R A B D S W T Y
      t.showInOrder();        //should be: A B D R S T W Y
      t.showPostOrder();      //should be: D B A T Y W S R
      extraInfo(t);           //should be: There are 8 nodes, the tree is of height 3
      System.out.println();
      t.remove("Y");
      t.remove("A");
      t.remove("Z"); //yes, we will try to remove what is not there
      t.showPreOrder();       //should be: R B D S W T
      t.showInOrder();        //should be: B D R S T W
      t.showPostOrder();      //should be: D B T W S R
      extraInfo(t);           //should be: There are 6 nodes, the tree is of height 3
      System.out.println(t);  //should be: [B, D, R, S, T, W]
      */
   }
}