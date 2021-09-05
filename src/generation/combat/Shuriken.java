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
	private final int RANGE = 100;
	
	public Shuriken() {
	
	}
	
	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return ATTACK;
	}

	@Override
	public int getCritRate() {
		// TODO Auto-generated method stub
		return CRATE;
	}

	@Override
	public int getCritDamage() {
		// TODO Auto-generated method stub
		return CDAMAGE;
	}

	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return RANGE;
	}

	@Override
	public WeaponType getWeaponType() {
		// TODO Auto-generated method stub
		return WeaponType.Exotic;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A concealed weapon used by rogues to assassinate their opponents";
	}

	@Override
	public Handed getHandedness() {
		// TODO Auto-generated method stub
		return Handed.Equip;
	}

}
