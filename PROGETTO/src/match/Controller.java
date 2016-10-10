package match;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import attackable.Attackable;
import attackable.Fighter;
import attackable.Obstacle;
import attackable.Robot;
import attackable.Worker;
import board.GameBoard;
import board.Position;
import board.PositionAlreadyOccupiedException;
import graphics.TrunkFrame;

/**
 * Class used to manage Robot choices
 * @author Mattia Rosselli
 *
 * @param <T> generalization of Robot
 */

public class Controller<T extends Robot> implements Serializable {
	private ArrayList<Move> possibleMoves = new ArrayList<Move>();
	private Move nextMove;
	private T robot;
	private boolean flag = false;

	/**
	 * Creates a controller with a given robot
	 * @param rob Robot to control
	 */
	public Controller(T rob) {
		robot = rob;
	}

	/**
	 * Add a move to possibleMoves
	 * @param m Move to add
	 */
	public void addMove(Move m) {
		possibleMoves.add(m);
	}
	
	/**
	 * Checks if the robot can attack and add the move to moves
	 * @param gB gameBoard
	 */
	public void canAttack(GameBoard gB) {
		if (!robot.getClass().getName().contains("Fighter") || robot.getStrength() < 25)
			return;
		Position up = robot.getPosition().getUp();
		Position down = robot.getPosition().getDown();
		Position left = robot.getPosition().getLeft();
		Position right = robot.getPosition().getRight();
		if (gB.isAttackable(up)) {
			Attackable temp = (Attackable) gB.getPositionable(up);
			if (!temp.isDead())
				possibleMoves.add(new Move("ATTACK", robot.getPosition(), up));
		}
		if (gB.isAttackable(down)) {
			Attackable temp = (Attackable) gB.getPositionable(down);
			if (!temp.isDead())
				possibleMoves.add(new Move("ATTACK", robot.getPosition(), down));
		}
		if (gB.isAttackable(left)) {
			Attackable temp = (Attackable) gB.getPositionable(left);
			if (!temp.isDead())
				possibleMoves.add(new Move("ATTACK", robot.getPosition(), left));
		}
		if (gB.isAttackable(right)) {
			Attackable temp = (Attackable) gB.getPositionable(right);
			if (!temp.isDead())
				possibleMoves.add(new Move("ATTACK", robot.getPosition(), right));
		}
	}

	/**
	 * Checks if the robot can go down and add the move to moves
	 * @param gB gameBoard
	 */
	public void canDown(GameBoard gB) {
		if (robot.getEnergy() < 10)
			return;
		Position down = robot.getPosition().getDown();
		if (gB.isEmpty(down)) {
			possibleMoves.add(new Move("MOVE DOWN", robot.getPosition(), down));
		}
	}

	/**
	* Checks if the robot can go left and add the move to moves
	 * @param gB gameBoard
	 */
	public void canLeft(GameBoard gB) {
		if (robot.getEnergy() < 10)
			return;
		Position left = robot.getPosition().getLeft();
		if (gB.isEmpty(left)) {
			possibleMoves.add(new Move("MOVE LEFT", robot.getPosition(), left));
		}
	}

	/**
	* Checks if the robot can pull an Obstacle and add the move to moves
	 * @param gB gameBoard
	 */
	public void canPull(GameBoard gB) {

		Position up = robot.getPosition().getUp();
		Position down = robot.getPosition().getDown();
		Position left = robot.getPosition().getLeft();
		Position right = robot.getPosition().getRight();
		if (gB.isObstacle(up) && gB.isEmpty(down)) {
			Obstacle temp = (Obstacle) gB.getPositionable(up);
			if (robot.getStrength() >= temp.getWeight() && robot.getEnergy() >= 10)
				possibleMoves.add(new Move("PULL", up, robot.getPosition().getDown()));
		}
		if (gB.isObstacle(down) && gB.isEmpty(up)) {
			Obstacle temp = (Obstacle) gB.getPositionable(down);
			if (robot.getStrength() >= temp.getWeight() && robot.getEnergy() >= 10)
				possibleMoves.add(new Move("PULL", down, robot.getPosition().getUp()));
		}
		if (gB.isObstacle(left) && gB.isEmpty(right)) {
			Obstacle temp = (Obstacle) gB.getPositionable(left);
			if (robot.getStrength() >= temp.getWeight() && robot.getEnergy() >= 10)
				possibleMoves.add(new Move("PULL", left, robot.getPosition().getRight()));
		}
		if (gB.isObstacle(right) && gB.isEmpty(left)) {
			Obstacle temp = (Obstacle) gB.getPositionable(right);
			if (robot.getStrength() >= temp.getWeight() && robot.getEnergy() >= 10)
				possibleMoves.add(new Move("PULL", right, robot.getPosition().getLeft()));
		}

	}

