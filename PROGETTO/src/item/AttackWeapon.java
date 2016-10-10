package item;

import java.io.Serializable;

import positionable.Box;

/**
 * Class of attackWeapon that can be used by Fighter
 * @author Mattia Rosselli
 */
public class AttackWeapon extends Weapon implements Cloneable, Serializable {
	private double attack;

	/**
	 * Constructs a new Weapon with the given name and attack
	 * @param name Name of the weapon
	 * @param attack Weapon's attack value
	 */
	public AttackWeapon(String name, double attack) {
		super.setName(name);
		this.attack = attack;
		super.setOwner(null);
	}

	@Override
	public AttackWeapon clone() {
		try {

			AttackWeapon cloned = (AttackWeapon) super.clone();
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
		AttackWeapon other = (AttackWeapon) otherObject;
		return attack == other.attack &&

		super.getName().equals(other.getName()) && ((super.getOwner() == null && other.getOwner() == null)
				|| super.getOwner().equals(other.getOwner()));
	}

	/**
	 * Use this to get the attack of the weapon
	 * @return the attack of the weapon
	 */
	public double getAttack() {
		return attack;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + super.getName() + "," + "owner=" + super.getOwner() + "," + "attack="
				+ this.attack + "]";
	}

}
