package generation.combat;

public class BareHand implements Weapon {
	//WEAPON BASE STATS
	private final int ATTACK = 2;
	private final int CRATE = 0;
	private final int CDAMAGE = 0;
	private final int RANGE = 5;
	
	public BareHand() {
		
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
	public Weapon.WeaponType getWeaponType() {
		return WeaponType.Exotic;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public Handed getHandedness() {
		return Handed.Base;
	}

}
