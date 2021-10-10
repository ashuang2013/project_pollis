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
import generation.combat.CombatStats.Side;

/*
 * Author: Alex Huang
 */
public class CombatMap  extends JPanel {
	private ArrayList<CombatNPC> party;
	private ArrayList<CombatNPC> enemies;
	private int[][] location;
	private int SIZE = CombatStats.SIZE*10;

	private Scanner sc = new Scanner(System.in);
	private naturalTerrainDictionary dict = new naturalTerrainDictionary();
	/*
	 * This class will house the graphics and store the necessary elements on which combat will be fought. Some examples
	 * include the protagonist's party vs the enemies fought. Some other examples include the overall how the map will be 
	 * structured (map layout along with texture). The CombatMap will also take responsibility for executing and determining
	 * the order for combat that will occur.
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
		int index = 0;
		CombatNPC player = init.get(index); //TODO: this is never used should use it


		while(numEnemies != 0 && numAllies != 0) {
			if(init.get(index).getSide() == CombatStats.Side.Ally) { //party member
				short playerChoice = printMenu(init.get(index));

				if(playerChoice <= 0 && playerChoice > 4) {
					System.out.println("Please choose a valid command...");
					playerChoice = printMenu(init.get(index));
				}
				
				if(playerChoice == 1) { //party member moves
					System.out.println("Please input the space that you would like to move.");
					int x = sc.nextInt(), y = sc.nextInt();
					int[] bounds = movementRangeHelper(player);
					
					if(y >= bounds[0] && y <= bounds[1] &&
							x >= bounds[2] && x <= bounds[3]) {
						player.setRow(x);
						player.setCol(y);
						System.out.println("Accepted: the current position of npc is: " + player.getRow() + " " + player.getCol());
					}
					else {
						System.out.println("The selected position is not valid to move to. Please choose a valid position to move to.");
						continue;
					}
				}
				
				if(playerChoice == 2) { //party member attacks
					short playerAttack;
					System.out.println("Who does " + init.get(index).getName() + " want to attack?");
					ArrayList<CombatNPC> attackable = attackRange(init.get(index), Side.Ally);
					
					if(attackable.size() == 0) {
						System.out.println("You are not in range to attack anyone!");
						continue;
					}
					else {
						for(int i=0; i<attackable.size(); i++) {	
							//print out a list of possible enemies to attack in format: i+1) enemy
							System.out.println(Integer.toString(i+1) + ") " + attackable.get(i).getName());
						}
					}

					//USER INPUT FOR ATTACKING
					playerAttack = (short)sc.nextInt();
					while(playerAttack < 0 && playerAttack >= enemies.size()) {
						System.out.println("Please choose a valid enemy...");
						playerAttack = (short)sc.nextInt();
					}
					
					for(int i=0; i<enemies.size(); i++) {
						//TODO: implement aoe later
						if(attackable.get(playerAttack-1).getName().equals(enemies.get(i).getName())) { //names will never be shared
							//CALCULATE THE DAMAGE ON THE CHOSEN ENEMY
							damageCalculationEnemy(init.get(index), enemies.get(i), null);

							//REMOVE DEFEATED ENEMIES
							if(enemies.get(i).getHealth() <= 0) {
								enemies.remove(i);
							}
						}
					}
				}
				
				if(playerChoice == 4) { //TODO: implement Weapon equipping
					Excalibur e = new Excalibur();
					player.setWeapon(e);
				}
			}
			else { //enemy
				//TODO: implement AI later
				ArrayList<CombatNPC> attackable = attackRange(init.get(index), Side.Enemy);
				
				if(attackable.size() == 0) {
					System.out.println(init.get(index).getName() + " is not in range to attack anyone!");
					if(index == init.size()-1) {
						index = 0;
					}
					else {
						index++; 
					} //TODO: only a bandaid fix, ultimately make another move or move somewhere
					continue;
				}
				
				int rand = (int)(Math.random()*party.size());
				//System.out.println(init.get(index).getName() + " attacks " + init.get(rand).getName() + " dealing " + init.get(index).getAttack() + " damage!");

				//calculate damage
				damageCalculationAlly(init.get(index), party.get(rand), null);

				if(party.get(rand).getHealth() <= 0) { //defeated ally
					party.remove(rand);
				}
			}

			//UPDATE THE INDEX IN INITIATIVE
			if(index == init.size()-1) {
				index = 0;
			}
			else {
				index++; 
			}

			player = init.get(index); //next player
			numEnemies = (short)enemies.size();
			numAllies = (short)party.size();
			
			//combine the two lists to consolidate information
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
		System.out.println("What will " + npc.getName() + " do?\n1) Move\n2) Attack\n3) Spells\n4) Inventory");
		short input = (short)sc.nextInt();

		while(input <= 0 && input > 3) {
			System.out.println("Please choose a valid option.");
			System.out.println("What will " + npc.getName() + " do?\n1) Move\n2) Attack\n3) Spells\n4) Inventory");
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

	public ArrayList<CombatNPC> sort(ArrayList<CombatNPC> arr)
	{
		int size = arr.size();
		for (int i = 1; i < size; i++) {
			CombatNPC key = arr.get(i);
			int j = i - 1;
			
			while (j >= 0 && key.getSpeed() > arr.get(j).getSpeed()) {
				// For ascending order, change key> arr[j] to key< arr[j].
				arr.set(j+1, arr.get(j));
				j--;
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
	 * Returns the enemies that can be attacked by the given NPC
	 */
	public ArrayList<CombatNPC> attackRange(CombatNPC npc, Side s) {	
		int[] bounds = attackRangeHelper(npc);
		ArrayList<CombatNPC> attackable = new ArrayList<CombatNPC>();
		
		if(s == Side.Ally) {
			for(int i=0; i<enemies.size(); i++) { //for the sake of simplicity we will assume a perfect square instead of a circle for range detection
				if(enemies.get(i).getCol() >= bounds[0] && 
						enemies.get(i).getCol() <= bounds[1] &&
						enemies.get(i).getRow() >= bounds[2] &&
						enemies.get(i).getRow() <= bounds[3]) { //if the enemy is within these bounds, then we can attack them
					attackable.add(enemies.get(i));
				}
			}
		}
		else {
			for(int i=0; i<party.size(); i++) { //for the sake of simplicity we will assume a perfect square instead of a circle for range detection
				if(party.get(i).getCol() >= bounds[0] && 
						party.get(i).getCol() <= bounds[1] &&
						party.get(i).getRow() >= bounds[2] &&
						party.get(i).getRow() <= bounds[3]) { //if the enemy is within these bounds, then we can attack them
					attackable.add(party.get(i));
				}
			}
		}

		
		return attackable;
	}

