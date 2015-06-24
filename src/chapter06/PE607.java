/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE607 {

	/**
	 * 
	 */
	public PE607() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] counts = new int[10];
		for (int i = 0; i < 100; i++) {
			int randomNumber = (int)(Math.random() * 10);
			counts[randomNumber]++;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print("[" + i + "]" + " has occured: " + counts[i] + " times\n");
		}
		System.out.println("-----------------");
		
		int total = 0;
		for (int i = 0; i < counts.length; i++) {
			total += counts[i]; 
		}
		
		System.out.print("Total sum: " + total);
	}

}
