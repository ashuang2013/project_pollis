package generation.combat;

public class Excalibur implements Weapon {

	@Override
	public int getAttack() {
		return 1000;
	}

	@Override
	public int getCritRate() {
		return 100;
	}

	@Override
	public int getCritDamage() {
		return 500;
	}

	@Override
	public int getRange() {
		return 20;
	}

	@Override
	public WeaponType getWeaponType() {
		return WeaponType.Sword;
	}

	@Override
	public Handed getHandedness() {
		return Handed.One;
	}

	@Override
	public String getDescription() {
		return "The legendary sword wielded by King Arthur to conquer Europe.";
	}

}
