package generation.combat;

import generation.combat.Weapon.WeaponType;

/*
 * Author: Alex Huang
 */
public class Shuriken implements Weapon {
	//WEAPON BASE STATS
	private final int ATTACK = 5;
	private final int CRATE = 0;
	private final int CDAMAGE = 0;
	private final int RANGE = 10;
	
	public Shuriken() {
	
	}
	
	@Override
	public int getAttack() {
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
	public WeaponType getWeaponType() {
		return WeaponType.Exotic;
	}

	@Override
	public String getDescription() {
		return "A concealed weapon used by rogues to assassinate their opponents";
	}

	@Override
	public Handed getHandedness() {
		return Handed.Equip;
	}
}
