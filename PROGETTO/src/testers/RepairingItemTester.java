/**
 * 
 */
package testers;

import item.RepairingItem;

/**
 * @author Mattia
 *
 */
public class RepairingItemTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepairingItem test1 = new RepairingItem("George", 100);
		RepairingItem test2 = new RepairingItem("Georgine", 100);
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		RepairingItem cloned = test1.clone();
		System.out.println(test1.equals(cloned));
		cloned.setRepairingRate(1000);
		System.out.println(test1.equals(cloned));

	}

}
