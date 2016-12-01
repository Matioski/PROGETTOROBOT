package item;

import java.util.ArrayList;

/**
 * Class that manages a collection of items
 * @author Mattia Rosselli
 *
 */
public final class DefenseItemCollection {
	final ArrayList<DefenseItem> weapons;

	/**
	 * Creates a collection of DefenseItems
	 */
	public DefenseItemCollection() {
		weapons = new ArrayList<DefenseItem>();
		weapons.add(new DefenseItem("vest", 0));
		weapons.add(new DefenseItem("armor", 5));
		weapons.add(new DefenseItem("glove", 9));
		weapons.add(new DefenseItem("medieval_helmet", 7));
		weapons.add(new DefenseItem("futuristic_helmet", 11));
		weapons.add(new DefenseItem("shield", 15));

	}

	/**
	 * returns the DefenseWeapon at the index
	 * @param index index to get
	 * @return the defenseWeapon at the index
	 */
	public DefenseItem getItem(int index) {
		return weapons.get(index);
	}

	/**
	 * Returns the size of the collection
	 * @return size of collection
	 */
	public int getSize() {
		return weapons.size();
	}
}
