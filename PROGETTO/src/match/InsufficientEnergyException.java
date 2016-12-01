package match;

import java.io.IOException;

/**
 * Exception thrown when a robot has no energy to move
 * @author Mattia Rosselli
 *
 */
public class InsufficientEnergyException extends IOException {

	public InsufficientEnergyException() {
		// TODO Auto-generated constructor stub
	}

	public InsufficientEnergyException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
