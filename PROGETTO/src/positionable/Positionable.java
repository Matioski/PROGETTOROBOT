package positionable;

import java.io.Serializable;

import board.Position;

/**
 * Abstract class that represents all the objects that can be positioned on the GameBoard
 * @author Mattia Rosselli
 *
 */
public abstract class Positionable implements Cloneable, Serializable {

	
	private Position pos;

	
	@Override
	public Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

	/**
	 * Return the Position on the GameBoard
	 * @return Position of the Positionable
	 */
	public Position getPosition() {
		return pos;
	}

	/**
	 * sets a new position
	 * @param newPos New Position
	 */
	public void setPosition(Position newPos) {
		pos = newPos;
	}

}
