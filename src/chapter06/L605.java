/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class L605 {

	/**
	 * 
	 */
	public L605() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMax(34, 3, 3, 5, 56.5);
		printMax(new double[]{1, 2, 3});
		}
	
	public static void printMax(double... numbers) {
		if (numbers.length == 0) {
			System.out.print("No arguments passed !");
			return;
		}
		
		double result = numbers[0];
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > result)
				result = numbers[i];
		}
		
		System.out.println("The max value is: " + result);
	}

}
