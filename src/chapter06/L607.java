/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class L607 {

	/**
	 * 
	 */
	public L607() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
		
		System.out.println(binarySearch(list, 2));
		System.out.println(binarySearch(list, 11));
		System.out.println(binarySearch(list, 12));
		System.out.println(binarySearch(list, 1));
		System.out.println(binarySearch(list, 3));
	}

	public static int binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < array[mid])
				high = mid - 1;
			else if (key == array[mid])
				return mid;
			else if (key > array[mid])
				low = mid + 1;
		}

		return -low;
	}

}
