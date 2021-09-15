package generation;

import javax.swing.*; 
import java.io.File;

public class naturalTerrainDictionary
{      
   public naturalTerrainDictionary()
   {
   }
   //pre: Input a String (Case Sensitive) that is the name of an image located anywhere within the naturalTerrainImages Folder
   //post: Returns an ImageIcon for the image that is named after the String inputed
   public ImageIcon findImage(String a)
   {
      Character b=a.charAt(0);//Takes the first character of the String 
      String FileIndexToCreateImageIcon = "naturalTerrainImages/";//Creates the string that will actually be searched
      FileIndexToCreateImageIcon = FileIndexToCreateImageIcon+b.toUpperCase(b)+"/";
      FileIndexToCreateImageIcon = FileIndexToCreateImageIcon+a+".png";
      return new ImageIcon(FileIndexToCreateImageIcon);
   }

}
