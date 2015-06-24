/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 23. 2. 2015 2015 8:06:26 
 */
public class L2501_InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1, 9, 4, 6, 5, -4};
		insertionSort(test);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}
	
	public static void insertionSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0...i-1] so that list[0...i] is sorted */
			int currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}
			
			// Insert the current element into list[k + 1];
			list [k + 1] = currentElement;
		}
	}

}
