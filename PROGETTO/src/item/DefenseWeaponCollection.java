package item;

import java.util.ArrayList;

/**
 * Class that contains all the DefenseWeapons available
 * @author Mattia Rosselli
 *
 */
public final class DefenseWeaponCollection {
	final ArrayList<DefenseWeapon> weapons;

	/**
	 * Constructs the collection of DefenseWeapons
	 */
	public DefenseWeaponCollection() {
		weapons = new ArrayList<DefenseWeapon>();
		weapons.add(new DefenseWeapon("vest", 0));
		weapons.add(new DefenseWeapon("armor", 5));
		weapons.add(new DefenseWeapon("glove", 9));
		weapons.add(new DefenseWeapon("medieval_helmet", 7));
		weapons.add(new DefenseWeapon("futuristic_helmet", 11));
		weapons.add(new DefenseWeapon("shield", 15));

	}
	
	/**
	 * Get the size of the collection
	 * @return the size of the collection
	 */
	public int getSize() {
		return weapons.size();
	}

	/**
	 * Get the DefenseWeapon at the given index
	 * @param index Index to get
	 * @return the DefenseWeapon at the given index
	 */
	public DefenseWeapon getWeapon(int index) {
		return weapons.get(index);
	}
}
