package item;

import java.io.Serializable;

import attackable.Fighter;

/**
 * Abstract class of the weapons that can be equipped by a Fighter
 * @author Mattia Rosselli
 *
 */
public abstract class Weapon implements Useable<Fighter>, Serializable {
	private Fighter owner;
	private String name;

	/**
	 * Method that returns the name of the weapon
	 * @return name of the weapon
	 */
	public String getName() {
		return name;
	}

	@Override
	public Fighter getOwner() {
		return owner;
	}

	/**
	 * Sets the name to a weapon
	 * @param name name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setOwner(Fighter f) {
		owner = f;

	}
}
