package generation.combat;

import java.util.HashSet;

import javax.swing.ImageIcon;

public interface CombatStats {
	public int getRow();
	public void setRow(int r);
	
	public int getCol();
	public void setCol(int c);
	
	public ImageIcon getImageIcon();
	
	public int getHealth();
	public void setHealth(int hp);
	
	public int getAttack();
	public void setAttack(int atk);
	
	public int getPhysicalDefense();
	public void setPhysicalDefense(int pd);
	
	public int getMagicDefense();
	public void setMagicDefense(int md);
	
	public int getSpeed();
	public void setSpeed(int spd);
	
	public int getMana();
	public void setMana(int m);
	
	public HashSet<Skill> getSkills();
	public void setSkills(HashSet<Skill> sk);
	
	public String getDescription();
}
