package attackable;

import java.io.Serializable;

import item.AttackWeapon;
import item.AttackWeaponCollection;
import item.DefenseWeapon;
import item.DefenseWeaponCollection;
import item.Weapon;
import positionable.Box;

/**
 * Public class of Robots that can attack and use Weapons
 * 
 * @author Mattia Rosselli
 *
 */
public class Fighter extends Robot<Weapon> implements Cloneable, Serializable {
	private AttackWeapon attackWeapon;
	private DefenseWeapon defenseWeapon;

	/**
	 * Constructor that creates a fighter with the default parameters and a passed name
	 * 
	 * @param name
	 *            name to give to the fighter
	 */
	public Fighter(String name) {
		super(name);
		attackWeapon = new AttackWeaponCollection().getWeapon(0);
		defenseWeapon = new DefenseWeaponCollection().getWeapon(0);
	}

	@Override
	public Fighter clone() {
		try {
			Fighter cloned = (Fighter) super.clone();
			if (super.getPosition() != null)
				cloned.setPosition(this.getPosition());
			if (super.getTeam() != null)
				cloned.setTeam(getTeam());
			if (attackWeapon != null)
				cloned.attackWeapon = attackWeapon.clone();
			if (defenseWeapon != null)
				cloned.defenseWeapon = defenseWeapon.clone();

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
		Fighter other = (Fighter) otherObject;
		return getName().equals(other.getName()) &&

		((getPosition() == null && other.getPosition() == null) || getPosition().equals(other.getPosition()))
				&& getHealth() == other.getHealth() && getStrength() == other.getStrength()
				&& getEnergy() == other.getEnergy()
				&& ((getTeam() == null && other.getTeam() == null) || getTeam().equals(other.getTeam()))
				&& ((attackWeapon == null && other.attackWeapon == null) || attackWeapon.equals(other.attackWeapon))
				&& ((defenseWeapon == null && other.defenseWeapon == null)
						|| defenseWeapon.equals(other.defenseWeapon));
	}

	/**
	 * Method that returns the attack of the equipped weapon
	 * 
	 * @return the value of the attack of the equipped Weapon
	 */
	public double getAttack() {
		return attackWeapon.getAttack();
	}

	@Override
	public double getDefense() {
		return defenseWeapon.getDefense();
	}

	@Override
	public void pick(Weapon item) {
		if (item.getClass().getName().contains("DefenseWeapon")) {
			defenseWeapon = (DefenseWeapon) item;
			defenseWeapon.setOwner(this);
			super.setDefense(defenseWeapon.getDefense());
		} else if (item.getClass().getName().contains("AttackWeapon")) {
			attackWeapon = (AttackWeapon) item;
			attackWeapon.setOwner(this);
		}
	}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + this.getName() + "," + "team=" + this.getTeam() + "," + "position="
				+ this.getPosition() + "," + "health=" + this.getHealth() + ",stength=" + this.getStrength()
				+ ",energy=" + this.getEnergy() + ",attackWeapon=" + this.attackWeapon + ",defenseWeapon="
				+ this.defenseWeapon + "]";
	}

}
