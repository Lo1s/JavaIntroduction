/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE505 {

	/**
	 * 
	 */
	public PE505() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter three integers: ");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();
		
		System.out.println("The sorted order is: ");
		sortNumbers(num1, num2, num3);
	}
	
	public static void sortNumbers(double num1, double num2, double num3) {
		double sorted1 = 0;
		double sorted2 = 0;
		double sorted3 = 0;
		if (num1 < num2 && num1 < num3) {
			sorted1 = num1;
			if (num2 < num3) {
				sorted2 = num2;
				sorted3 = num3;
			} else {
				sorted3 = num2;
				sorted2 = num3;				
					
			}
		}
		if (num2 < num1 && num2 < num3) {
			num2 = sorted1;
			if (num1 < num3) {
				num1 = sorted2;
				sorted3 = num3;
			} else {
				sorted3 = num1;
				sorted2 = num3;
			}
		}
		if (num3 < num1 && num3 < num2) {
			sorted1 = num3;
			if (num1 < num2) {
				sorted2 = num1;
				sorted3 = num2;
			} else {
				sorted3 = num1;
				sorted2 = num2;
			}
		}
		System.out.print(sorted1 + ", " + sorted2 + ", " + sorted3);			
	}

}
