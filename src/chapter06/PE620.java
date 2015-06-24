/**
 * 
 */
package chapter06;

/**
 * @author hydRa
 *
 */
public class PE620 {

	/**
	 * 
	 */
	public PE620() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1, 5, 7, 2, 6, 0, 3, 4, 8, 9};
		hdR.mtd.displayArray(test, 10);
		
		System.out.println();
		selectionSortMax(test);
		hdR.mtd.displayArray(test, 10);
	}
	public static int[] selectionSortMax(int[] array) {
		int temp = 0;
		int maxIndex = array.length - 1;

		while (maxIndex > 0) {
			for (int i = maxIndex; i >= 0; i--) {
				if (array[i] > array[maxIndex]) {
					temp = array[maxIndex];
					array[maxIndex] = array[i];
					array[i] = temp;
				}
			}
			maxIndex--;
		}
		
		return array;
	}

}
