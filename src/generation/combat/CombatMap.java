package generation.combat;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
		//TODO: implement
		Scanner sc = new Scanner(System.in);
		//for now we will do a randomized order, techincally should be based on inititative
		System.out.println("What will the berserker do?/n1) Attack/n2) Use Spells/n3) View Inventory");
		int input = sc.nextInt();

		System.out.println("The berserker has " + party[0].getHealth());
		System.out.println("The slime has " + enemies[0].getHealth());

		while(party[0].getHealth() != 0 && enemies[0].getHealth() != 0) {
			if(input == 1) {
				System.out.println("Berserker attacks!");
				System.out.println("Berserker deals " + Integer.toString(party[0].getAttack()) + " damage!");
				enemies[0].setHealth(enemies[0].getHealth() - party[0].getAttack());
			}

			System.out.println("Slime attacks!");
			System.out.println("Slime deals " + Integer.toString(enemies[0].getAttack()) + " damage!");
			party[0].setHealth(party[0].getHealth() - party[0].getAttack());
		}

		if(enemies[0].getHealth() == 0) {
			System.out.println("encounter over! you win!");
		}
		else {
			System.out.println("Game Over. Come back when you are stronger");
		}

		return;
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
		System.out.println("we have finished printing the background!");

		for(CombatNPC p : party)
		{
			g.drawImage(p.getImageIcon().getImage(), p.getCol()*SIZE, p.getRow()*SIZE , SIZE, SIZE, null);  //drawing a test NPC
			System.out.println("we have finished printing the party!");
		}


		for(CombatNPC e : enemies)
		{
			g.drawImage(e.getImageIcon().getImage(), e.getCol()*SIZE, e.getRow()*SIZE , SIZE, SIZE, null);  //drawing a test NPC
			System.out.println("we have finished printing the enemies!");
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
