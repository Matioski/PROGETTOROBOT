package graphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import attackable.Fighter;
import attackable.Obstacle;
import attackable.Worker;
import board.GameBoard;
import board.Position;
import positionable.Box;
import positionable.Trunk;
import positionable.Wall;

/**
 * Class that manage graphically the GameBoard
 * @author Mattia Rosselli
 *
 */
public class GameBoardGraphics extends JPanel {
	private GameBoard table;
	private int height;
	private int width;
	private JPanel board;

	/**
	 * Constructor that create a GameBoardGraphics starting from a GameBoard.
	 * @param table GameBoard to draw
	 * @param width Width of the GameBoard
	 * @param height Height of the GameBoard
	 */
	public GameBoardGraphics(GameBoard table, int width, int height) {
		this.table = table;
		this.height = height;
		this.width = width;
	}

	/**
	 * Method that crete the Panel with the board.
	 * @param dF Frame Dimension
	 * @return Panel containing  the GameBoard
	 */
	public JPanel getFrame(Dimension dF) {
		String projectPath = System.getProperty("user.dir");
		ImagePanel map = new ImagePanel(new GridLayout(height, width), projectPath + "\\src\\board\\roadi.jpg");

		for (int j = 0; j < height; j++) {

			for (int i = 0; i < width; i++) {
				if (table.isObstacle(new Position(i, j)))
					map.add(new ObstacleComponent((Obstacle) table.getBoard().get(i).get(j), dF,
							new Dimension(width, height)));
				else if (table.isTrunk(new Position(i, j)))
					map.add(new TrunkComponent((Trunk) table.getBoard().get(i).get(j), dF,
							new Dimension(width, height)));
				else if (table.isWall(new Position(i, j)))
					map.add(new WallComponent((Wall) table.getBoard().get(i).get(j), dF, new Dimension(width, height)));
				else if (table.isWorker(new Position(i, j)))
					map.add(new WorkerComponent((Worker) table.getBoard().get(i).get(j), dF,
							new Dimension(width, height)));
				else if (table.isFighter(new Position(i, j)))
					map.add(new FighterComponent((Fighter) table.getBoard().get(i).get(j), dF,
							new Dimension(width, height)));

				else
					map.add(new BoxComponent((Box) table.getBoard().get(i).get(j), dF, new Dimension(width, height)));
				;

			}

		}
		map.setPreferredSize(new Dimension(((dF.width) / (width + 1)), ((dF.height) / (height + 1))));
		board = map;

		return map;
	}

	/**
	 * Returns the component in the position x,y
	 * @param i x of the Positionable
	 * @param j y of the Positionable
	 * @param dF Frame Dimension
	 * @param dA Array Dimension
	 * @return The component in position x,y
	 */
	public Component getPositionableComponent(int i, int j, Dimension dF, Dimension dA) {
		if (table.isObstacle(new Position(i, j)))
			return (new ObstacleComponent((Obstacle) table.getBoard().get(i).get(j), dF, dA));
		else if (table.isTrunk(new Position(i, j)))
			return (new TrunkComponent((Trunk) table.getBoard().get(i).get(j), dF, dA));
		else if (table.isWall(new Position(i, j)))
			return (new WallComponent((Wall) table.getBoard().get(i).get(j), dF, dA));
		else if (table.isWorker(new Position(i, j)))
			return (new WorkerComponent((Worker) table.getBoard().get(i).get(j), dF, dA));
		else if (table.isFighter(new Position(i, j)))
			return (new FighterComponent((Fighter) table.getBoard().get(i).get(j), dF, dA));

		else
			return (new BoxComponent((Box) table.getBoard().get(i).get(j), dF, dA));
	}

	/**
	 * Method that returns the GameBoard
	 * @return The GameBoard
	 */
	public GameBoard getTable() {
		return table;
	}
}
