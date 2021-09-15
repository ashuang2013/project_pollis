package generation.combat;
/*
 * Author: Alex Huang
 */
public interface Weapon {
	public enum WeaponType {
		Sword, Broadsword, Polearm, Bow, Grimoire, Exotic
	}
	
	public enum Handed {
		One, Two, Base, Equip
	}
	
	public int getDamage();

	public int getCritRate();
	public int getCritDamage();	
	public int getRange();
	
	public WeaponType getWeaponType();
	public Handed getHandedness();
	
	public String getDescription();
	
}
