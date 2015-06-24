/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 23. 6. 2015 2015 9:13:22 
 */
public class PE2508_HeapSortComparable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = new Integer[]{0, 2, -5, 3, 2};
		displayArray(list);
		sort(list);
		displayArray(list);
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
	
	public static <E extends Comparable<E>> void sort(E[] list) {
		L2509_Heap<E> heap = new L2509_Heap<E>();
		
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}
		
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}

}
