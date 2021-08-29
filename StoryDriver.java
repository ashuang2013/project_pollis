public class StoryDriver
{
   public static void main(String[] arg)
   {
   QuadNode parent = new QuadNode();
   QuadTree storyline = new QuadTree(parent);
   storyline.createNewSet();
   }
}