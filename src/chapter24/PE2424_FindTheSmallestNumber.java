/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jslapnicka
 * @Date & @Time 19. 2. 2015 2015 9:04:40 
 */
public class PE2424_FindTheSmallestNumber {

	public PE2424_FindTheSmallestNumber() {
		// TODO Auto-generated constructor stub
	}

	// Finds the smallest number in the sorted list using the divide and conquer algorithm
	public static int findSmallest(ArrayList<Integer> list) {
		return findSmallest(list, 0, list.size() - 1);
	}

	public static int findSmallest(ArrayList<Integer> list, int low, int high) {
		if (low == high)
			return list.get(low);
		else if (low + 1 == high)
			return Math.min(list.get(low), list.get(high));
		else {
			int mid = (high + low) / 2;
			return Math.min(findSmallest(list, low, mid - 1), findSmallest(list, mid, high));
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(178, 33, 4, 2, -3, 5));
		System.out.println("Smallest element in the list: " + findSmallest(list));
	}
}
