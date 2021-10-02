package generation.combat;

import java.util.HashSet;
import javax.swing.ImageIcon;

public class CombatNPC implements CombatStats {
	int row;
	int col;
	
	private int hp;
	private int atk;
	private int pdef;
	private int mdef;
	private int mana;
	private int spd;
	private int range;
	
	private Side side;
	private String name;
	private ImageIcon image;
	private HashSet<Skill> skills;
	
	public CombatNPC(int r, int c, String n, ImageIcon i, Side s) {
		row = r;
		col = c;
		image = i;
		name = n;
		side = s;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int r) {
		row = r;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int c) {
		col = c;
	}
	
	public ImageIcon getImageIcon() {
		return image;
	}
	
	@Override
	public int getHealth() {
		return hp;
	}

	@Override
	public void setHealth(int h) {
		this.hp = h;
	}

	@Override
	public int getAttack() {
		return atk;
	}

	@Override
	public void setAttack(int a) {
		atk = a;
	}

	@Override
	public int getPhysicalDefense() {
		return pdef;
	}

	@Override
	public void setPhysicalDefense(int pd) {
		pdef = pd;
	}

	@Override
	public int getMagicDefense() {
		return mdef;
	}

	@Override
	public void setMagicDefense(int md) {
		mdef = md;
	}

	@Override
	public int getSpeed() {
		return spd;
	}

	@Override
	public void setSpeed(int s) {
		spd = s;
	}

	@Override
	public int getMana() {
		return mana;
	}

	@Override
	public void setMana(int m) {
		mana = m;
	}

	@Override
	public HashSet<Skill> getSkills() {
		return skills;
	}

	@Override
	public void setSkills(HashSet<Skill> sk) {
		skills = sk;
	}

	public Side getSide() {
		return side;
	}
	
	@Override
	public String getDescription() {
		return null;
	}
	
	public String toString() {
		return name + " currently has " + hp + " health and " + atk + " attack.";
	}

	@Override
	public int getRange() {
		return range;
	}

	@Override
	public void setRange(int ran) {
		range = ran;
	}
}
