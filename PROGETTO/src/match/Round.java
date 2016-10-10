package match;

import java.util.ArrayList;
import java.util.Random;

import graphics.GameBoardGraphics;
/**

 * Class that manage all the rounds of a match
 * @author Mattia Rosselli
 *
 */


public class Round {
	private ArrayList<Team> team;

	private GameBoardGraphics gB;
	private ArrayList<InteractiveController> controllers;
	private int nextCon;
	private boolean allPerformed;

	/**
	 * Creates a new Round for the teams on a board
	 * @param t Team of the match
	 * @param board Field of the match
	 */
	public Round(ArrayList<Team> t, GameBoardGraphics board) {
		team = t;

		gB = board;
		resetConIndex();
		allPerformed = false;
		controllers = new ArrayList<InteractiveController>();
	}
	
	/**
	 * Add team e to the teams
	 * @param e Team
	 */
	public void addTeam(Team e) {
		team.add(e);
	}

	/**
	 * Check if each player has chosen the action
	 * @return all chose
	 */
	public boolean allChosen() {
		boolean temp = true;
		for (Team t : team) {
			if (!t.moveChosen())
				temp = false;
		}
		return temp;
	}
	
	/**
	 * Fills the interactive controllers of the teams passed
	 */
	public void fillControllers() {
		controllers = new ArrayList<InteractiveController>();
		for (Team t : team) {
			for (int i = 0; i < t.getSize(); i++) {
				if (!t.getController(i).isDead() && !t.getController(i).getClass().getName().contains("Automated"))
					controllers.add(new InteractiveController(t.getController(i), gB));
				if (!t.getController(i).isDead() && t.getController(i).getClass().getName().contains("Automated")) {

					AutomatedController temp = (AutomatedController) t.getController(i);
					temp.fillPossibleMoves(gB.getTable());
					temp.chooseNext();
				}
			}
		}
		allPerformed = false;
	}

	/**
	 * Returns current interactive controller
	 * @return current interactive controller
	 */
	public InteractiveController getCurrent() {

		if (nextCon == 0) {
			return controllers.get(controllers.size() - 1);
		}

		return controllers.get(nextCon - 1);
	}

	/**
	 * checks if all controller have performed their next move
	 * @return all Performed
	 */
	public boolean getPerformed() {
		return allPerformed;
	}

	/**
	 * Number of controller of round
	 * @return size of controllers
	 */
	public int getSize() {
		return controllers.size();

	}

	/**
	 * Returns the teams managed
	 * @return team managed
	 */
	public ArrayList<Team> getTeams() {
		return team;

	}

	/**
	 * Returns next Interactive Controller
	 * @return next controller
	 */
	public InteractiveController nextController() {
		InteractiveController temp;
		if (nextCon >= controllers.size() - 1) {

			temp = controllers.get(nextCon);
			resetConIndex();

		}

		else {
			temp = controllers.get(nextCon);
			nextCon++;
		}

		return temp;
	}

	/**
	 * Performs actions chosen randomly
	 */
	public void performRandom() {
		Random rand = new Random();
		ArrayList<Boolean> flag = new ArrayList<Boolean>();
		boolean sum = false;
		for (double i = 0; i < team.size(); i++) {

			flag.add(true);
		}
		do {
			int r;
			r = rand.nextInt(team.size());

			if (flag.get(r)) {
				Team temp = team.get(r);

				for (double j = 0; j < temp.getSize(); j++) {
					if (!temp.nextController().isDead())
						temp.getCurrent().performAction(gB.getTable());

					flag.set(r, false);
				}
			}
			sum = false;
			for (double i = 0; i < flag.size(); i++) {
				if (flag.get((int) i))
					sum = true;

			}

		} while (sum);
		allPerformed = true;
	}

	/**
	 * Removes a team at a index
	 * @param index index of the team to remove
	 */
	public void removeTeam(int index) {
		team.remove(index);
	}

	/**
	 * Reset next controller index
	 */
	public void resetConIndex() {
		nextCon = 0;
	}

	/**
	 * checks is a team is dead
	 * @return team that is dead
	 */
	public String teamDead() {
		for (Team t : team) {
			if (t.allDeads())
				return t.getName();
		}
		return null;
	}
}
