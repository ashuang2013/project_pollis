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
	
	public Berserker(int r, int c, String n, ImageIcon i, Side s)
	{   
		super(r, c, n, i, s);
		weapon = new BareHand();
		super.setHealth(50);
		super.setAttack(10 + weapon.getAttack());
		super.setPhysicalDefense(20);
		super.setMagicDefense(20);
		super.setSpeed(100); //TODO: action points (more turns), initiative, crit damage/crit rate
		super.setMana(100);
		super.setRange(weapon.getRange());
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
		int random = (int)(Math.random()*100);
		
		if(random < weapon.getCritRate())
			return super.getAttack()*weapon.getCritDamage()/100;
		else 
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
		return "A fierce warrior raised in the cold grasslands to the North.";
	}
	
	public Weapon getWeapon() {
		return super.getWeapon();
	}
	
	public void setWeapon(Weapon w) {
		if(w.getWeaponType() == WeaponType.Sword) {
			weapon = w;
			super.setWeapon(w);
			super.setAttack(10 + weapon.getAttack());
			System.out.println("The total attack of berserker is : " + super.getAttack());
			super.setRange(weapon.getRange());
		}
		else {
			System.out.println("Unable to equip weapon, the Berserker can only use a sword.");
		}
	}
	
	public void deequipWeapon() {
		weapon = new BareHand();
	}
}