	/*
	 * Will calculate and return the bounds that the given npc can attack
	 */
	public int[] attackRangeHelper(CombatNPC npc) {
		int[] bound = new int[4]; //left, right, up, down
		int range = npc.getRange()/CombatStats.SIZE;

		//LEFT BOUND
		bound[0] = npc.getCol() - range < 0 ? 0 : npc.getCol() - range;
		//RIGHT BOUND
		bound[1] = npc.getCol() + range > location[0].length ? location[0].length-1 : npc.getCol() + range;
		//UP BOUND
		bound[2] = npc.getRow() - range < 0 ? 0 : npc.getRow() - range;
		//DOWN BOUND
		bound[3] = npc.getRow() + range > location.length ? location.length-1 : npc.getRow() + range;
		
		return bound;
	}
	
	/*
	 * Will calculate and return the bounds that the given npc can move
	 */
	public int[] movementRangeHelper(CombatNPC npc) {
		int[] bound = new int[4]; //left, right, up, down
		int spd = npc.getSpeed()/CombatStats.SIZE;

		//LEFT BOUND
		bound[0] = npc.getCol() - spd < 0 ? 0 : npc.getCol() - spd;
		//RIGHT BOUND
		bound[1] = npc.getCol() + spd > location[0].length ? location[0].length-1 : npc.getCol() + spd;
		//UP BOUND
		bound[2] = npc.getRow() - spd < 0 ? 0 : npc.getRow() - spd;
		//DOWN BOUND
		bound[3] = npc.getRow() + spd > location.length ? location.length-1 : npc.getRow() + spd;

		return bound;
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
