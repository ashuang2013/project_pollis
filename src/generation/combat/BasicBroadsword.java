package generation.combat;

import generation.combat.Weapon.WeaponType;

/*
 * Author: Alex Huang
 */
public class BasicBroadsword implements Weapon {
	//WEAPON BASE STATS
	private final int ATTACK = 10;
	private final int CRATE = 10;
	private final int CDAMAGE = 200;
	private final int RANGE = 10;
	
	public BasicBroadsword() {
		
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
		return WeaponType.Broadsword;
	}

	@Override
	public String getDescription() {
		return "A solid claymore to accompany you on your adventures";
	}

	@Override
	public Handed getHandedness() {
		return Handed.Two;
	}

}
