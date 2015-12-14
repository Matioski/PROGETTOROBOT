package item;

import attackable.Fighter;

public abstract class Weapon implements Useable<Fighter> {
	private Fighter owner;
	private String name;
	public Fighter getOwner(){
		return owner;
	}
	public void setOwner (Fighter f){
		f.pick(this);
		owner=f;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
}
