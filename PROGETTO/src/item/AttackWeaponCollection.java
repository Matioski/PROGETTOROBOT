package item;

import java.util.ArrayList;

/**
 * Class to collect all the availables AttackWeapons
 * @author Mattia Rosselli
 *
 */
public final class AttackWeaponCollection {
	final ArrayList<AttackWeapon> weapons;

	/**
	 * creates the collection
	 */
	public AttackWeaponCollection() {
		weapons = new ArrayList<AttackWeapon>();
		weapons.add(new AttackWeapon("fist", 5));
		weapons.add(new AttackWeapon("iron_dagger", 7));
		weapons.add(new AttackWeapon("gold_dagger", 9));
		weapons.add(new AttackWeapon("platinum_dagger", 11));
		weapons.add(new AttackWeapon("warrior_sword", 13));
		weapons.add(new AttackWeapon("circular_saw", 20));

	}

	/**
	 * Returns the size of the collection
	 * @return the size of the collection
	 */
	public int getSize() {
		return weapons.size();
	}
	
	/**
	 * Returns the AttackWeapons at the index
	 * @param index index of the weapon to get
	 * @return the AttackWeapon at the index
	 */
	public AttackWeapon getWeapon(int index) {
		return weapons.get(index);
	}
}
