/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 20. 11. 2014 2014 14:52:51 
 */
public class L2006_RecursiveBinarySearchMethod {

	public static int recursiveBinarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		return recursiveBinarySearch(list, key, low, high);
	}
	
	public static int recursiveBinarySearch(int[] list, int key, int low, int high) {
		if (low > high) // The list has been exhausted without a match
			return -low -1;
		int mid = (low + high) / 2;
		if (key < list[mid])
			return recursiveBinarySearch(list, key, low, mid - 1);
		else if (key == list[mid])
			return mid;
		else
			return recursiveBinarySearch(list, key, mid + 1, high);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[]{1, 5, 65, 1337, 2000, 5432, 65123};
		int key = 1337;
		
		System.out.println(recursiveBinarySearch(test, key));
	}

}
