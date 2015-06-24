/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE618 {

	/**
	 * 
	 */
	public PE618() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] test = {1.9, 1.0, 2.2, 1.1, 1.3, 1.2, 1.6, 1.4, 1.8, 1.5, 1.7}; 
		hdR.mtd.displayArray(test, 11);

		System.out.println("\n");

		bubbleSort(test);
		hdR.mtd.displayArray(test, 11);
	}
	public static double[] bubbleSort(double[] array) {
		double temp;
		boolean changed = true;
		do {
			changed = false;
			for(int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					changed = true;
				}
			}
		} while (changed);
		return array;
	}

}
