package robot;

public class AttackWeapon extends Weapon {
	private double attack;
	private int criticalrate,range;
	private String name;
	public AttackWeapon(String name,double attack){
		this.name=name;
		this.attack=attack;
	}
	public double getAttack(){
		return attack;
	}
	public int getRange(){
		return range;
	}
}
