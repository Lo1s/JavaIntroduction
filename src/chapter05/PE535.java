/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE535 {

	/**
	 * 
	 */
	public PE535() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the side: ");
		double side = input.nextDouble();
		
		double area = (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI/5));
		
		System.out.print("The area of the pentagon is: " + area);

	}

}
