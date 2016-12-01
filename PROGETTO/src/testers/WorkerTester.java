/**
 * 
 */
package testers;

import attackable.Worker;

/**
 * @author Mattia
 *
 */
public class WorkerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Worker test1 = new Worker("George");
		Worker test2 = new Worker("Georgine");
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		Worker cloned = test1.clone();
		System.out.println(test1.equals(cloned));
		System.out.println(test2.toString());
	}

}
