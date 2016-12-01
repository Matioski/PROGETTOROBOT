/**
 * 
 */
package testers;

import attackable.Fighter;

/**
 * @author Mattia
 *
 */
public class FighterTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fighter test1 = new Fighter("George");
		Fighter test2 = new Fighter("Georgine");
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		Fighter cloned = test1.clone();
		System.out.println(test1.equals(cloned));
		System.out.println(test2.toString());
	}

}
