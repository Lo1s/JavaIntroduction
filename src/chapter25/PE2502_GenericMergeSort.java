/**
 * 
 */
package chapter25;

import java.util.Comparator;

/**
 * @author jslapnicka
 * @Date & @Time 17. 6. 2015 2015 9:17:08 
 */
public class PE2502_GenericMergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list1 = new Integer[]{2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		System.out.print("Before mergeSort(Comparable): ");
		displayArray(list1);
		mergeSort(list1);
		System.out.print("After mergeSort(Comparable): ");
		displayArray(list1);
		Integer[] list2 = new Integer[]{3, 4, 3, 6, 7, 2, -3, 4, 15, 13};
		System.out.print("Before mergeSort(Comparator): "); 
		displayArray(list2);
		mergeSort(list2, new PE2501_Comparator<Integer>());
		System.out.print("After mergeSort(Comparator): ");
		displayArray(list2);
		
	}
	
	public static void displayArray(Integer[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]);
			if (i < list.length - 1)
				System.out.print(", ");
			else
				System.out.println();
		}
	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		if (list.length > 1) {
			// Merge sort the first half
			@SuppressWarnings("unchecked")
			E[] firstHalf = (E[])new Comparable[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, firstHalf.length);
			mergeSort(firstHalf);
			
			// Merge sort the second part
			@SuppressWarnings("unchecked")
			E[] secondHalf = (E[])new Comparable[list.length - list.length / 2];
			System.arraycopy(list, firstHalf.length, secondHalf, 0, secondHalf.length);
			mergeSort(secondHalf);
			
			// Merge firstHalf and secondHalf into the list
			merge2(firstHalf, secondHalf, list);
		}
	}
	
	public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
		if (list.length > 1) {
			// Merge sort the first half
			@SuppressWarnings("unchecked")
			E[] firstHalf = (E[])new Object[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, firstHalf.length);
			mergeSort(firstHalf, comparator);
			
			// Merge sort the second half
			@SuppressWarnings("unchecked")
			E[] secondHalf = (E[])new Object[list.length - list.length /2];
			System.arraycopy(list, firstHalf.length, secondHalf, 0, secondHalf.length);
			mergeSort(secondHalf, comparator);
			
			// Merge firstHalf and secondHalf into the list
			merge1(firstHalf, secondHalf, list, comparator);
		}
	}
	
	public static <E> E[] merge1(E[] list1, E[] list2, E[] temp, Comparator<? super E> comparator) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		
		while (current1 < list1.length && current2 < list2.length) {
			if (comparator.compare(list1[current1], list2[current2]) < 0) {
				temp[current3++] = list1[current1++];
			} else {
				temp[current3++] = list2[current2++];
			}
		}
		
		while (current1 < list1.length) {
			temp[current3++] = list1[current1++];
		}
		
		while (current2 < list2.length) {
			temp[current3++] = list2[current2++];
		}
		
		return temp;
	}
	
	public static <E extends Comparable<E>> E[] merge2(E[] list1, E[] list2, E[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		
		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1].compareTo(list2[current2]) < 0) {
				temp[current3++] = list1[current1++];
			} else {
				temp[current3++] = list2[current2++];
			}
		}
		
		while (current1 < list1.length) {
			temp[current3++] = list1[current1++];
		}
		
		while (current2 < list2.length) {
			temp[current3++] = list2[current2++];
		}
		
		return temp;
	}
}
