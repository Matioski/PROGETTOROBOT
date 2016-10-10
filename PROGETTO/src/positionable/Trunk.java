package positionable;

import java.io.Serializable;

import board.Position;

/**
 * Class that represents a trunk that can be opened to choose an item to equip
 * @author Mattia Rosselli
 *
 */
public class Trunk extends Positionable implements Cloneable, Serializable {

	/**
	 * Creates a new trunk with a position
	 * @param pos Position
	 */
	public Trunk(Position pos) {
		super.setPosition(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Trunk clone() {
		try {

			Trunk cloned = (Trunk) super.clone();
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
		Trunk other = (Trunk) otherObject;
		return getPosition().equals(other.getPosition());
	}

	@Override
	public String toString() {
		return getClass().getName() + "[position=" + getPosition() + "]";
	}


}
