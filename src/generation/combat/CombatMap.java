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
import generation.combat.CombatStats;

/*
 * Author: Alex Huang
 */
public class CombatMap  extends JPanel {
	private ArrayList<CombatNPC> party;
	private ArrayList<CombatNPC> enemies;
	private int[][] location;
	private int SIZE = 100;

	private Scanner sc = new Scanner(System.in);
	private naturalTerrainDictionary dict = new naturalTerrainDictionary();
	/*
	 * This class will house the graphics and store the necessary elements on which combat will be fought. Some examples
	 * include the protagonist's party vs the enemies fought. Some other examples include the overall how the map will be 
	 * structured (map layout along with texture). The CombatMap will also take responsibility for executing and determining
	 * the order for combat that will occur.
	 * TODO: implement range?
	 */
	public CombatMap(ArrayList<CombatNPC> p, ArrayList<CombatNPC> e) {
		party = p;
		enemies = e;
		location = new int[8][16];
		//repaint();
	}

	/*
	 * Starts the map that will house the combat
	 */
	public void start() {	
		short numEnemies = (short)enemies.size();
		short numAllies = (short)party.size();

		ArrayList<CombatNPC> init = initiative(party, enemies);
		CombatNPC player = init.get(init.size()-1);
		int index = init.size()-1;
	
		while(numEnemies != 0 && numAllies != 0) {
			if(init.get(index).getSide() == CombatStats.Side.Ally) { //party member
				short playerChoice = printMenu(init.get(index));
				
				if(playerChoice <= 0 && playerChoice > 3) {
					System.out.println("Please choose a valid command...");
					playerChoice = printMenu(init.get(index));
				}
				
				if(playerChoice == 1) { //party member attacks
					short playerAttack;
					System.out.println("Who does " + init.get(index).getName() + " want to attack?");
					
					for(int i=0; i<enemies.size(); i++) {	
						//print out a list of possible enemies to attack in format: i+1) enemy
						System.out.println(Integer.toString(i+1) + ") " + enemies.get(i).getName());
					}
					
					//USER INPUT FOR ATTACKING
					playerAttack = (short)sc.nextInt();
					if(playerAttack < 0 && playerAttack >= enemies.size()) {
						System.out.println("Please choose a valid enemy...");
						playerAttack = (short)sc.nextInt();
					}

					//CALCULATE THE DAMAGE ON THE CHOSEN ENEMY
					damageCalculationEnemy(init.get(index), enemies.get(playerAttack-1), null);
					
					//REMOVE DEFEATED ALLIES
					if(enemies.get(playerAttack-1).getHealth() <= 0) { //defeated enemy
						enemies.remove(playerAttack-1);
					}
				}
			}
			else { //enemy
				//TODO: implement AI later
				int rand = (int)(Math.random()*party.size());
				//System.out.println(init.get(index).getName() + " attacks " + init.get(rand).getName() + " dealing " + init.get(index).getAttack() + " damage!");
				
				//calculate damage
				damageCalculationAlly(enemies.get(index), party.get(rand), null);
				
				if(party.get(rand).getHealth() <= 0) { //defeated ally
					party.remove(rand);
				}
			}
			
			//UPDATE THE INDEX IN INITIATIVE
			if(index == 0) {
				index = init.size()-1;
			}
			else {
				index--; 
			}
			
			player = init.get(index); //next player
			numEnemies = (short)enemies.size();
			numAllies = (short)party.size();
			
			init = initiative(party, enemies);
			
			for(int i=0; i<init.size(); i++) {
				if(init.get(i) == player) {
					index = i;
					break;
				}
			}
		}
		
		//COMBAT OVER
		if(numAllies == 0) {
			System.out.println("Game Over. Come back when you are stronger");
			return;
		}
		
		if(numEnemies == 0) {
			System.out.println("Encounter over! You gained 12 exp!"); //TODO: subject to change
			return;
		}
	}
	
	/*
	 * Print the menu that the user will interact with and then return the user choice
	 */
	public short printMenu(CombatNPC npc) {
		System.out.println("What will " + npc.getName() + " do?\n1) Attack\n2) Spells\n3) Inventory");
		short input = (short)sc.nextInt();
		
		while(input <= 0 && input > 3) {
			System.out.println("Please choose a valid option.");
			System.out.println("What will " + npc.getName() + " do?\n1) Attack\n2) Spells\n3) Inventory");
			input = (short)sc.nextInt();
		}
		
		return input; //print out stats on the right + picture
	}
	
	/*
	 * Calculates the initiative order for both sides. Return an array that has the order for combat. 
	 */
	public ArrayList<CombatNPC> initiative(ArrayList<CombatNPC> p, ArrayList<CombatNPC> e) {
		ArrayList<CombatNPC> init = new ArrayList<CombatNPC>();
		
		for(int i=0; i<p.size(); i++) {
			init.add(p.get(i));
		}
		
		for(int i=0; i<e.size(); i++) {
			init.add(e.get(i));
		}
		
		init = sort(init); //sorted

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
			System.out.println(enemy.getName() + " attacks " + ally.getName());
			System.out.println(enemy.getName() + " deals " + Integer.toString(enemy.getAttack()) + " damage!\n");
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
			System.out.println(ally.getName() + " attacks " + enemy.getName());
			System.out.println(ally.getName() + " deals " + Integer.toString(ally.getAttack()) + " damage!\n");
			enemy.setHealth(enemy.getHealth() - ally.getAttack());
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
