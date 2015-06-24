/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE619 {

	/**
	 * 
	 */
	public PE619() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1, 1, 3, 10, 100, 1000, 10000, 100000, 1000000, 10000050};

		if (isSorted(test))
			System.out.print("The array is sorted !");
		else
			System.out.print("The array is not sorted !");
	}

	public static boolean isSorted(int[] array) {
		boolean[] sorted = new boolean[array.length];
		boolean check = false;
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1 && array[i] <= array[i + 1])
				sorted[i] = true;
			else if (array[array.length - 2] <= array[array.length - 1]) {
				sorted[array.length - 2] = true;
				sorted[array.length - 1] = true;
				i++;
			} else 
				break;
		}

		for (int i = 0; i < sorted.length; i++) {
			if (sorted[i])
				check = true;
			else if (!sorted[i])
				return false;
		}

		if (check)
			return true;
		else
			return false;
	}

}
