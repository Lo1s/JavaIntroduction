/**
 * 
 */
package chapter06;

/**
 * @author hydRa
 *
 */
public class L608 {

	/**
	 * 
	 */
	public L608() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		double[] test = {1, 9, 4.5, 6.6, 5.7, -4.5};
		hdR.mtd.displayArray(test, 10);
		System.out.println("\n");
		hdR.mtd.displayArray(selectionSort(test), 10);
	}

	public static double[] selectionSort(double[] array) {
		int minIndex = 0;
		double temp = 0;

		while (minIndex < array.length - 1) {
			for (int i = minIndex; i < array.length; i++) {
				if (array[i] < array[minIndex]) {
					temp = array[minIndex];
					array[minIndex] = array[i];
					array[i] = temp;
				}
			}
			minIndex++;
		}
		return array;
	}
}
