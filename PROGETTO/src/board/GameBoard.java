package board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import attackable.Obstacle;
import positionable.Box;
import positionable.Positionable;
import positionable.Trunk;
import positionable.Wall;

/**
 * A playing field on which can be inserted positionable. Before   * Using it to
 * invoke the fill () method.   *   * @author Mattia Rosselli   *
 */
public class GameBoard implements Cloneable, Serializable {
	private ArrayList<ArrayList<Positionable>> board = new ArrayList<ArrayList<Positionable>>();

	private int width;
	private int height;

	/**
	 * 
	 * Builder creates a playing field (X * Y) with all the positions Null.
	 *
	 * @param X
	 *            Width field.
	 * @param Y
	 *            Height field.
	 */
	public GameBoard(int x, int y) {

		width = x;
		height = y;

	}

	/**
	* Adds an element positionable on the playing field to a position
	* Randomly generated.
	*
	* @param Pos
	* Element to be positioned.
	*/
	public void addPositionableRandomly(Positionable pos) {
		boolean positioned = false;
		Random rand = new Random();
		while (!positioned) {

			int randomX = rand.nextInt(width);
			int randomY = rand.nextInt(height);
			if (isEmpty(new Position(randomX, randomY))) {

				board.get(randomX).set(randomY, pos);
				pos.setPosition(new Position(randomX, randomY));
				positioned = true;
			}
		}

	}

