package board;

import java.io.Serializable;

import positionable.Box;

/**
* Location determined by X-axis and Ordinate.
  * @author Mattia Rosselli
 *
 */
public class Position implements Cloneable, Serializable {
	private int x;

	private int y;

	/**
	* Create a new location with specific x and y. 
	* * @param NewX Abscissa to be assigned.
	*  * @param Newy Ordered to be assigned.
	 */
	public Position(int newX, int newY) {
		setX(newX);
		setY(newY);
	}

	@Override
	public Position clone() {
		try {

			Position cloned = (Position) super.clone();
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
		Position other = (Position) otherObject;
		return x == other.x && y == other.y;
	}
	
	/**
	* Returns the position under the current.
* @return position under the current.
	 */
	public Position getDown() {
		return new Position(x, y + 1);
	}
	/**
	* Returns the position to the left of the current.
* @return position  to the left of the current.
	 */
	public Position getLeft() {
		return new Position(x - 1, y);
	}
	/**
	* Returns the position to the right of the current.
* @return position  to the right of the current.
	 */
	public Position getRight() {
		return new Position(x + 1, y);
	}
	/**
* Returns the position above the current.
* @return position  above the current.
	 */
	public Position getUp() {
		return new Position(x, y - 1);
	}

	/**
	 * Returns the abscissa
	 * @return Abscissa
	 */
	public int getX() {
		return x;
	}
	/**
	 * returns the ordinate
	 * @return ordinate
	 */
	public int getY() {
		return y;

	}

	/**
	 * sets the new Abscissa
	 * @param newX new abscissa
	 */
	public void setX(int newX) {
		x = newX;
	}
	/**
	 * sets new ordinate
	 * @param newX new ordinate
	 */
	public void setY(int newY) {
		y = newY;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[x=" + x + "," + "y=" + y + "]";
	}

}
