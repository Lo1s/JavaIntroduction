/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE729 {

	/**
	 * 
	 */
	public PE729() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test1 = {{51, 22, 25},{6, 1, 4},{24, 54, 6}};
		int[][] test2 = {{51, 22, 25},{6, 1, 4},{24, 54, 6}};

		System.out.print(identical(test1, test2) ? "Arrays are identical !" : "Arrays are not identical !");
	}
	public static boolean identical(int[][] array1, int[][] array2) {
		// Find max and min value within the array
		int max = array1[0][0];
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++) {
				if (max < array1[i][j])
					max = array1[i][j];
			}
		}
		// Creates the counter of values in the array (occurrence of the value)
		int[] counter1 = new int[max + 1];
		int[] counter2 = new int[max + 1];
		for (int row = 0; row < array1.length; row++) {
			for (int column = 0; column < array1[row].length; column++) {
				counter1[array1[row][column]]++;
				counter2[array2[row][column]]++;
			}
		}
		// Occurrencde should be same
		for (int i = 0; i < counter1.length; i++) {
			if (counter1[i] != counter2[i])
				return false;
		}
		return true;
	}
}
