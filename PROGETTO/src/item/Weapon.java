package item;

import attackable.Fighter;

public abstract class Weapon implements Useable<Fighter> {
	private Fighter owner;
	public Fighter getOwner(){
		return owner;
	}
	public void setOwner (Fighter f){
		f.pick(this);
		owner=f;
	}
}
