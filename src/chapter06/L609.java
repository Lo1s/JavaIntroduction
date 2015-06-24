/**
 * 
 */
package chapter06;

/**
 * @author hydRa
 *
 */
public class L609 {

	/**
	 * 
	 */
	public L609() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] test = {5, 1, 9, 8, 2, 4, 3, 7, 6};
		insertionSort(test);
		hdR.mtd.displayArray(test, 10);
	}
	
	public static void insertionSort(double[] array) {
		for (int i = 1; i < array.length; i++) {
			// Insert array[i] into a sorted sublist array[0..i-1] so that array[0..i] is sorted
			double currentElement = array[i];
			int k;
			for (k = i - 1; k >= 0 && array[k] > currentElement; k--) {
				array[k + 1] = array[k];
			}
			// Insert the current element into array[k + 1]
			array[k + 1] = currentElement;
		}
	}

}
