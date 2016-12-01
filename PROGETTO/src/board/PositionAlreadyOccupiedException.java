package board;

/**
 * Exception that has to be thrown when  the Position is already occupied.
 * @author Mattia Rosselli
 *
 */
public class PositionAlreadyOccupiedException extends IllegalAccessException {

	/**
	 * Default constructor that create the exception with the default message.
	 */
	public PositionAlreadyOccupiedException() {

		super("I'm sorry to have preceded you.");
	}

	/**
	 * Constructor that create the exception with the given message.
	 * @param msg Message to throw.
	 */
	public PositionAlreadyOccupiedException(String msg) {
		super(msg);

	}

}
