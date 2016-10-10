package item;

import attackable.Robot;

/**
 * Elements that can be equipped by Robots
 * @author Mattia Rosselli
 *
 * @param <T> Type of Robot
 */
public interface Useable<T extends Robot> {
	/**
	 * returns the owner
	 * @return the owner
	 */
	public T getOwner();

	/**
	 * Set the Owner
	 * @param r owner to set
	 */
	public void setOwner(T r);

}
