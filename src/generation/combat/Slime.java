package generation.combat;

import java.util.HashSet;

import javax.swing.ImageIcon;

import generation.NPC;

public class Slime extends CombatNPC implements CombatStats {

	public Slime(int r, int c, ImageIcon i) {
		super(r, c, i);
		super.setHealth(10);
		super.setAttack(1);
		super.setPhysicalDefense(10);
		super.setMagicDefense(10);
		super.setSpeed(10); //action points (more turns), initiative, crit damage/crit rate
		super.setMana(0);
		super.setSkills(null);
	}
	
	public ImageIcon getImageIcon() {
		return super.getImageIcon();
	}
	
	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return super.getHealth();
	}

	@Override
	public void setHealth(int h) {
		// TODO Auto-generated method stub
		super.setHealth(h);
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return super.getAttack();
	}

	@Override
	public void setAttack(int a) {
		// TODO Auto-generated method stub
		super.setAttack(a);
	}

	@Override
	public int getPhysicalDefense() {
		// TODO Auto-generated method stub
		return super.getPhysicalDefense();
	}

	@Override
	public void setPhysicalDefense(int pd) {
		// TODO Auto-generated method stub
		super.setPhysicalDefense(pd);
	}

	@Override
	public int getMagicDefense() {
		// TODO Auto-generated method stub
		return super.getMagicDefense();
	}

	@Override
	public void setMagicDefense(int md) {
		// TODO Auto-generated method stub
		super.setMagicDefense(md);
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return super.getSpeed();
	}

	@Override
	public void setSpeed(int s) {
		// TODO Auto-generated method stub
		super.setSpeed(s);
	}

	@Override
	public int getMana() {
		// TODO Auto-generated method stub
		return super.getMana();
	}

	@Override
	public void setMana(int m) {
		// TODO Auto-generated method stub
		super.setMana(m);
	}

	@Override
	public HashSet<Skill> getSkills() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSkills(HashSet<Skill> sk) {
		// TODO Auto-generated method stub
		super.setSkills(sk);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "The most basic monster there is. Known for its jigglyness.";
	}

}
