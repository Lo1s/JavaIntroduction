/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 23. 2. 2015 2015 9:22:14 
 */
public class L2506_MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}
	
	public static void mergeSort(int[] list) {
		// The method for sorting the numbers
		if (list.length > 1) {
			// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);
			
			// Merge the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			// Merge firstHalf and secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}
	
	/** Merge two sorted lists */
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
		
		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
		
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

}
