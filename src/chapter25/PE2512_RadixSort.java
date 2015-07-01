/**
 * 
 */
package chapter25;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 29. 6. 2015 2015 11:02:16 
 */
public class PE2512_RadixSort<E extends Comparable<E>> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[]{331, 454, 230, 34, 343, 45, 59, 453, 345, 231, 9};
		displayArray(test, "Before sort");
		radixSort(test, 3);
		displayArray(test, "After sort");
	}
	
	public static void displayArray(int[] array, String title) {
		System.out.print(title + ": ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			
			if (i < array.length - 1)
				System.out.print(", ");
		}
		System.out.println();
	}
	
	public static void radixSort(int[] list, int numberOfPositions) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets = new ArrayList[10];
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		for (int position = numberOfPositions; position > 0; position--) {
			for (int i = 0; i < buckets.length; i++) {
				buckets[i].clear();
			}
			
			for (int i = 0; i < list.length; i++) {
				int key = getKey(list[i], position, numberOfPositions);
				buckets[key].add(list[i]);
			}
			
			int pos = 0;
			for (int i = 0; i < buckets.length; i++) {
				for (int j = 0; j < buckets[i].size(); j++) {
					list[pos++] = buckets[i].get(j);
				}
			}
		}
		
		/*for (int i = 0; i < list.length; i++) {
			
			int position = 0;
			int key = getKey(list[i], position);
			
			if (buckets[key] == null)
				buckets[key] = new java.util.ArrayList<Integer>();
			
			buckets[key].add(list[i]);
		}	*/	
	}
	
	public static int getKey(int number, int position, int numberOfPositions) {
		if (position == numberOfPositions) {
			return (number % 10);
		} else
			return getKey((number / 10), ++position, numberOfPositions);
				
	}

}
