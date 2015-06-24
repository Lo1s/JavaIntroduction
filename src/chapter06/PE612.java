/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE612 {

	/**
	 * 
	 */
	public PE612() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] test = {1.0, 5.0, 8.0, 3.0, 2.0, 9.0, 4.0, 6.0, 7.0, 5.0};
		hdR.mtd.displayArray(test, 10);
		System.out.println();
		hdR.mtd.displayArray(reversePassedArray(test), 10);
	}
	
	public static double[] reversePassedArray(double[] array) {
		double temp = 0;
		
		for (int i = 0; i < array.length / 2; i++) {
			temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;		
		
	}

}
