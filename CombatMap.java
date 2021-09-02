import javax.swing.JPanel;
   import javax.swing.ImageIcon;
   import java.awt.Graphics;
   import java.awt.Color;
   import java.awt.event.KeyEvent;

/*
 * Author: Alex Huang
 */
public class CombatMap  extends JPanel {
	private NPC[] party;
	private NPC[] enemies;
	private int[][] location;
	private int SIZE = 100;
	
	private naturalTerrainDictionary dict = new naturalTerrainDictionary();
	/*
	 * This class will house the graphics and store the necessary elements on which combat will be fought. Some examples
	 * include the protagonist's party vs the enemies fought. Some other examples include the overall how the map will be 
	 * structured (map layout along with texture). The CombatMap will also take responsibility for executing and determining
	 * the order for combat that will occur.
	 * TODO: implement range?
	 */
	public CombatMap(NPC[] p, NPC[] e) {
		party = p;
		enemies = e;
		location = new int[8][16];
	    //repaint();
	}
	
	/*
	 * Starts the map that will house the combat
	 */
	public void start() {
		//TODO: implement
	}
	
	/*
	 * Paints the 2D array location with specified images according to the terrain (stage)
	 */
	public void showBoard(Graphics g) {
		int x = 0;
		int y = 0;
		
	
			for(int r=0; r<location.length; r++) {
				x=0;
				for(int c=0; c<location[0].length; c++) {
					g.drawImage(dict.findImage("Grass1").getImage(), x, y, SIZE, SIZE, null);
					   x+=SIZE;
	            }
	            y+=SIZE;
			}
			
		      for(NPC p : party)
		      {
		         g.drawImage(p.getImageIcon().getImage(), p.getCol()*SIZE, p.getRow()*SIZE , SIZE, SIZE, null);  //drawing a test NPC
		      }
			
		      for(NPC e : enemies)
		      {
		         g.drawImage(e.getImageIcon().getImage(), e.getCol()*SIZE, e.getRow()*SIZE , SIZE, SIZE, null);  //drawing a test NPC
		      }
	}

	public void processUserInput(int k)
	   {
	   //player movement abilities(use WASD to move)
	    
	         
	           
	      
	      repaint();			//refresh the screen
	   }
	
	

    public void paintComponent(Graphics g)
    {
       super.paintComponent(g); 
       g.setColor(Color.blue);		//draw a blue boarder around the board
       g.fillRect(0, 0, (location[0].length*SIZE), (location.length*SIZE));
       showBoard(g);					//draw the contents of the array board on the screen
    }
}
