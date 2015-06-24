/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE616 {

	/**
	 * 
	 */
	public PE616() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = randomArray(100000);
		int key = hdR.mtd.getRandomNumber(1, 100000);
		
		long startTimeL = System.currentTimeMillis();
		System.out.println("Linear search result: " + hdR.mtd.linearSearch(test, key));
		long endTimeL = System.currentTimeMillis();
		long executionTimeL = endTimeL - startTimeL;
		
		//java.util.Arrays.sort(test);
		java.util.Arrays.sort(test);
		long startTimeB = System.currentTimeMillis();
		System.out.println("Binary search result: " + hdR.mtd.binarySearch(test, key));
		long endTimeB = System.currentTimeMillis();
		
		long executionTimeB = endTimeB - startTimeB;
		
		System.out.print("Execution time of the linear search is: " + executionTimeL + " seconds\n" + 
				"Execution time of the binary search is: " + executionTimeB + " seconds");
		
	}
	
	public static int[] randomArray(int numberOfElements) {
		int[] array = new int[numberOfElements];
		for (int i = 0; i < array.length; i++) {
			array[i] = hdR.mtd.getRandomNumber(1, 100000);
		}
		return array;
	}

}
