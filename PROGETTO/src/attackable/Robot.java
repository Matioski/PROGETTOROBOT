package attackable;

import java.io.Serializable;

import item.Useable;

/**
 * 
 * Abstract class that describes a generic robot . Characterized by a name , an
 * energy, a force , a health and belonging to a team.
 * 
 * @author Mattia Rosselli
 *
 * @param <T>
 * 
 *            generic type which can be any class that implements the Usable
 *            interface.
 */
public abstract class Robot<T extends Useable> extends Attackable implements Cloneable, Serializable {
	private double energy, strength;
	private String name;
	private String team;

	/**
	 * 
	 * Constructor that takes as explicit parameter a name and Creates a robot
	 * with that name and the rest of the default parameters .
	 * 
	 * @param name
	 *            Name to assign.
	 */
	public Robot(String name) {
		this.name = name;

		this.energy = 100;
		super.setHealth(100);
		this.strength = 100;

	}

	/**
	 * Returns the actual energy of the Robot
	 * 
	 * @return Energy of the Robot
	 */
	public double getEnergy() {
		return energy;
	}

	@Override
	public double getHealth() {
		return super.getHealth();
	}

	/**
	 * Returns the name of the Robot
	 * 
	 * @return Name of the Robot
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the strength of the robot
	 * 
	 * @return Strength of the Robot
	 */
	public double getStrength() {
		return strength;
	}

	/**
	 * Return the name of the team the robot belongs
	 * 
	 * @return Name of its team.
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * 
	 * abstract method that allows to equip an Item . Substitute The current of
	 * the same type .
	 * 
	 * @param item
	 *            Item to equip
	 */
	public abstract void pick(T item);

	/**
	 *
	 * Sets the energy with the value of the explicit parameter .
	 *
	 * @param Energy
	 *            Updated energy value .
	 */
	public void setEnergy(double energy) {
		if (energy > 100)
			energy = 100;
		else
			this.energy = energy;
	}

	@Override
	public void setHealth(double h) {
		super.setHealth(h);
	}

	/**
	 * Set the name of the robot with the string passed as an explicit parameter
	 * .
	 *
	 * @param Name
	 *            Name updated .
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Set the force with the value of the explicit parameter .
	*
	* @param Strength
	* Updated value of the force .
	*/
	public void setStrength(double strength) {
		if (strength > 100)
			strength = 100;
		else
			this.strength = strength;
	}


/**
* Set the name of the team with the string passed through explicit value .
*
* @param T
* Updated Team name .
*/
	public void setTeam(String t) {
		team = t;
	}

}