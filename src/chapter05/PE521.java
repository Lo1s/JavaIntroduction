/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE521 {

	/**
	 * 
	 */
	public PE521() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the point 1 (latitude & longitude in degrees): ");
		double x1D = input.nextDouble();
		double y1D = input.nextDouble();
		System.out.print("Enter the point 2 (latitude & longitude in degrees): ");
		double x2D = input.nextDouble();
		double y2D = input.nextDouble();
		
		double x1 = Math.toRadians(x1D);
		double y1 = Math.toRadians(y1D);
		double x2 = Math.toRadians(x2D);
		double y2 = Math.toRadians(y2D);
		final double RADIUS = 6371.01;
		
		double distance = RADIUS * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		
		System.out.println("The distance between two points is: " + distance + " km");

	}

}
