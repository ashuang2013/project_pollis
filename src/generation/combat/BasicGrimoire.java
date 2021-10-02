package generation.combat;

import generation.combat.Weapon.WeaponType;

/*
 * Author: Alex Huang
 */
public class BasicGrimoire implements Weapon {
	//WEAPON BASE STATS
	private final int ATTACK = 5;
	private final int CRATE = 5;
	private final int CDAMAGE = 120; //multiplies by this number div 100. so for this weapon it does an extra 20% damage when it crits
	private final int RANGE = 15;
	
	public BasicGrimoire() {
		
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
		return WeaponType.Grimoire;
	}

	@Override
	public String getDescription() {
		return "A solid grimoire used by beginner magicians on adventures";
	}

	@Override
	public Handed getHandedness() {
		return Handed.Two;
	}

}
