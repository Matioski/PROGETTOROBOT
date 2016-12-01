/**
 * 
 */
package testers;

import attackable.Obstacle;
import board.Position;

/**
 * @author Mattia
 *
 */
public class ObstacleTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Obstacle test1 = new Obstacle(new Position(20, 20), 20, 75);
		Obstacle test2 = new Obstacle(new Position(20, 20), 30, 30);
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		Obstacle cloned = test1.clone();
		System.out.println(test1.equals(cloned));
		System.out.println(test2.toString());
	}

}
