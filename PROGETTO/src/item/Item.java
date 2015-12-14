package item;

import attackable.Worker;

public abstract class Item implements Useable<Worker> {
	public Worker owner;
	private String name;
	public Worker getOwner(){
		return owner;
	}
	public void setOwner(Worker w){
		owner=w;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
   
}
