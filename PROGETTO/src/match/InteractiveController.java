package match;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import attackable.Robot;
import graphics.GameBoardGraphics;
import graphics.MoveGraphic;

/**
 * Panel that can manages the moves of a robot through the input of the user
 * @author Mattia Rosselli
 *
 */
public class InteractiveController extends JPanel implements Serializable {
	private Controller<Robot> controller;
	private GameBoardGraphics gB;

	/**
	 * Create a new Interactive Controller
	 * @param con Controller
	 * @param board Game Board
	 */
	public InteractiveController(Controller<Robot> con, GameBoardGraphics board) {
		con.setFlag(false);
		controller = con;
		gB = board;
		con.fillPossibleMoves(gB.getTable());
		this.setBackground(Color.BLACK);

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;

		for (Move m : controller.getMoves()) {

			this.add(new MoveGraphic(m, gB, controller).getPanel(), c);

		}
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 1),"Select the next move for: "
				+ controller.getRobot().getName() + ", team:" + controller.getRobot().getTeam()));

	}

	/**
	 * Returns the controller
	 * @return the controller
	 */
	public Controller<Robot> getCon() {
		return controller;
	}
}
