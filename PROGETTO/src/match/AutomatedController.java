package match;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import attackable.Robot;

/**
 * Class that manages automatically the moves of a robot
 * @author Mattia Rosselli
 *
 * @param <T> subclass of Robot
 */
public class AutomatedController<T extends Robot> extends Controller<T> implements Serializable {

	/**
	 * Create a Automated controller for a Robot
	 * @param rob Robot to manage
	 */
	public AutomatedController(T rob) {
		super(rob);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Automatically choose the next move when invoked
	 */
	public void chooseNext() {
		ArrayList<Move> moves = super.getMoves();
		Random rand = new Random();
		super.chooseNext(moves.get(rand.nextInt(moves.size())));
		super.setFlag(true);
		super.resetMoves();

	}

}
