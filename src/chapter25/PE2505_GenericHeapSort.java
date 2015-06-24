/**
 * 
 */
package chapter25;

import java.util.Comparator;

/**
 * @author jslapnicka
 * @Date & @Time 19. 6. 2015 2015 9:00:22 
 */
public class PE2505_GenericHeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list1 = new Integer[]{-4, 5, 10, -100, 20, -10};
		System.out.println("Before the heapSort(Comparable): ");
		System.out.println(displayArray(list1));
		heapSort(list1);
		System.out.println("After the heapSort(Comparable): ");
		System.out.println(displayArray(list1));
		
		Integer[] list2 = new Integer[]{123, 50, -200, 100, 5, 6, 9, 4, 10};
		System.out.println("Before the heapSort(Comparator): ");
		System.out.println(displayArray(list2));
		heapSort(list2, new PE2501_Comparator<Integer>());
		System.out.println("After the heapSort(Comparator): ");
		System.out.println(displayArray(list2));
	}
	
	public static String  displayArray(Integer[] array) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < array.length; i++) {
			builder.append(array[i]);
			if (i < (array.length - 1)) {
				builder.append(", ");
			}
		}
		return builder.append("]").toString();
	}
	
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		L2509_Heap<E> heap = new L2509_Heap<E>();
		
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}
		
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}
	
	public static <E extends Comparable<E>> void heapSort(E[] list, Comparator<? super E> comparator) {
		PE2505_HeapComparator<E> heap = new PE2505_HeapComparator<E>(comparator);
		
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}
		
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}

}
