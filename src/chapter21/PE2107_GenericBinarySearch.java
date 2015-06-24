/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 7:42:07 
 */
public class PE2107_GenericBinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] testInt = {1, 6, 13, 1337, 2000, 15000};
		System.out.println("index of 1337: " + binarySearch(testInt, 15000));
	}

	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		int low = 0;
		int high = list.length - 1;
		
		while (high >= low) {
			int mid = (low + high) / 2;
			if (list[mid].compareTo(key) < 0) {
				low = mid + 1;
			} else if (list[mid].compareTo(key) > 0) {
				high = mid - 1;
			} else if (list[mid].compareTo(key) == 0)
				return mid;
		}
		return -1 * low;
	}

}
