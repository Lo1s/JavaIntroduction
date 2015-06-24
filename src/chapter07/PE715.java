/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE715 {

	/**
	 * 
	 */
	public PE715() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter five points: ");
		double[][] points = new double[5][2];
		for (int i = 0; i < points.length; i++) {
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
		}
		if (sameLine(points))
			System.out.println("The five points are on the same line.");
		else
			System.out.println("The five points are not on the same line.");
		
	}
	public static boolean sameLine(double[][] points) {
		return Math.abs((points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) - (points[2][0] - points[0][0]) * (points[1][1] - points[0][1])) < 1.0000000000000001E-009D;
	}
}
