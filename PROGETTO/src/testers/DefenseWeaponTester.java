/**
 * 
 */
package testers;

import item.DefenseWeapon;

/**
 * @author Mattia
 *
 */
public class DefenseWeaponTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefenseWeapon test1 = new DefenseWeapon("George", 100);
		DefenseWeapon test2 = new DefenseWeapon("Georgine", 100);
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		DefenseWeapon cloned = test1.clone();
		System.out.println(test1.equals(cloned));
	}

}
