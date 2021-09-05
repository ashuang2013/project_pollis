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
	private final int RANGE = 200;
	
	public BasicGrimoire() {
		
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
		return WeaponType.Grimoire;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A solid grimoire used by beginner magicians on adventures";
	}

	@Override
	public Handed getHandedness() {
		// TODO Auto-generated method stub
		return Handed.Two;
	}

}
