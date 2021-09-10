package generation.combat;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import generation.NPC;
import generation.naturalTerrainDictionary;

/*
 * Author: Alex Huang
 */
public class CombatMap  extends JPanel {
	private CombatNPC[] party;
	private CombatNPC[] enemies;
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
	public CombatMap(CombatNPC[] p, CombatNPC[] e) {
		party = p;
		enemies = e;
		location = new int[8][16];
		//repaint();
	}

	/*
	 * Starts the map that will house the combat
	 */
	public void start() {
		ArrayList<CombatNPC> init = initiative(party, enemies);
		short numEnemies = (short)enemies.length;
		short numAllies = (short)party.length;
		
		System.out.println("Num enemies " + numEnemies);
		System.out.println("Num allies " + numAllies);
		
		/*
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int input = 0;
		while(numEnemies == 0 || numAllies == 0) {
			System.out.println("The berserker has " + party[0].getHealth());
			System.out.println("The slime has " + enemies[0].getHealth());
			
			if(init[i] == null) {
				break; //if this participant is dead 
			}
			
			if(init[i].getRow() == 0) { //party member
				printMenu(init[i]);
				input = sc.nextInt();
				
				ArrayList<CombatNPC> turn = new ArrayList<CombatNPC>();
				if(input == 1) {
					System.out.println("Who does " + init[i].getName() + " want to attack?");
					for(int x=0; x<enemies.length; x++) {
						
						int inc = 1;
						
						if(enemies[x] != null) {
							continue;
						}
						else {
							turn.add(enemies[x]);
							System.out.println(Integer.toString(inc) + ") " + enemies[x].getName().toString());
						}
					}
					
					input = sc.nextInt();
					
					if(input < turn.size() && input >= 0) {
						System.out.println(init[i].getName().toString() + " attacks " + turn.get(input).getName().toString());
						System.out.println(init[i].getName().toString() + " deals " + Integer.toString(init[i].getAttack()) );
					}
					
					System.out.println(init[i] + " attacks dealing " + init[i].getAttack() + " damage!");
					damageCalculationEnemy(init[i], enemies[input-1], null);
					
					if(enemies[input-1].getHealth() <= 0) { //defeated enemy
						enemies[input-1] = null;
						numEnemies--;
					}
				}
			}
			else { //enemy
				//TODO: implement AI later
				System.out.println(init[i] + " attacks dealing " + init[i].getAttack() + "!");
				int rand = (int)(Math.random()*party.length);
				while(party[rand] == null) { //redo the randomization
					rand = (int)(Math.random()*party.length);
				}
				
				//calculate damage
				//party[rand].setHealth(party[rand].getHealth() - enemies[i].getAttack()); //get the health and subtract it based on the health
				damageCalculationAlly(enemies[i], party[rand], null);
				
				if(party[rand].getHealth() <= 0) { //defeated ally
					party[rand] = null;
					numAllies--;
				}
			}
			i++; //increment the initiative counter
		}
		

		printMenu(party[1]);

		if(numAllies == 0) {
			System.out.println("Game Over. Come back when you are stronger");
		}
		else {
			System.out.println("Encounter over! You gained 12 exp!");
		}
		return;
		*/
	}
	
	/*
	 * Print the menu that the user will interact with. Currently does not display on the JPanel
	 */
	public void printMenu(CombatNPC npc) {
		System.out.println("What will " + npc.getName() + " do?\n1) Attack\n2) Spells\n3) Inventory");
		//print out stats on the right + picture
	}
	
	/*
	 * Calculates the initiative order for both sides. Return an array that has the order for combat. 
	 */
	public ArrayList<CombatNPC> initiative(CombatNPC[] p, CombatNPC[] e) {
		ArrayList<CombatNPC> init = new ArrayList<CombatNPC>();
		int plength = p.length;
		int elength = e.length;
		
		for(int i=0; i<plength; i++) {
			init.add(p[i]);
		}
		
		for(int i=0; i<elength; i++) {
			init.add(e[i]);
		}
		
		init = sort(init); //sorted
		
		for(int i=0; i<init.size(); i++) {
			System.out.println(init.get(i).getName() + " has speed " + Integer.toString(init.get(i).getSpeed()));
		}
		
		return init;
	}
	
	/*
	 * Insertion sort copied from Geeks for Geeks website: https://www.geeksforgeeks.org/insertion-sort/
	 */
    public ArrayList<CombatNPC> sort(ArrayList<CombatNPC> arr)
    {
        int s = arr.size();
        
        for(int i = 1; i < s; i++) {
            CombatNPC key = arr.get(i); //grab the current speed
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr.get(j).getSpeed() > key.getSpeed()) {
                arr.set(j+1, arr.get(j));
                j = j - 1;
            }
            arr.set(j+1, key);
        }
        
        return arr;
    }
    
	/*
	 * Calculates the damage against an ally given an enemy
	 */
	public void damageCalculationAlly(CombatNPC enemy, CombatNPC ally, Skill s) {
		if(s == null) {
			ally.setHealth(ally.getHealth() - enemy.getAttack());
		}
		else {
			//spell damage calculation
		}
	}
	
	/*
	 * Calculates the damage against an enemy given an ally
	 */
	public void damageCalculationEnemy(CombatNPC ally, CombatNPC enemy, Skill s) {
		if(s == null) {
			ally.setHealth(ally.getHealth() - enemy.getAttack());
		}
		else {
			//spell damage calculation
		}
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

		for(CombatNPC p : party)
		{
			g.drawImage(p.getImageIcon().getImage(), p.getCol()*SIZE, p.getRow()*SIZE , SIZE, SIZE, null);  //drawing a test NPC
		}


		for(CombatNPC e : enemies)
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
