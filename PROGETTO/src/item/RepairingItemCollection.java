package item;

import java.util.ArrayList;

/**
 * Class that manages a collection of RepairingItems
 * @author Mattia Rosselli
 *
 */
public final class RepairingItemCollection {
	final ArrayList<RepairingItem> weapons;

	/**
	 * Creates a collection of repairing items
	 */
	public RepairingItemCollection() {
		weapons = new ArrayList<RepairingItem>();
		weapons.add(new RepairingItem("vest", 0));
		weapons.add(new RepairingItem("nails", 5));
		weapons.add(new RepairingItem("wrench", 9));
		weapons.add(new RepairingItem("gears", 7));
		weapons.add(new RepairingItem("hammer", 11));
		weapons.add(new RepairingItem("anvil", 15));

	}

	/**
	 * Returns the RepairingItem at the given index
	 * @param index index to get
	 * @return the RepairingItem at the given index
	 */
	public RepairingItem getItem(int index) {
		return weapons.get(index);
	}

	/**
	 * Returns the size of the collection
	 * @return the size of the collection
	 */
	public int getSize() {
		return weapons.size();
	}
}
