/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE630 {

	/**
	 * 
	 */
	public PE630() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {0, 1, 1, 1, 1, 1, 2};
		int items = 5;
		if (isConsecutive(test, 5))
			System.out.println("There is " + items + " or more consecutive numbers with the same value !");
		else
			System.out.println("There is not " + items + " or more consecutive numbers with the same value !");
	}
	public static boolean isConsecutive(int[] values, int numberOfItems) {
		int check = 1;
		for (int i = 0; i < values.length - 1 && check < numberOfItems; i++) {
			if(values[i] == values[i + 1]) {
				check++;
			} else
				check = 1;
		}
		if (check == numberOfItems)
			return true;
		else
			return false;
	}

}
