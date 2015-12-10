package item;

public class DefenseWeapon extends Weapon {
	private double defense;
	private String name;

	public DefenseWeapon(String name,double defense){
		this.name=name;
		this.defense=defense;
		super.setOwner(null);
	}
	public double getDefense(){
		return defense;
	}
}