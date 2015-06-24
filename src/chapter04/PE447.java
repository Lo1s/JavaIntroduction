package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE447 {

	/**
	 * 
	 */
	public PE447() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println("Enter ten numbers: ");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();
		double number4 = input.nextDouble();
		double number5 = input.nextDouble();
		double number6 = input.nextDouble();
		double number7 = input.nextDouble();
		double number8 = input.nextDouble();
		double number9 = input.nextDouble();
		double number10 = input.nextDouble();
		
		double sumOfNumbers = (number1 + number2 + number3 + number4 + number5 + number6 + number7 + number8 + number9 + number10);
		double sumOfPows = Math.pow(number1, 2) + Math.pow(number2, 2) + Math.pow(number3, 2) + Math.pow(number4, 2) + Math.pow(number5, 2) + Math.pow(number6, 2)
				+ Math.pow(number7, 2) + Math.pow(number8, 2) + Math.pow(number9, 2) + Math.pow(number10, 2);
		
		double mean = (sumOfNumbers) / 10;
		double deviation = Math.sqrt((sumOfPows - (Math.pow(sumOfNumbers, 2)/10))/(10 - 1));
		
		System.out.println("The mean is: " + mean);
		System.out.println("The standard deviation is: " + deviation);

	}

}
