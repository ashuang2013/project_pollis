package generation.combat;

import java.util.HashSet;
import javax.swing.ImageIcon;

import generation.NPC;
import generation.combat.Weapon.Handed;
import generation.combat.Weapon.WeaponType;

public class Berserker extends CombatNPC implements CombatStats {
	//BASE STATS

	private Weapon weapon;
	private String name;
	
	public Berserker(int r, int c, ImageIcon i)
	{   
		super(r, c, i);
		super.setHealth(50);
		super.setAttack(10);
		super.setPhysicalDefense(20);
		super.setMagicDefense(20);
		super.setSpeed(10); //action points (more turns), initiative, crit damage/crit rate
		super.setMana(100);
		super.setSkills(null);
		weapon = new BareHand();
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
		return "A fierce warrior raised in the cold grasslands to the North.";
	}
	
	/*
	public void equipWeapon(Weapon w) {
		if(w.getWeaponType() == WeaponType.Sword) {
			weapon = w;
		}
		else if(skills.contains("Dual Wielding")) {
			weapon = w;
		}
		else {
			System.out.println("Unable to equip weapon, the Berserker can only use a sword.");
		}
	}
	*/
	
	public void deequipWeapon() {
		weapon = new BareHand();
	}
}
