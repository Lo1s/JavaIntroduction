/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE632 {

	/**
	 * 
	 */
	public PE632() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {10, 1, 5, 16, 61, 9, 11, 1};

		System.out.print("After the partition, the list is: ");
		hdR.mtd.displayArray(partition(list), 25);
	}
	public static int[] partition(int[] list) {
		int[] result = new int[list.length];
		int pivot = list[0];
		int j = 0;
		for (int i = 1; i < list.length; i++) {
			if (list[i] < pivot) {
				result[j] = list[i];
				j++;
			}
		}
		result[j] = pivot;
		j++;
		for (int k = 0; k < list.length; k++) {
			if (list[k] > pivot) {
				result[j] = list[k];
				j++;
			}
		}
		return result;
	}

}
