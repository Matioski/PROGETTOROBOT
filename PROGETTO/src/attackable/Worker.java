package attackable;

import java.io.Serializable;

import item.DefenseItem;
import item.DefenseItemCollection;
import item.Item;
import item.RepairingItem;
import item.RepairingItemCollection;
import positionable.Box;

/**
 * 
 * Public Robot class that can repair and handle Item.
 *
 * @author Mattia Rosselli
 *
 */
public class Worker extends Robot<Item> implements Cloneable, Serializable {
	private DefenseItem defenseItem;
	private RepairingItem repairingItem;

	/**
	 * Worker of Builder creates a robot with default parameters and a Name
	 * assigned through the explicit parameter.
	 *
	 * @param Name
	 *            Name to be assigned to the Worker.
	 */
	public Worker(String name) {
		super(name);
		defenseItem = new DefenseItemCollection().getItem(0);
		repairingItem = new RepairingItemCollection().getItem(0);
		;
		super.setDefense(0);
	}

	@Override
	public Worker clone() {
		try {
			Worker cloned = (Worker) super.clone();

			if (defenseItem != null)
				cloned.defenseItem = defenseItem.clone();
			if (repairingItem != null)
				cloned.repairingItem = repairingItem.clone();
			if (super.getPosition() != null)
				cloned.setPosition(this.getPosition());
			if (super.getTeam() != null)
				cloned.setTeam(getTeam());

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
		Worker other = (Worker) otherObject;
		return getName().equals(other.getName()) &&

		((getPosition() == null && other.getPosition() == null) || getPosition().equals(other.getPosition()))
				&& getHealth() == other.getHealth() && getStrength() == other.getStrength()
				&& getEnergy() == other.getEnergy()
				&& ((getTeam() == null && other.getTeam() == null) || getTeam().equals(other.getTeam()))
				&& ((defenseItem == null && other.defenseItem == null) || defenseItem.equals(other.defenseItem))
				&& ((repairingItem == null && other.repairingItem == null)
						|| repairingItem.equals(other.repairingItem));
	}

	/**
	 * Returns the value of the repair Repairing Item equipped.
	 * 
	 * @return Repair value
	 */
	public double getReapairingRate() {
		return repairingItem.getRepairingRate();
	}

	@Override
	public void pick(Item item) {
		if (item.getClass().getName().contains("DefenseItem")) {
			defenseItem = (DefenseItem) item;
			defenseItem.setOwner(this);
			super.setDefense(defenseItem.getDefense());
		} else if (item.getClass().getName().contains("RepairingItem"))
			repairingItem = (RepairingItem) item;
			repairingItem.setOwner(this);
	}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + this.getName() + "," + "team=" + this.getTeam() + "," + "position="
				+ this.getPosition() + "," + "health=" + this.getHealth() + ",stength=" + this.getStrength()
				+ ",energy=" + this.getEnergy() + ",defenseItem=" + this.defenseItem + ",repairingItem="
				+ this.repairingItem + "]";
	}

}