/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE716 {

	/**
	 * 
	 */
	public PE716() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}};
		sort(test);
		hdR.mtd.displayArray2dim(test);
	}
	// Sorts the two-dimensional array
	public static void sort(int[][] array) {
		int[] min = array[0];
		int minIndex = 0;
		int[] temp = new int[min.length];
		// Sorting by the first column
		while (minIndex < array.length - 1) {
			min = array[minIndex];
			for (int row = minIndex; row < array.length; row++) {
				if (array[row][0] < min[0]) {
					temp = array[row];
					array[row] = min;
					min = temp;
					array[minIndex] = temp;
				}
			}
			minIndex++;
		}
		minIndex = 0;
		while (minIndex < array.length - 1) {
			min = array[minIndex];
			for (int i = minIndex; i < array.length; i++) {
				if (min[0] == array[i][0]) {
					if (array[i][1] < min[1]) {
						temp = array[i];
						array[i] = min;
						min = temp;
						array[minIndex] = temp;
					}
				}
			}
			minIndex++;
		}
	}
}
