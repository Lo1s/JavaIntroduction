/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE718 {

	/**
	 * 
	 */
	public PE718() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
		shuffle(test);
		hdR.mtd.displayArray2dim(test);
	}
	// Shuffle the rows in two dimensional array
	public static void shuffle(int[][] array) {
		int[] temp = array[0];
		for (int i = 0; i < array.length; i++) {
			int randomIndex = hdR.mtd.getRandomNumber(0, array.length - 1);
			temp = array[randomIndex];
			array[randomIndex] = array[i];
			array[i] = temp;
		}
	}

}
