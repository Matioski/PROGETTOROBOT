package item;

import java.io.Serializable;

import attackable.Worker;

/**
 * Abstract class that represents the item that can be equippeb by the Workers
 * @author Mattia Rosselli
 *
 */
public abstract class Item implements Useable<Worker>, Serializable {
	public Worker owner;
	private String name;

	/**
	 * Returns the name of the Item
	 * @return the name of the item
	 */
	public String getName() {
		return name;
	}

	@Override
	public Worker getOwner() {
		return owner;
	}
	
	/**
	 * Assigns the name to the Item
	 * @param name The name to assign
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setOwner(Worker w) {
		owner = w;
	}

}
