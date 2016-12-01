/**
 * 
 */
package testers;

import board.Position;
import positionable.Trunk;

/**
 * @author Mattia
 *
 */
public class TrunkTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trunk test1 = new Trunk(new Position(65, 78));
		Trunk test2 = new Trunk(new Position(45, 78));
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		Trunk cloned = test1.clone();
		System.out.println(test1.equals(cloned));
	}

}
