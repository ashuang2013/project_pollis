package generation;

import java.awt.Graphics;

public class DiologueNode 
{
	String S;
	String C1;
	String C2;
	String C3;
	String C4;
	String toReturn;
	public DiologueNode(String Statement, String ChoiceA, String ChoiceB, String ChoiceC, String ChoiceD)
	   {
		S=Statement;
		C1=ChoiceA;
		C2=ChoiceB;
		C3=ChoiceC;
		C4=ChoiceD;
		
	   
	   
	   }
	   
	   //pre: root points to an in-order Binary Search Tree
	   //post:adds x to the tree such that the tree is still an in-order Binary Search Tree
	   
	   public void Read(Graphics g)
	   {
	         g.drawString(S, 25, 800);
	         g.drawString(C1, 25, 850);
	         g.drawString(C2, 25, 900);
	         g.drawString(C3, 25, 950);   
	         g.drawString(C4, 25, 950);   

	   }
	   public int ToIndex(String a)
	   {
		   int i=0;
		   return i;
	   }
}
