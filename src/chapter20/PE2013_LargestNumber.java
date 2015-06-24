/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 13:11:57 
 */
public class PE2013_LargestNumber {

	public static int largestNumber(int[] array) {
		return largestNumber(array, 0, 0);
	}
	
	/** Auxiliary  method */
	public static int largestNumber(int[] array, int index, int max) {
		if (index > array.length - 1)
			return max;
		else if (array[index] > max)
			max = array[index];
		return largestNumber(array, ++index, max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] {2, 8, 3, 12, 20, 26, 7, 27};
		System.out.println(largestNumber(test));
	}

}
