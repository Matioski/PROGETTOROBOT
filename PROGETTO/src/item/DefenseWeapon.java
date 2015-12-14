package item;

public class DefenseWeapon extends Weapon {
	private double defense;
	

	public DefenseWeapon(String name,double defense){
		super.setName(name);
		this.defense=defense;
		super.setOwner(null);
	}
	public double getDefense(){
		return defense;
	}
}