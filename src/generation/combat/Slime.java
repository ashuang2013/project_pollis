package generation.combat;

import java.util.HashSet;

import javax.swing.ImageIcon;

import generation.NPC;

public class Slime extends CombatNPC implements CombatStats {

	public Slime(int r, int c, String n, ImageIcon i, Side s) {
		super(r, c, n, i, s);
		super.setHealth(10);
		super.setAttack(1);
		super.setPhysicalDefense(10);
		super.setMagicDefense(10);
		super.setSpeed(10); //action points (more turns), initiative, crit damage/crit rate
		super.setMana(0);
		super.setRange(5);
		super.setSkills(null);
	}
	
	public Slime(int r, int c, String n, ImageIcon i, Side sid, int s) {
		super(r, c, n, i, sid);
		super.setHealth(10);
		super.setAttack(1);
		super.setPhysicalDefense(10);
		super.setMagicDefense(10);
		super.setSpeed(s); //action points (more turns), initiative, crit damage/crit rate
		super.setMana(0);
		super.setRange(5);
		super.setSkills(null);
	}
	
	public String getName() {
		return super.getName();
	}
	
	public ImageIcon getImageIcon() {
		return super.getImageIcon();
	}
	
	@Override
	public int getHealth() {
		return super.getHealth();
	}

	@Override
	public void setHealth(int h) {
		super.setHealth(h);
	}

	@Override
	public int getAttack() {
		return super.getAttack();
	}

	@Override
	public void setAttack(int a) {
		super.setAttack(a);
	}

	@Override
	public int getPhysicalDefense() {
		return super.getPhysicalDefense();
	}

	@Override
	public void setPhysicalDefense(int pd) {
		super.setPhysicalDefense(pd);
	}

	@Override
	public int getMagicDefense() {
		return super.getMagicDefense();
	}

	@Override
	public void setMagicDefense(int md) {
		super.setMagicDefense(md);
	}

	@Override
	public int getSpeed() {
		return super.getSpeed();
	}

	@Override
	public void setSpeed(int s) {
		super.setSpeed(s);
	}

	@Override
	public int getMana() {
		return super.getMana();
	}

	@Override
	public void setMana(int m) {
		super.setMana(m);
	}

	@Override
	public HashSet<Skill> getSkills() {
		return null;
	}

	@Override
	public void setSkills(HashSet<Skill> sk) {
		super.setSkills(sk);
	}
	
	@Override
	public int getRange() {
		return super.getRange();
	}

	@Override
	public void setRange(int ran) {
		super.setRange(ran);
	}
	
	@Override
	public String getDescription() {
		return "The most basic monster there is. Known for its jigglyness.";
	}

}
