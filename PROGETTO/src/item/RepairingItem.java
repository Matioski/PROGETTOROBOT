package item;

public class RepairingItem extends Item {
	private double repairingrate;
	private String name;
	public RepairingItem(String n,double h){
		name=n;
		repairingrate=h;
		super.setOwner(null);
	}
	public double getrepairingrate(){
		return repairingrate;
	}
}
