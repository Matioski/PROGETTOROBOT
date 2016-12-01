package match;

/**
 * Exception thrown when the target moved before the Fighter attack
 * @author Mattia Rosselli
 *
 */
public class EscapedException extends IllegalArgumentException {

	public EscapedException() {
		super("Target escaped!");
	}

	public EscapedException(String string) {
		// TODO Auto-generated constructor stub
		super(string);

	}
}
