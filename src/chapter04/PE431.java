package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE431 {

	/**
	 * 
	 */
	public PE431() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the initial deposit amount: ");
		double amount = input.nextDouble();
		System.out.print("Enter annual percentage yield: ");
		double yieldPercentage = input.nextDouble();
		System.out.print("Enter maturity period (number of months): ");
		System.out.println();
		int numberOfMonths = input.nextInt();
		
		double cdValue = 0;
		double yield = yieldPercentage / 1200;
		
		System.out.println("Month" + "\tCD Value");
		
		for (int i = 1; i <= numberOfMonths; i ++) {
			cdValue = amount + amount * yield;
			System.out.printf("%1d\t%5.2f\n", i, cdValue);
			amount = cdValue;
			
		}

	}

}
