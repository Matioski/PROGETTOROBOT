package item;

import java.io.Serializable;

import positionable.Box;

/**
 * Class that represents the Item used by the Worker to repair other robots
 * @author Mattia Rosselli
 *
 */
public class RepairingItem extends Item implements Cloneable, Serializable {
	private double repairingrate;

	/**
	 * Create a new Repairing  item
	 * @param name Name of the item
	 * @param h Repairing Rate
	 */
	public RepairingItem(String name, double h) {
		super.setName(name);
		repairingrate = h;
		super.setOwner(null);
	}

	@Override
	public RepairingItem clone() {
		try {

			RepairingItem cloned = (RepairingItem) super.clone();
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
		RepairingItem other = (RepairingItem) otherObject;
		return repairingrate == other.repairingrate && super.getName().equals(other.getName())
				&& ((super.getOwner() == null && other.getOwner() == null)
						|| super.getOwner().equals(other.getOwner()));
	}
	
	/**
	 * Returns the repairingRate
	 * @return the repairing rate
	 */
	public double getRepairingRate() {
		return repairingrate;
	}
	
	/**
	 * Seta a new RepairingRate
	 * @param rep RepairingRate
	 */
	public void setRepairingRate(double rep) {
		repairingrate = rep;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + super.getName() + "," + "owner=" + super.getOwner() + ","
				+ "repairingrate=" + this.repairingrate + "]";
	}
}
