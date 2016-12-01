/**
 * 
 */
package testers;

import board.Position;
import positionable.Wall;

/**
 * @author Mattia
 *
 */
public class WallTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wall test1 = new Wall(new Position(65, 78));
		Wall test2 = new Wall(new Position(45, 78));
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		Wall cloned = test1.clone();
		System.out.println(test1.equals(cloned));
	}

}
