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
	private final int RANGE = 400;
	
	public BasicBow() {
		
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
		return WeaponType.Bow;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A solid bow to accompany you on your adventures";
	}

	@Override
	public Handed getHandedness() {
		// TODO Auto-generated method stub
		return Handed.Two;
	}

}
