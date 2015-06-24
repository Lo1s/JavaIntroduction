/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE519 {

	/**
	 * 
	 */
	public PE519() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first side of the triangle: ");
		int side1 = input.nextInt();
		System.out.print("Enter second side of the triangle: ");
		int side2 = input.nextInt();
		System.out.print("Enter third side of the triangle: ");
		int side3 = input.nextInt();
		
		System.out.println("The dimensions of the triangle are valid: " + isValid(side1, side2, side3));
		System.out.println("The area of the triangle is: " + area(side1, side2, side3));

	}
	public static boolean isValid(double side1, double side2, double side3) {
		if ((side1 + side2) >= side3 && (side1 + side3) >= side2 && (side2 + side3) >= side1)
			return true;
		else
			return false;
	}
	public static double area(double side1, double side2, double side3) {
		  double s = (side1 + side2 + side3) / 2D;
		  double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		  return area;
	}

}
