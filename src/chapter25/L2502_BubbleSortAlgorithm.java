/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 23. 2. 2015 2015 8:48:59 
 */
public class L2502_BubbleSortAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {2, 9, 5, 4, 8, 1};
		bubbleSort(test);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}
	
	public static void bubbleSort(int[] list) {
		for (int k = 1; k < list.length; k++) {
			// Perform the kth pass
			for (int i = 0; i < list.length - k; i++) {
				if (list[i] > list[i + 1]) {
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}

}
