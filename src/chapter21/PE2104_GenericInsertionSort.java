/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 13:13:27 
 */
public class PE2104_GenericInsertionSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] testArray = {2, 8, 1, 5, 6};
		insertionSort(testArray);
		for (int i = 0; i < testArray.length; i++)
			System.out.print(testArray[i] + " ");
	}

	public static <E extends Comparable<E>> void insertionSort(E[] list) {
		for (int i = 1; i < list.length; i++) {
			// Insert list[i] into a sorted sublist list[0..i-1] so that list[0..i] is sorted
			E currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--) {
				list[k + 1] = list[k];
			}
			// Insert the current element into list[k + 1]
			list[k + 1] = currentElement;
		}
	}
}
