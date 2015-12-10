package item;

import attackable.Robot;

public class ChargingItem extends Item {
	private double healingrate;
	private String name;
	
	public ChargingItem(String n,double h){
		name=n;
		healingrate=h;
		super.setOwner(null);
	}
	public double gethealingrate(){
		return healingrate;
	}
	
}
