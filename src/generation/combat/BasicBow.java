package generation.combat;

import generation.combat.Weapon.WeaponType;

/*
 * Author: Alex Huang
 */
public class BasicBow implements Weapon {
	//WEAPON BASE STATS
	private final int ATTACK = 5;
	private final int CRATE = 15;
	private final int CDAMAGE = 150;
	private final int RANGE = 30;
	
	public BasicBow() {
		
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
		return WeaponType.Bow;
	}

	@Override
	public String getDescription() {
		return "A solid bow to accompany you on your adventures";
	}

	@Override
	public Handed getHandedness() {
		return Handed.Two;
	}

}
