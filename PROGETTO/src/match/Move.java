package match;

import java.io.Serializable;

import board.Position;

/**
 * Class that represents the move
 * @author Mattia Rosselli
 *
 */
public class Move implements Serializable {
	private String action;
	private Position target;
	private Position sender;

	/**
	 * Create  a new Move
	 * @param act Action
	 * @param sen Sender
	 * @param tar Taget
	 */
	public Move(String act, Position sen, Position tar) {

		setAction(act);
		setTarget(tar);
		setSender(sen);
	}

	/**
	 * Returns the action
	 * @return action chosen
	 */
	public String getAction() {
		return action;
	}

	/**
	 * The positionable that sent the  move
	 * @return the sender
	 */
	public Position getSender() {
		return sender;
	}
	/**
	 * The positionable target of the action
	 * @return the target
	 */
	public Position getTarget() {
		return target;
	}

	/**
	 * Sets the action
	 * @param action action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Sets the sender
	 * @param sender sender
	 */
	public void setSender(Position sender) {
		this.sender = sender;
	}

	/**
	 * Sets the target
	 * @param target Target
	 */
	public void setTarget(Position target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[action=" + action + ",sender=" + sender + ",target=" + target + "]";
	}
}
