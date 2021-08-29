public class Story implements moddedQuadIndex
{
   private String storyFileName;
   private int[] images;
   private int quadIndex;
   public Story(String fN, int[] i, int index)
   {
      storyFileName = fN;
      images = i;
      quadIndex=index;
   }
   
   public String getStoryFileName()
   {
      return storyFileName;
   }
   public int getIndex()
   {
      return quadIndex;
   }
   public void setIndex(int x)
   {
      quadIndex=x;
   }
   public int[] getImages()
   {
      return images;
   }
}
