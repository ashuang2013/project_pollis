package generation.combat;

public interface Skill {
	public int getRange();
	public void setRange(int r);
	
	public int getDamage();
	public void setDamage(int d);
	
	public int getManaCost();
	public void setManaCost(int mc);
	
	public int getCooldown();
	public void setCooldown(int cd);
	
	public String[] getResistance();
	public void setResistance(String[] res);
	
	public String[] getCritical();
	public void setCritical(String[] crt);
}
