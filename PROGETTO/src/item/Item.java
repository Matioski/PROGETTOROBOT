package item;

import attackable.Worker;

public abstract class Item implements Useable<Worker> {
	public Worker owner;
	public Worker getOwner(){
		return owner;
	}
	public void setOwner(Worker w){
		owner=w;
	}
   
}
