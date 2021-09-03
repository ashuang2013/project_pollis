package generation;

public class QuadNode
{
   private moddedQuadIndex mQI;                                        //Comparable value
   private QuadNode child1;                                    //points to 1st subtree
   private QuadNode child2;                                    //points to 2nd subtree
   private QuadNode child3;                                    //points to 3rd subtree
   private QuadNode child4;                                    //points to 4th subtree

   public QuadNode(moddedQuadIndex s)                                    //base case: the node created has each child pointing to null
   {
      mQI = s;
      child1 = null;
      child2 = null;
      child3 = null;
      child4 = null;
   }
   
   public QuadNode(moddedQuadIndex s, QuadNode c1)
   {
      mQI = s;
      child1 = c1;
      child2 = null;
      child3 = null;
      child4 = null;
   }
   
   public QuadNode(moddedQuadIndex s, QuadNode c1, QuadNode c2) 
   {
      mQI = s;
      child1 = c1;
      child2 = c2;
      child3 = null;
      child4 = null;
   }
   
   public QuadNode(moddedQuadIndex s, QuadNode c1, QuadNode c2, QuadNode c3)
   {
      mQI = s;
      child1 = c1;
      child2 = c2;
      child3 = c3;
      child4 = null;
   }
   
   public QuadNode(moddedQuadIndex s, QuadNode c1, QuadNode c2, QuadNode c3, QuadNode c4)
   {
      mQI = s;
      child1 = c1;
      child2 = c2;
      child3 = c3;
      child4 = c4;
   }
   
   //ACCESSOR METHODS
   public QuadNode getChild1()
   {
      return child1;
   }

   public QuadNode getChild2() 
   {
      return child2;
   }

   public QuadNode getChild3() 
   {
      return child3;
   }

   public QuadNode getChild4() 
   {
      return child4;
   }
     
   public moddedQuadIndex getmoddedQuadIndex() 
   {
      return mQI;
   }
   
   //MUTATOR METHODS
   public void setChild1(QuadNode c1)
   {
      child1 = c1;
   }
   
   public void setChild2(QuadNode c2)
   {
      child2 = c2;
   }
   
   public void setChild3(QuadNode c3)
   {
      child3 = c3;
   }
   
   public void setChild4(QuadNode c4)
   {
      child4 = c4;
   }
}
