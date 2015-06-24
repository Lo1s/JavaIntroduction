/**
 * 
 */
package chapter25;

import java.util.Comparator;

/**
 * @author jslapnicka
 * @Date & @Time 17. 6. 2015 2015 11:03:45 
 */
public class PE2503_GenericQuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list1 = new Integer[]{2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		System.out.print("Before quickSort(Comparable): ");
		displayArray(list1);
		quickSort(list1);
		System.out.print("After quickSort(Comparable): ");
		displayArray(list1);
		Integer[] list2 = new Integer[]{3, 4, 3, 6, 7, 2, -3, 4, 15, 13};
		System.out.print("Before quickSort(Comparator): "); 
		displayArray(list2);
		quickSort(list2, new PE2501_Comparator<Integer>());
		System.out.print("After quickSort(Comparator): ");
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

	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	

	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, 0, list.length - 1, comparator);
	}
	
	public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
		if (last > first) {
			int pivotIndex = partition(list, first, last, comparator);
			quickSort(list, first, pivotIndex - 1, comparator);
			quickSort(list, pivotIndex + 1, last, comparator);
		}
	}
	
	public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
		E pivot = list[first];
		int low = first + 1;
		int high = last;
		
		while (high > low) {
			// Search forward from left
			while (low <= high && list[low].compareTo(pivot) <= 0) {
				low++;
			}
			// Search backwards from right
			while (low <= high && list[high].compareTo(pivot) > 0) {
				high--;
			}
			// Swap two elements in the list
			if (high > low) {
				E temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}
		
		while (high > first && list[high].compareTo(pivot) >= 0) {
			high--;
		}
		
		// Swap pivot with list[high]
		if (pivot.compareTo(list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}

	public static <E> int partition(E[] list, int first, int last,  Comparator<? super E> comparator) {
		E pivot = list[first];
		int low = first + 1;
		int high = last;

		while (high > low) {
			// Search forward from left
			while (low <= high && comparator.compare(list[low], pivot) <= 0) {
				low++;
			}
			// Search backwards from right
			while (low <= high && comparator.compare(list[high], pivot) > 0) {
				high--;
			}
			// Swap two elements in the list
			if (high > low) {
				E temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}

		while (high > first && comparator.compare(list[high], pivot) >= 0) {
			high--;
		}

		// Swap pivot with list[high]
		if (comparator.compare(pivot, list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}

}
