import java.io.*;

public class QuadTree
{  
   private QuadNode myRoot;

   public QuadTree()
   {
      myRoot = null;
   }
   
   public void add(moddedQuadIndex s)
   {
      int a=s.getIndex();
      myRoot = addHelper(myRoot, s,a);
   }
   
   private QuadNode addHelper(QuadNode root, moddedQuadIndex s, int a) //our Comparable value will be the index we want to add to 
   {
      int mod = s.getIndex() % 10;
      a= a/10;
   
      if(root == null)
      {
         root = new QuadNode(s);
      }
      else
         if(mod == 1) //we do not use 0
         {
            root.setChild1(addHelper(root.getChild1(),s,a));
         }
         else if(mod == 2)
         {
            root.setChild2(addHelper(root.getChild2(),s,a));
         }    
         else if(mod == 3)
         {
            root.setChild3(addHelper(root.getChild3(), s,a));
         }
         else
         {
            root.setChild4(addHelper(root.getChild4(), s,a));
         }       
      return root;
   }
   

}