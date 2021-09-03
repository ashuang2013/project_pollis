package generation;
/*
 * Author: Alex Huang
 */
public interface Weapon {
	public enum WeaponType {
		Sword, Claymore, Polearm, Bow, Grimoire, Exotic
	}
	
	public int getDamage();

	public int getCritRate();
	public int getCritDamage();	
	public int getRange();
	
	public WeaponType getWeaponType();
}
