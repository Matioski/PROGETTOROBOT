package positionable;

import java.io.Serializable;

import board.Position;

/**
 * Element of the board that can't be moved
 * @author Mattia Rosselli
 *
 */
public class Wall extends Positionable implements Serializable {



	/**
	 * Creates a new Wall with a position
	 * @param pos Position
	 */
	public Wall(Position pos) {
		super.setPosition(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Wall clone() {
		try {

			Wall cloned = (Wall) super.clone();
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
		Wall other = (Wall) otherObject;
		return getPosition().equals(other.getPosition());
	}

	@Override
	public String toString() {
		return getClass().getName() + "[position=" + getPosition() + "]";
	}

}
