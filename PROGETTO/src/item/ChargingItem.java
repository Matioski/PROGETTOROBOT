package item;

import attackable.Robot;

public class ChargingItem extends Item {
	private double healingrate;
	
	
	public ChargingItem(String name,double h){
		super.setName(name);
		healingrate=h;
		super.setOwner(null);
	}
	public double gethealingrate(){
		return healingrate;
	}
	
}
