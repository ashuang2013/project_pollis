
public class BareHand implements Weapon {
	//WEAPON BASE STATS
	private final int ATTACK = 2;
	private final int CRATE = 0;
	private final int CDAMAGE = 0;
	private final int RANGE = 50;
	
	public BareHand() {
		
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
	public Weapon.WeaponType getWeaponType() {
		// TODO Auto-generated method stub
		return WeaponType.Exotic;
	}

}
