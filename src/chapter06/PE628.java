/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE628 {

	/**
	 * 
	 */
	public PE628() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1 + i; j < numbers.length; j++) {
				System.out.println(numbers[i] + ", " + numbers[j]);
			}
		}
	}

}
