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
	
	private ImageIcon image;
	private HashSet<Skill> skills;
	
	public CombatNPC(int r, int c, ImageIcon i) {
		row = r;
		col = c;
		image = i;
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
		// TODO Auto-generated method stub
		return hp;
	}

	@Override
	public void setHealth(int h) {
		// TODO Auto-generated method stub
		this.hp = h;
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return atk;
	}

	@Override
	public void setAttack(int a) {
		// TODO Auto-generated method stub
		atk = a;
	}

	@Override
	public int getPhysicalDefense() {
		// TODO Auto-generated method stub
		return pdef;
	}

	@Override
	public void setPhysicalDefense(int pd) {
		// TODO Auto-generated method stub
		pdef = pd;
	}

	@Override
	public int getMagicDefense() {
		// TODO Auto-generated method stub
		return mdef;
	}

	@Override
	public void setMagicDefense(int md) {
		// TODO Auto-generated method stub
		mdef = md;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return spd;
	}

	@Override
	public void setSpeed(int s) {
		// TODO Auto-generated method stub
		spd = s;
	}

	@Override
	public int getMana() {
		// TODO Auto-generated method stub
		return mana;
	}

	@Override
	public void setMana(int m) {
		// TODO Auto-generated method stub
		mana = m;
	}

	@Override
	public HashSet<Skill> getSkills() {
		// TODO Auto-generated method stub
		return skills;
	}

	@Override
	public void setSkills(HashSet<Skill> sk) {
		// TODO Auto-generated method stub
		skills = sk;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
