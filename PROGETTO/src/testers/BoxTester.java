/**
 * 
 */
package testers;

import board.Position;
import positionable.Box;

/**
 * @author Mattia
 *
 */
public class BoxTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box test1 = new Box(new Position(65, 78));
		Box test2 = new Box(new Position(45, 78));
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		Box cloned = test1.clone();
		System.out.println(test1.equals(cloned));
		cloned.setPosition(new Position(0, 0));
		System.out.println(test1.equals(cloned));
	}

}
