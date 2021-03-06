package item;

import java.io.Serializable;

import positionable.Box;

/**
 * Class that produces defense Weapons for the Fighter
 * @author Mattia Rosselli
 *
 */
public class DefenseWeapon extends Weapon implements Cloneable, Serializable {
	private double defense;

	/**
	 * Create a new defenseWeapon with given name and defense value
	 * @param name Name of the weapon
	 * @param defense defense value
	 */
	public DefenseWeapon(String name, double defense) {
		super.setName(name);
		this.defense = defense;
		super.setOwner(null);
	}

	@Override
	public DefenseWeapon clone() {
		try {

			DefenseWeapon cloned = (DefenseWeapon) super.clone();
			if (super.getOwner() != null)
				cloned.setOwner(super.getOwner().clone());
			return cloned;

		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		if (otherObject.getClass()!=getClass())
			return false;
		DefenseWeapon other = (DefenseWeapon) otherObject;
		return defense == other.defense && super.getName().equals(other.getName())
				&& ((super.getOwner() == null && other.getOwner() == null)
						|| super.getOwner().equals(other.getOwner()));
	}

	/**
	 * Get the defense value of the weapon
	 * @return defense value
	 */
	public double getDefense() {
		return defense;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + super.getName() + "," + "owner=" + super.getOwner() + "," + "defense="
				+ this.defense + "]";
	}

}