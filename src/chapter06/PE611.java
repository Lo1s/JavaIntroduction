/**
 * 
 */
package chapter06;
/**
 * @author jslapnicka
 *
 */
public class PE611 {

	/**
	 * 
	 */
	public PE611() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] test = new double[10];
		hdR.mtd.createArray(test);
		
		System.out.printf("The mean is %4.2f\n", mean(test));
		System.out.printf("The standart deviation is: %4.5f \n", deviation(test));
	}
	
	public static double mean(double[] array) {
		double total = 0;
		
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		
		return total / array.length;
	}
	
	public static double deviation(double[] array) {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += Math.pow(array[i] - mean(array), 2);
		}
		return Math.sqrt(total / (array.length - 1));
	}

}
