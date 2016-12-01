/**
 * 
 */
package testers;

import item.AttackWeapon;

/**
 * @author Mattia
 *
 */
public class AttackWeaponTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AttackWeapon test1 = new AttackWeapon("George", 100);
		AttackWeapon test2 = new AttackWeapon("Georgine", 100);
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		AttackWeapon cloned = test1.clone();
		System.out.println(test1.equals(cloned));
	}

}