	@Override
	public GameBoard clone() {
		try {

			GameBoard cloned = (GameBoard) super.clone();
			cloned.board = (ArrayList<ArrayList<Positionable>>) this.board.clone();

			for (int j = 0; j < width; j++) {
				cloned.board.remove(j);
				cloned.board.add(j, ((ArrayList<Positionable>) board.get(j).clone()));
				// cloned.board.add((ArrayList<Positionable>)
				// board.get(j).clone());
				for (int i = 0; i < height; i++) {
					cloned.board.get(j).remove(i);
					cloned.board.get(j).add(i, (Positionable) board.get(j).get(i).clone());
				}
			}
			return cloned;

		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		if (otherObject.getClass()!=getClass() )
			return false;
		GameBoard other = (GameBoard) otherObject;
		boolean equ = true;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!this.getPositionable(new Position(i, j)).equals(other.getPositionable(new Position(i, j))))
					equ = false;
			}
		}
		return equ;
	}

	/**
	* Method which fills the playing field with 7% of Wall, 10% of the Obstacle and the
* Remainder of Box. Does not create blocks of Wall that would not allow
* To move pieces.
	 */
	public void fill() {
		ArrayList<Positionable> inner = new ArrayList<Positionable>();
		Random rand = new Random();
		int random;
		// for every row
		for (int i = 0; i < width; i++) {
			// for every column
			inner = new ArrayList<Positionable>();
			board.add(inner);
			for (int j = 0; j < height; j++) {
				// generate a random number between 0 include and 100 exclusive.
				random = rand.nextInt(100);
				// seven percent means 7/100 so if random is a number less than
				// seven
				if (random < 7) { // generate a Wall
					if (i != 0) {
						if (this.isWall(new Position(i - 1, j))) {
							board.get(i).add(new Box(new Position(i, j)));
							continue;
						}
					} else if (j != 0) {
						if (this.isWall(new Position(i, j - 1))) {
							board.get(i).add(new Box(new Position(i, j)));
							continue;
						}
					}

					board.get(i).add(new Wall(new Position(i, j)));

				}
				// 10 percent is between 10/100, so if random is between ten
				// digits
				else if (random >= 7 && random < 17) {

					// generate obstacle

					Random randh = new Random();

					board.get(i).add(new Obstacle(new Position(i, j), randh.nextInt(100) + 1, randh.nextInt(50)));

				}
				// else
				else { // fill with empty
					board.get(i).add(new Box(new Position(i, j)));

				}
				random = rand.nextInt(100);
			}
		}

		Position temp = new Position(rand.nextInt(width - 1), rand.nextInt(height - 1));

		while (true) {

			if (this.isEmpty(temp)) {
				board.get(temp.getX()).set(temp.getY(), new Trunk(temp));
				break;
			}
			temp = new Position(rand.nextInt(width - 1), rand.nextInt(height - 1));
		}

	}

	/**
	* Returns the matrix of the playing field as an ArrayList of ArrayList
* Of positionable.
*
* @return The Matrix of the game field .
	 */
	public ArrayList<ArrayList<Positionable>> getBoard() {
		return board;
	}

	/**
	 Returns * The height of the playing field. * * @ Return the height of the GameBoard.
	 */
	public int getHeight() {
		return height;
	}

	/**
	* Returns a positionable object passed to the position  Explicit parameter
*
*
* @param Position
* Position of positionable concerned.
* @ Return to the past positionable position for explicit parameter.
	 */
	public Positionable getPositionable(Position position) {
		if (this.inBoard(position))
			return board.get(position.getX()).get(position.getY());
		return null;
	}

	/**
	
* Returns the width of the playing field.
*
* @return The width of the game field.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Method that checks if a position is in the field from play or not.
*
* @param Pos
* Position to check.
* @return True if it is internal to the GameBoard otherwise false.
	 */
	public Boolean inBoard(Position pos) {
		return ((pos.getX() >= 0 && pos.getX() < width) && (pos.getY() >= 0 && pos.getY() < height));
	}

	/**
	* Inserts the positionable in this position in his state.
*
* @param Pos
* Positionable to insert.
* @throws PositionAlreadyOccupiedException
* Thrown in case it is already occupied the position.
	 */
	public void insertPositionable(Positionable pos) throws PositionAlreadyOccupiedException {
		if (isEmpty(pos.getPosition())) {
			board.get(pos.getPosition().getX()).set(pos.getPosition().getY(), pos);

		}

		else
			throw new PositionAlreadyOccupiedException();
	}

	/**
	* A method that returns true if the positionable to the given position
explicit parameter is attackable type, false otherwise.
*
* @param Pos
* Position to control.
* @return True if the positionable to the given Explicit parameter
*type is attackable, otherwise false.
	 */
	public Boolean isAttackable(Position pos) {
		if (inBoard(pos))

			return isFighter(pos) || isObstacle(pos) || isWorker(pos);

		return false;
	}

	/**
	* A method that returns true if the positionable to the given position
explicit parameter is Box type, false otherwise.
*
* @param Pos
* Position to control.
* @return True if the positionable to the given Explicit parameter
*type is Box, otherwise false.
	 */

	public Boolean isEmpty(Position pos) {
		if (inBoard(pos))
			return getPositionable(pos).getClass().getName().contains("Box");
		return false;
	}

	/**
	* A method that returns true if the positionable to the given position
explicit parameter is Fighter type, false otherwise.
*
* @param Pos
* Position to control.
* @return True if the positionable to the given Explicit parameter
*type is Fighter, otherwise false.
*/
	public Boolean isFighter(Position pos) {
		if (inBoard(pos))
			return getPositionable(pos).getClass().getName().contains("Fighter");
		return false;
	}

	/**
	* A method that returns true if the positionable to the given position
explicit parameter is Obstacle type, false otherwise.
*
* @param Pos
* Position to control.
* @return True if the positionable to the given Explicit parameter
*type is Obstacle, otherwise false.
	 */
	public Boolean isObstacle(Position pos) {
		if (inBoard(pos))
			return getPositionable(pos).getClass().getName().contains("Obstacle");
		return false;
	}

	/**
	* A method that returns true if the positionable to the given position
explicit parameter is Trunk type, false otherwise.
*
* @param Pos
* Position to control.
* @return True if the positionable to the given Explicit parameter
*type is Trunk, otherwise false.
	 */
	public Boolean isTrunk(Position pos) {
		if (inBoard(pos))
			return getPositionable(pos).getClass().getName().contains("Trunk");
		return false;
	}

	/**
	* A method that returns true if the positionable to the given position
explicit parameter is Wall type, false otherwise.
*
* @param Pos
* Position to control.
* @return True if the positionable to the given Explicit parameter
*type is Wall, otherwise false.
	 */
	public Boolean isWall(Position pos) {
		if (inBoard(pos))
			return getPositionable(pos).getClass().getName().contains("Wall");
		return false;
	}

	/**
	* A method that returns true if the positionable to the given position
explicit parameter is Worker type, false otherwise.
*
* @param Pos
* Position to control.
* @return True if the positionable to the given Explicit parameter
*type is Worker, otherwise false.
	 */
	public Boolean isWorker(Position pos) {
		if (inBoard(pos))
			return getPositionable(pos).getClass().getName().contains("Worker");
		return false;
	}

	/**
	* Moves an positionable by the start position to the end position.
*
* @param Start
* Initial position.
* @param End
* End position.
* @throws PositionAlreadyOccupiedException
* Thrown when the position is already occupied.
	 */
	public void movePositionable(Position start, Position end) throws PositionAlreadyOccupiedException {
		if (isEmpty(end) || isObstacle(end)) {
			Positionable moving = getPositionable(start);

			Positionable temp = getPositionable(end);

			moving.setPosition(new Position(end.getX(), end.getY()));
			temp.setPosition(new Position(start.getX(), start.getY()));
			board.get(end.getX()).set(end.getY(), moving);
			board.get(start.getX()).set(start.getY(), temp);

		} else if (start.equals(end)) {
			throw new PositionAlreadyOccupiedException("No moves available");
		} else
			throw new PositionAlreadyOccupiedException();
	}

	/**
	 * Removes a Positionable.
	 * 
	 * @param pos
	 *            Positionable to remove.
	 */
	public void removePositionable(Positionable pos) {
		board.get(pos.getPosition().getX()).set(pos.getPosition().getY(), new Box(pos.getPosition()));
	}

	@Override
	public String toString() {
		return getClass().getName() + "[board=" + board + "]";
	}
}
