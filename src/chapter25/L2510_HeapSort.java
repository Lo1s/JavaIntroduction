/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 25. 2. 2015 2015 17:11:03 
 */
public class L2510_HeapSort {

	/**
	 * @param args
	 */
	
	/** Heap sort method */
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		// Create a heap of integers
		L2509_Heap<E> heap = new L2509_Heap<E>();
		
		// Add elements to the heap
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}
		
		// Remove elements from the heap
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}
	
	/** A test method */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		heapSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

}
