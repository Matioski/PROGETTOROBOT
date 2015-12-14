package item;

public class RepairingItem extends Item {
	private double repairingrate;
	
	public RepairingItem(String name,double h){
		super.setName(name);
		repairingrate=h;
		super.setOwner(null);
	}
	public double getrepairingrate(){
		return repairingrate;
	}
}
