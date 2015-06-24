/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE613 {

	/**
	 * 
	 */
	public PE613() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] counts = new int[54];
		
		for (int i = 0; i < 10000; i++) {
			counts[getRandom(1, 53, 27)]++;
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.println("[" + i + "]" + " has been counted: " + counts[i]);
		}

	}
	
	public static int getRandom(int... numbers) {
		int random = (int)(Math.random() * (54 - 1) + 1);
		while(java.util.Arrays.binarySearch(numbers, random) >= 0) {
			random = (int)(Math.random() * (54 - 1) + 1);
		}
		return random;
	}

}
