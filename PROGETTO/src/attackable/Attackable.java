package attackable;

import java.io.Serializable;

import board.Position;
import positionable.Positionable;

/**
 * 
 * 
 * Abstract class that includes all the Positionables that can be attacked and
 * for this reason they have a life and a defense.
 * 
 * @author Mattia Rosselli
 *
 *
 * 
 * 
 * 
 */
public abstract class Attackable extends Positionable implements Serializable {
	private double health;
	private double defense;

	/**
	 * Method that returns the Positionable's defense.
	 * 
	 * @return Positionable's defense.
	 */
	public double getDefense() {
		return defense;
	}

	/**
	 * Method that returns the Positionable's health.
	 * 
	 * @return Positionable's health.
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * Method that controls if the health value is less than 0 and in that case
	 * returns true, false otherwise.
	 * 
	 * @return A boolean value that tells if he's alive or not.
	 */
	public boolean isDead() {
		if (health <= 0)
			return true;
		return false;
	}

	/**
	 * Method that changes the defense value to the explicit parameter
	 * 
	 * @param d
	 *            new defense value
	 */
	public void setDefense(double d) {
		defense = d;
	}

	/**
	 * Method that changes the health. If the value is more than 100 this is set
	 * to 100 otherwise if is passed a value less than 0 it is set to 0
	 * 
	 * @param h
	 *            New Health value
	 */
	public void setHealth(double h) {
		if (h > 100) {
			health = 100;
			return;
		}
		if (h < 0) {
			health = 0;
			return;
		}
		health = h;
	}

	@Override
	public void setPosition(Position pos) {
		super.setPosition(pos);
	}

}
