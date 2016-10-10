package match;

import java.io.Serializable;
import java.util.ArrayList;

import attackable.Robot;

/**
 * Manage all the robot of the same team
 * @author Mattia Rosselli
 *
 */
public class Team implements Serializable {
	private String name;
	private ArrayList<Controller<Robot>> robots;
	private int nextcon;

	/**
	 * Create  a new empty team
	 * @param n name of the team
	 */
	public Team(String n) {
		name = n;
		robots = new ArrayList<Controller<Robot>>();
		resetIndex();
	}

	/**
	 * Add  a new Robot controller
	 * @param con Controller
	 */
	public void addController(Controller<Robot> con) {
		robots.add(con);
		con.getRobot().setTeam(name);
	}

	/**
	 * Checks if the componets of the team are dead
	 * @return true if all the components of the team are dead
	 */
	public boolean allDeads() {
		boolean deads = true;
		for (Controller<Robot> con : robots)
			if (!con.isDead())
				deads = false;
		return deads;
	}

	/**
	 * Returns the controller at the given index
	 * @param i index
	 * @return controller at index
	 */
	public Controller<Robot> getController(int i) {
		return robots.get(i);
	}

	/**
	 * Returns current controller
	 * @return current controller
	 */
	public Controller getCurrent() {

		if (nextcon == 0) {
			return robots.get(robots.size() - 1);
		}
		return robots.get(nextcon - 1);
	}

	/**
	 * returns the name of the team
	 * @return name of the team
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the size of the team
	 * @return size of the team
	 */
	public int getSize() {
		return robots.size();
	}

	/**
	 * checks if all moves have been chosen
	 * @return true if all the components have chosen the moves
	 */
	public boolean moveChosen() {
		boolean temp = true;
		for (Controller<Robot> c : robots) {
			if (c.getFlag() == false)
				temp = false;
		}
		return temp;
	}

	/**
	 * Returns next controller
	 * @return next controller
	 */
	public Controller nextController() {
		Controller<Robot> temp;
		if (nextcon == robots.size() - 1) {

			temp = robots.get(nextcon);
			resetIndex();
		} else {
			temp = robots.get(nextcon);
			nextcon++;
		}

		return temp;
	}

	/**
	 * Removes a controller
	 * @param con controller to remove
	 */
	public void removeController(Controller<Robot> con) {
		robots.remove(con);
	}

	/**
	 * Reset the index of robots
	 */
	public void resetIndex() {
		nextcon = 0;
	}
}
