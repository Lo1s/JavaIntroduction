/**
 * 
 */
package chapter07;
import java.util.Scanner;

/**
 * @author hydRa
 *
 */
public class L703 {

	/**
	 * 
	 */
	public L703() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of points: ");
		int numberOfPoints = input.nextInt();
		
		// Create an array to store the points
		double[][] points = new double[numberOfPoints][2];
		System.out.println("Enter " + numberOfPoints + " points: ");
		for (int row = 0; row < points.length; row++) {
			points[row][0] = input.nextDouble();
			points[row][1] = input.nextDouble();
		}
		
		int p1 = 0, p2 = 1;
		double shortestDistance = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
		
		// Compute the distance for every two points
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
				
				if (distance < shortestDistance) {
					p1 = i;
					p2 = j;
					shortestDistance = distance;
				}
			}
		}
		
		// Display result
		System.out.println("The closest two points are (" + points[p1][0] + ", " + points[p1][1] + ") and (" + points[p2][0] +
				", " + points[p2][1] + ")");
	}
	// Counts the distance between two points
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)); 
	}

}
