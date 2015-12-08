package robot;

public abstract class Weapon {
	private Fighter owner;
	public Fighter getFighter(){
		return owner;
	}
}