	/**
	 * Checks if the robot can push the Obstacle and add the move to moves
	 * @param gB gameBoard
	 */
	public void canPush(GameBoard gB) {

		Position up = robot.getPosition().getUp();
		Position down = robot.getPosition().getDown();
		Position left = robot.getPosition().getLeft();
		Position right = robot.getPosition().getRight();
		if (gB.isObstacle(up) && gB.isEmpty(up.getUp())) {
			Obstacle temp = (Obstacle) gB.getPositionable(up);
			if (robot.getStrength() >= temp.getWeight() && robot.getEnergy() >= 10)
				possibleMoves.add(new Move("PUSH", up, up.getUp()));
		}

		if (gB.isObstacle(down) && gB.isEmpty(down.getDown())) {
			Obstacle temp = (Obstacle) gB.getPositionable(down);
			if (robot.getStrength() >= temp.getWeight() && robot.getEnergy() >= 10)
				possibleMoves.add(new Move("PUSH", down, down.getDown()));
		}
		if (gB.isObstacle(left) && gB.isEmpty(left.getLeft())) {
			Obstacle temp = (Obstacle) gB.getPositionable(left);
			if (robot.getStrength() >= temp.getWeight() && robot.getEnergy() >= 10)
				possibleMoves.add(new Move("PUSH", left, left.getLeft()));
		}
		if (gB.isObstacle(right) && gB.isEmpty(right.getRight())) {
			Obstacle temp = (Obstacle) gB.getPositionable(right);
			if (robot.getStrength() >= temp.getWeight() && robot.getEnergy() >= 10)
				possibleMoves.add(new Move("PUSH", right, right.getRight()));
		}
	}

	/**
	 * Checks if the robot can repair and add the move to moves
	 * @param gB gameBoard
	 */
	public void canRepair(GameBoard gB) {
		if (!robot.getClass().getName().contains("Worker") || robot.getStrength() < 25)
			return;
		Worker worker=(Worker) robot;
		if(worker.getReapairingRate()<=0)return;
		Position up = robot.getPosition().getUp();
		Position down = robot.getPosition().getDown();
		Position left = robot.getPosition().getLeft();
		Position right = robot.getPosition().getRight();
		if (gB.isFighter(up) || gB.isWorker(up)) {
			Attackable temp = (Attackable) gB.getPositionable(up);

			possibleMoves.add(new Move("REPAIR", robot.getPosition(), up));
		}
		if (gB.isFighter(down) || gB.isWorker(down)) {
			Attackable temp = (Attackable) gB.getPositionable(down);

			possibleMoves.add(new Move("REPAIR", robot.getPosition(), down));
		}
		if (gB.isFighter(left) || gB.isWorker(left)) {
			Attackable temp = (Attackable) gB.getPositionable(left);

			possibleMoves.add(new Move("REPAIR", robot.getPosition(), left));
		}
		if (gB.isFighter(right) || gB.isWorker(right)) {
			Attackable temp = (Attackable) gB.getPositionable(right);

			possibleMoves.add(new Move("REPAIR", robot.getPosition(), right));
		}
	}

	/**
	 * Checks if the robot can go right and add the move to moves
	 * @param gB gameBoard
	 */
	public void canRight(GameBoard gB) {
		if (robot.getEnergy() < 10)
			return;
		Position right = robot.getPosition().getRight();
		if (gB.isEmpty(right)) {
			possibleMoves.add(new Move("MOVE RIGHT", robot.getPosition(), right));
		}
	}

