/**
 * 
 */
package chapter08;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 12. 6. 2014 2014 11:38:05 
 */
public class PE812 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Input for the coordinations
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the endpoints of the first line segment: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		System.out.println("Enter the endpoints of the second line segment: ");
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double x4 = input.nextDouble();
		double y4 = input.nextDouble();

		// Calc the variables
		double a = (y1 - y2);
		double b = -(x1 - x2);
		double c = (y3 - y4);
		double d = -(x3 - x4);
		double e = ((y1 - y2) * x1 - (x1 - x2) * y1);
		double f = ((y3 - y4) * x3 - (x3 - x4) * y3);

		LinearEquation intersection = new LinearEquation(a, b, c, d, e, f);

		System.out.println("The intersecting point is: (" + intersection.getX() + ", " + intersection.getY() + ")");
	}

}
