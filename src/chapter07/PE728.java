/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE728 {

	/**
	 * 
	 */
	public PE728() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test1 = {{51, 22, 25},{6, 1, 4},{24, 54, 6}};
		int[][] test2 = {{51, 22, 25},{6, 1, 4},{24, 54, 6}};
		
		System.out.println(strictlyIdentical(test1, test2) ? "Arrays are identical !" : "Arrays are not identical !");
	}
	public static boolean strictlyIdentical(int[][] array1, int[][] array2) {
		for (int row = 0; row < array1.length; row++) {
			for (int column = 0; column < array1[row].length; column++) {
				if (array1[row][column] != array2[row][column])
					return false;
			}
		}
		return true;
	}
}
