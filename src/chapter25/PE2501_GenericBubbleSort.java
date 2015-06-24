/**
 * 
 */
package chapter25;

import java.util.Comparator;

/**
 * @author jslapnicka
 * @Date & @Time 16. 6. 2015 2015 11:01:42 
 */
public class PE2501_GenericBubbleSort {


	public static void main(String[] args) {
		// TODO 
		Integer[] list = new Integer[]{2, 9, 5, 4, 8, 1};
		System.out.print("Before bubbleSort(Comparator): ");
		displayArray(list);
		bubbleSort(list, new PE2501_Comparator<Integer>());
		System.out.print("After bubbleSort(Comparator): ");
		displayArray(list);
		Integer[] list2 = new Integer[]{3, 8, 4, 2, 7, 1};
		System.out.print("Before bubbleSort(Comparable): ");
		displayArray(list2);
		bubbleSort(list2);
		System.out.print("After bubbleSort(Comparable): ");
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
	
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
		boolean needNextPass = true;
		for (int k = 1; k < list.length && needNextPass; k++) {
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (list[i].compareTo(list[i + 1]) > 0) {
					E temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true;
				}
			}
		}
	}
	
	public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		boolean needNextPass = true;
		for (int k = 1; needNextPass && k < list.length; k++) {
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (comparator.compare(list[i], list[i + 1]) > 0) {
					E temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true;
				}
			}
		}
	}
	
}

