/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 23. 6. 2015 2015 10:23:22 
 */
public class PE2509_heapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		heapSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}
	
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		PE2509_GenericHeapComparator<E> heap = new PE2509_GenericHeapComparator<E>(list, new PE2501_Comparator<>());
		
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();
	}

}
