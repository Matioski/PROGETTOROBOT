package attackable;

import java.io.Serializable;

import board.Position;
import positionable.Box;

/**
 * Class that includes the objects Obstacle that are characterized by all the
 * instance variables of the Attackables and by a weight that can be removed
 * from the Robot that try to move the Obstacle
 * 
 * @author Mattia Rosselli
 *
 */
public class Obstacle extends Attackable implements Cloneable, Serializable {
	double weight;

	/**
	 *Constructor of Obstacle with position health and weight passed.
	 * 
	 * @param pos
	 *            position on the GameBoard
	 * @param h
	 *            Initial health
	 * @param w
	 *            Initial weight
	 */

	public Obstacle(Position pos, double h, double w) {
		// TODO Auto-generated constructor stub
		super.setPosition(pos);
		super.setHealth(h);
		this.setWeight(w);
		super.setDefense(0);
	}

	@Override
	public Obstacle clone() {
		try {

			Obstacle cloned = (Obstacle) super.clone();
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
		if (otherObject.getClass()!=getClass())
			return false;
		Obstacle other = (Obstacle) otherObject;
		return getPosition().equals(other.getPosition()) && this.getHealth() == other.getHealth()
				&& this.getWeight() == other.getWeight();
	}

	/**
	 * Method that returns the weight
	 * 
	 * @return The weight value
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Update the weight value
	 * 
	 * @param w
	 *            Value of the weight updated
	 */
	public void setWeight(double w) {
		weight = w;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[health=" + getHealth() + "," + "weight=" + getWeight() + "," + "position="
				+ getPosition() + "]";
	}

}
