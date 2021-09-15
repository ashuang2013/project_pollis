package generation;

import java.io.*;
  
public class BinarySearchTree
{
   private TreeNode myRoot;
   
   public BinarySearchTree()
   {
      myRoot = null;
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:adds x to the tree such that the tree is still an in-order Binary Search Tree
   
   public void add(Comparable x)
   {
      myRoot = addHelper(myRoot, x);
   }
   
   private TreeNode addHelper(TreeNode root, Comparable x) //done
   {
   //************COMPLETE THIS METHOD*****************************
      if(root == null)
      {
         root = new TreeNode(x);
      }
      else
         if(root.getValue().compareTo(x) > 0)
         {
            root.setLeft(addHelper(root.getLeft(), x));
         }
         else
         {
            root.setRight(addHelper(root.getRight(), x));
         } 
   //************************************************************           
      return root;
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:removes x from the tree such that the tree is still an in-order Binary Search Tree
   
   public void remove(Comparable x)
   {
      myRoot = removeHelper(myRoot, x);
   }
   
   private TreeNode removeHelper(TreeNode root, Comparable x)
   {
   //************COMPLETE THIS METHOD*****************************
      TreeNode p = root, m = root;
      TreeNode d = searchHelper(root, x); //to the tree node that I want to delete
   
      p = searchParent(root, x);
      if(root == null) //removing empty tree
      {
         return null;
      }
      else
         if(isLeaf(d) == true) //removing a leaf
         {         
            if(d == p.getRight())
            {
               p.setRight(null);
            }
            else
               if(d == p.getLeft())
               {
                  p.setLeft(null);
               }
         }
         else
            if(oneKid(d) == true) //removing a node with one child 
            {  
               if(d == p.getLeft() && d.getLeft() != null) //d is a left child and has a left child
               {
                  p.setLeft(d.getLeft());
                        //d.setLeft(null);
               }
               else
                  if(d == p.getLeft() && d.getRight() != null) //d is a left child and has a right child
                  {
                     p.setLeft(d.getRight());
                           //d.setRight(null);
                  }
                  else
                     if(d == p.getRight() && d.getLeft() != null) //d is a right child and has a left child
                     {
                        p.setRight(d.getLeft());
                              //d.setLeft(null);
                     }
                     else
                        if(d == p.getLeft() && d.getRight() != null) //d is a right child and has a right child
                        {
                           p.setRight(d.getRight());
                                 //d.setRight(null);
                        }
            }
            else //removing two nodes
            {
               m = root.getLeft();
               while(m.getLeft() != null) 
               {
                  m = m.getLeft();
               }
               if(d == null) 
               {
                  return root;
               }
               Comparable temp = m.getValue();
               removeHelper(root, temp);
               d.setValue(temp); 
                     //p.setLeft(null)
            }
   //************************************************************  
      return root;         
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:shows the elements of the tree such that they are displayed in prefix order
   
   public void showPreOrder()
   {
      preOrderHelper(myRoot);
      System.out.println();
      
   }
   
   private void preOrderHelper(TreeNode root)
   {
   //************COMPLETE THIS METHOD***************************** //done
      if(root!=null)
      {
         System.out.print(root.getValue() + " ");   
         preOrderHelper(root.getLeft());
         preOrderHelper(root.getRight());
      }
   //************************************************************  
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:shows the elements of the tree such that they are displayed in infix order
   
   public void showInOrder()
   {
      inOrderHelper(myRoot);
      System.out.println();
   }
   public String returnInOrder()
   {
      String temp= inOrderHelper2(myRoot);
      return temp;
   }
   private void inOrderHelper(TreeNode root)   
   {
      if(root!=null)
      {
         inOrderHelper(root.getLeft());
         System.out.print(root.getValue() + " ");    
         inOrderHelper(root.getRight());
      }
   }
      
   //pre: root points to an in-order Binary Search Tree
   //post:shows the elements of the tree such that they are displayed in postfix order
   
   public void showPostOrder()
   {
      postOrderHelper(myRoot);
      System.out.println(); 
   }
   
   private void postOrderHelper(TreeNode root)
   {
   //************COMPLETE THIS METHOD***************************** //done
      if(root!=null)
      {  
         postOrderHelper(root.getLeft());
         postOrderHelper(root.getRight());
         System.out.print(root.getValue() + " "); 
      }
   //************************************************************  
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:returns whether or not x is found in the tree
   
   public boolean contains(Comparable x)
   {
      if (searchHelper(myRoot, x)==null)
         return false;
      return true;
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:returns the found value x, null if no such value exists
   public Comparable find(Comparable x)
   {
      return searchHelper(myRoot, x).getValue();
   }
   

   
   private TreeNode searchHelper(TreeNode root, Comparable x) //done
   {
   //************COMPLETE THIS METHOD*****************************
      if(root == null)
      {
         return null;
      }
      else
         if(root.getValue().equals(x))
         {
            return root; 
         }
         else
            if(root.getValue().compareTo(x) > 0)
            {
               return searchHelper(root.getLeft(), x);
            }
            else
            {
               return searchHelper(root.getRight(), x);
            } 
   
   }
   
   //pre: root points to an in-order Binary Search Tree
   //post:returns a reference to the parent of the node that contains x, returns null if no such node exists
   //THIS WILL BE CALLED IN THE METHOD removeRecur
   private TreeNode searchParent(TreeNode root, Comparable x)
   {
   //************COMPLETE THIS METHOD***************************** //check
      TreeNode right = root.getRight(), left = root.getLeft();
      if(contains(x) == false)
      {
         return null;
      }
      
      if(root == null)
      {
         return null;
      }
      
      if(left != null && left.getValue().equals(x))
      {
         return root;
      }
   
      if(right != null &&  right.getValue().equals(x))
      {
         return root;
      }
      if(x.compareTo(root.getValue()) < 0)
         return searchParent(root.getLeft(), x);
      return searchParent(root.getRight(), x);
           //************************************************************  
   }
   
   //post: determines if root is a leaf or not O(1)
   private boolean isLeaf(TreeNode root)
   {
   //************COMPLETE THIS METHOD***************************** //done
      if(root == null)
      {
         return false;
      }
      else
         if(root.getLeft() == null && root.getRight() == null)
         {
            return true;
         }
   //************************************************************  
      return false;
   }
      
   //post: returns true if only one child O(1)
   private boolean oneKid(TreeNode root)
   {
   //************COMPLETE THIS METHOD***************************** //done
      if(root == null)
      {
         return false;
      }
      else
         if(root.getLeft() != null || root.getRight() == null)
         {
            return true;
         }
         else
            if(root.getRight() != null || root.getLeft() == null)
            {
               return true;
            }
   //************************************************************  
      return false;
   }
      
   //pre: root points to an in-order Binary Search Tree
   //post:returns the number of nodes in the tree
   
   public int size()
   {
      return sizeHelper(myRoot);
   }
   
   private int sizeHelper(TreeNode root)
   {
   //************COMPLETE THIS METHOD***************************** //done
      if(root == null)
      {
         return 0;
      }
      return 1 + sizeHelper(root.getLeft()) + sizeHelper(root.getRight());
   //************************************************************  
   }
         
   public int height()
   {
      return heightHelper(myRoot);
   }

   //pre: root points to an in-order Binary Search Tree
   //post:returns the height (depth) of the tree
   
   public int heightHelper(TreeNode root)
   {
   //************COMPLETE THIS METHOD***************************** //done
      int right = 0, left = 0;
      if(root == null || isLeaf(root))
      {
         return 0;
      } 
      else
         if(isLeaf(root) == false)
         {
            left = heightHelper(root.getLeft()); 
            right = heightHelper(root.getRight());
         }
   
      if(left > right)
      {
         return 1 + left;
      }
      else
      {
         return 1 + right;
      }
   
   //************************************************************  
   }
   
   //EXTRA CREDIT
   //pre: root points to an in-order Binary Search Tree
   //post:returns true if p is an ancestor of c, false otherwise
   
   public boolean isAncestor(TreeNode root, Comparable p, Comparable c)
   {
      return false;
   }
   
   //EXTRA CREDIT
   //pre: root points to an in-order Binary Search Tree
   //post:shows all elements of the tree at a particular depth
   
   public void printLevel(TreeNode root, int level)
   {
      
   }
 
  //Nothing to see here...move along.
   private String temp;
   private String inOrderHelper2(TreeNode root)   
   {
      if(root!=null)
      {
         inOrderHelper2(root.getLeft());
         temp += (root.getValue() + ", "); 
         inOrderHelper2(root.getRight());
      }
      return temp;
   }

   public String toString()
   {
      temp="";
      inOrderHelper2(myRoot);
      if(temp.length() > 1)
         temp = temp.substring(0, temp.length()-2);
      return "[" + temp + "]";
   }
  
}