package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE442 {

	/**
	 * 
	 */
	public PE442() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int salesAmount = 10001;
		double result8 = 0;
		double result10 = 0;
		double result12 = 0;
		int numberOfSales8 = 0;
		int numberOfSales10 = 0;
		int numberOfSales12 = 0;
		int i = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your savings goal: ");
		int goal = input.nextInt();
		
		for (;salesAmount != 0;) {
			if (salesAmount == 5000 && result8 < goal) {
				result8 += salesAmount * 0.08;
				numberOfSales8++;
				if (result8 == goal)
					salesAmount = 0;
			} 
						
			if (salesAmount == 10000 && result10 < goal) {
				result10 += salesAmount * 0.10;
				numberOfSales10++;
				if (result10 == goal)
					salesAmount = 5000;
			} 
						
			if (salesAmount > 10000) {
				for (i = 10000; result12 <= goal; i++ ) {
					result12 = i * 0.12;
				}
				numberOfSales12++;
				salesAmount = 10000;
			}
			
		}
		
		System.out.println(
				"For 8 percent commission it is neccessary to do " + numberOfSales8 + " number of sales !\n" +
				"For 10 percent commission it is neccessary to do " + numberOfSales10 + " number of sales !\n" +
				"For 12 percent commission it is neccessary to do " + numberOfSales12 + " number of sales at amount of " + i);
  }
}