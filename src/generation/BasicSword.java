package generation;
/*
 * Author: Alex Huang
 */
public class BasicSword implements Weapon {
	//WEAPON BASE STATS
	private final int ATTACK = 5;
	private final int CRATE = 0;
	private final int CDAMAGE = 0;
	private final int RANGE = 50;
	
	public BasicSword() {
		
	}
	
	@Override
	public int getDamage() {
		// TODO implement augments
		return ATTACK;
	}

	@Override
	public int getCritRate() {
		return CRATE;
	}

	@Override
	public int getCritDamage() {
		return CDAMAGE;
	}

	@Override
	public int getRange() {
		return RANGE;
	}

	@Override
	public Weapon.WeaponType getWeaponType() {
		return WeaponType.Sword;
	}
}