	/**
	 * Checks if the robot can equip from the trunk and add the move to moves
	 * @param gB gameBoard
	 */
	public void canTrunk(GameBoard gB) {

		Position up = robot.getPosition().getUp();
		Position down = robot.getPosition().getDown();
		Position left = robot.getPosition().getLeft();
		Position right = robot.getPosition().getRight();
		if (gB.isTrunk(up) || gB.isTrunk(down) || gB.isTrunk(left) || gB.isTrunk(right)) {
			possibleMoves.add(new Move("TRUNK", robot.getPosition(), robot.getPosition()));
		}
	}

	/**
	 * Checks if the robot can go up and add the move to moves
	 * @param gB gameBoard
	 */
	public void canUp(GameBoard gB) {

		if (robot.getEnergy() < 10)

			return;
		Position up = robot.getPosition().getUp();
		if (gB.isEmpty(up)) {
			possibleMoves.add(new Move("MOVE UP", robot.getPosition(), up));
		}
	}

	/**
	 * Choose the next move to perform
	 * @param m Move to perform
	 */
	public void chooseNext(Move m) {
		this.nextMove = m;
		flag = true;
		possibleMoves = new ArrayList<Move>();
	}

	/**
	 * Fill the arry moves with all the possible moves
	 * @param gB GameBoard
	 */
	public void fillPossibleMoves(GameBoard gB) {

		possibleMoves = new ArrayList<Move>();
		this.robot.setStrength(robot.getStrength() + 10);
		this.robot.setEnergy(robot.getEnergy() + 5);
		if (robot.getEnergy() < 10) {
			try {
				throw new InsufficientEnergyException(robot.getName() + " doesn't have enough energy to move");
			} catch (InsufficientEnergyException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Ops!", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			this.canDown(gB);
			this.canUp(gB);
			this.canLeft(gB);
			this.canRight(gB);
		}

		this.canPush(gB);
		this.canAttack(gB);
		this.canPull(gB);
		this.canTrunk(gB);
		this.canRepair(gB);
		this.addMove(new Move("DON'T MOVE", getRobot().getPosition(), getRobot().getPosition()));

	}
	
	/**
	 * @return the flag that indicates if the action has been performed:
	 */
	public boolean getFlag() {
		return flag;
	}
	
	/**
	 * Returns the ArrayList of the possible moves
	 * @return the ArrayList of the possible moves
	 */
	public ArrayList<Move> getMoves() {
		return possibleMoves;
	}

	/**
	 * Returns the robot controlled
	 * @return the robot controlled
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * Returns a boolean that indicates if the robot is dead or not
	 * @return true if the robot is dead false if not
	 */
	public boolean isDead() {
		if (robot.getHealth() <= 0)
			return true;
		return false;
	}

	/**
	 * Performs the selected action
	 * @param gB GameBoard
	 */
	public void performAction(GameBoard gB) {
		switch (nextMove.getAction()) {
		case "MOVE UP":
		case "MOVE DOWN":
		case "MOVE LEFT":
		case "MOVE RIGHT":
			try {
				gB.movePositionable(nextMove.getSender(), nextMove.getTarget());
				removeEnergy(10);

			} catch (PositionAlreadyOccupiedException e) {
				JOptionPane.showMessageDialog(null, robot.getName() + " : " + e.getMessage(), "Ops!",
						JOptionPane.ERROR_MESSAGE);
			}

			break;
		case "PUSH":
			try {
				gB.movePositionable(nextMove.getSender(), nextMove.getTarget());
				gB.movePositionable(robot.getPosition(), nextMove.getSender());
				this.removeEnergy(10);
				Obstacle temp = (Obstacle) gB.getPositionable(nextMove.getTarget());
				this.removeStrength(robot.getStrength() - temp.getWeight());
			} catch (PositionAlreadyOccupiedException e) {
				JOptionPane.showMessageDialog(null, robot.getName() + e.getMessage(), "Ops!",
						JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "PULL":
			try {
				Position temp = robot.getPosition().clone();
				gB.movePositionable(robot.getPosition(), nextMove.getTarget());
				gB.movePositionable(nextMove.getSender(), temp);
				this.removeEnergy(10);
				Obstacle tempOb = (Obstacle) gB.getPositionable(temp);
				this.removeStrength(robot.getStrength() - tempOb.getWeight());

			} catch (PositionAlreadyOccupiedException e) {
				JOptionPane.showMessageDialog(null, robot.getName() + e.toString(), "Ops!", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "TRUNK":
			synchronized (this) {
				TrunkFrame trunk = new TrunkFrame(this);
				if (this.getClass().getName().contains("Automated"))
					;
				else {

					trunk.setVisible(true);
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			break;
		case "REPAIR":
			try {
				if (gB.isAttackable(nextMove.getTarget())) {
					Robot target = (Robot) gB.getPositionable(nextMove.getTarget());
					Worker worker = (Worker) robot;
					target.setHealth(target.getHealth() + worker.getReapairingRate());
					removeStrength(25);
				} else
					throw new EscapedException("The Robot doesn't want the cure");

			} catch (EscapedException e) {
				JOptionPane.showMessageDialog(null, robot.getName() + e.getMessage(), "Ops!",
						JOptionPane.ERROR_MESSAGE);
			}

			break;

		case "ATTACK":
			try {
				if (gB.isAttackable(nextMove.getTarget())) {
					Attackable target = (Attackable) gB.getPositionable(nextMove.getTarget());
					Fighter fighter = (Fighter) robot;
					target.setHealth(target.getHealth() - fighter.getAttack() + target.getDefense());
					removeStrength(25);
					if (target.getHealth() < 25)
						// throw new CriticalStatusException("Target health
						// under 25%");
						if (target.isDead() && gB.isObstacle(target.getPosition()))
							gB.removePositionable(target);
						else if (target.isDead()
								&& (gB.isFighter(target.getPosition()) || gB.isWorker(target.getPosition())))
							JOptionPane.showMessageDialog(null, robot.getName() + " killed the target ", "Wow!",
									JOptionPane.INFORMATION_MESSAGE);
				} else
					throw new EscapedException();

			} catch (EscapedException e) {
				JOptionPane.showMessageDialog(null, robot.getName() + e.getMessage(), "Ops!",
						JOptionPane.ERROR_MESSAGE);
			}
		case "DON'T MOVE":
			break;
		default:
			throw new IllegalArgumentException("Move not recognised!");
		}
		flag = false;
		nextMove = null;
	}

	/**
	 * Removes energy to a robot
	 * @param minus energy to remove
	 */
	public void removeEnergy(double minus) {
		double energy = robot.getEnergy();
		robot.setEnergy(energy - minus);
	}
	/**
	 * Removes strength to a robot
	 * @param minus strength to remove
	 */
	public void removeStrength(double minus) {
		double strength = robot.getStrength();
		robot.setStrength(strength - minus);
	}

	/**
	 * Reset the ArrayList of possible moves
	 */
	public void resetMoves() {
		possibleMoves = new ArrayList<Move>();
	}

	/**
	 * sets the flag to the boolean given
	 * @param bool value to set
	 */
	public void setFlag(boolean bool) {
		flag = bool;
	}

	/**
	 * Takes the cure
	 * @param cure cure to take
	 */
	public void takeCure(double cure) {
		double health = robot.getHealth();
		robot.setHealth(health + cure);
	}
	/**
	 * Takes the damage
	 * @param damage damage to take
	 */
	public void takeDamage(double damage) {
		double health = robot.getHealth();
		robot.setHealth(health - damage);
	}
	/**
	 * Takes the energy
	 * @param energy energy to take
	 */
	public void takeEnergy(double plus) {
		double energy = robot.getEnergy();
		robot.setEnergy(energy + plus);
	}
	/**
	 * Takes the Strength
	 * @param Strength Strength to take
	 */
	public void takeStrength(double plus) {
		double strength = robot.getStrength();
		robot.setStrength(strength + plus);
	}
}
