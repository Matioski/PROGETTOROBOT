package item;

import java.io.Serializable;

import positionable.Box;

/**
 * Class fot defense items that can be used from workers
 * @author Mattia Rosselli
 *
 */
public class DefenseItem extends Item implements Cloneable, Serializable {
	private double defense;

	/**
	 * Creates a DefenseItem with a specified name and defense
	 * @param name Name of the item
	 * @param h defense value
	 */
	public DefenseItem(String name, double h) {
		super.setName(name);
		defense = h;
		super.setOwner(null);
	}

	@Override
	public DefenseItem clone() {
		try {

			DefenseItem cloned = (DefenseItem) super.clone();
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
		if (otherObject.getClass()!=getClass() )
			return false;
		DefenseItem other = (DefenseItem) otherObject;
		return defense == other.defense && super.getName().equals(other.getName())
				&& ((super.getOwner() == null && other.getOwner() == null)
						|| super.getOwner().equals(other.getOwner()));
	}

	/**
	 * Get the defense value of the item
	 * @return the defense value
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
