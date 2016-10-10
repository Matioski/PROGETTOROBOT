package positionable;

import java.io.Serializable;

import board.Position;

/**
 * Class that represents an empty tile
 * @author Mattia Rosselli
 *
 */
public class Box extends Positionable implements Cloneable, Serializable {

	/**
	 * Creates a new empty tile
	 * @param pos position of the tile
	 */
	public Box(Position pos) {
		// TODO Auto-generated constructor stub
		super.setPosition(pos);
	}

	@Override
	public Box clone() {
		try {

			Box cloned = (Box) super.clone();
			cloned.setPosition(this.getPosition().clone());
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
		Box other = (Box) otherObject;
		return getPosition().equals(other.getPosition());
	}

	@Override
	public String toString() {
		return getClass().getName() + "[position=" + getPosition() + "]";
	}

}
