/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 23. 6. 2015 2015 8:28:30 
 */
public class PE2507_MinHeapSort {


	/**
	 * @param args
	 */
	
	/** Heap sort method */
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		// Create a heap of integers
		PE2507_MinHeap<E> heap = new PE2507_MinHeap<E>();
		
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
		Integer[] list = {-5, 5, 0, 2, 1, 3};
		heapSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

}
