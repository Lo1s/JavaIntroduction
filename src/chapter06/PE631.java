/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE631 {

	/**
	 * 
	 */
	public PE631() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list1 = {1, 5, 16, 61, 111};
		int[] list2	= {2, 4, 5, 6, 0, 1011, 244, 471};

		System.out.print("The merged list is: " );
		hdR.mtd.displayArray(merge(list1, list2), 20);
	}
	public static int[] merge(int[] array1, int[] array2) {
		int[] result = new int[array1.length + array2.length];
		for (int i = 0; i < result.length; i++) {
			if (i < array1.length)
			result[i] = array1[i];
			if ((i + array1.length) < result.length)
				result[i + array1.length] = array2[i];
		}
		java.util.Arrays.sort(result);
		return result;
	}

}
