/**
 * 
 */
package testers;

import item.DefenseItem;

/**
 * @author Mattia
 *
 */
public class DefenseItemTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefenseItem test1 = new DefenseItem("George", 100);
		DefenseItem test2 = new DefenseItem("Georgine", 100);
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		DefenseItem cloned = test1.clone();
		System.out.println(test1.equals(cloned));
	}

}
