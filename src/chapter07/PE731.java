/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE731 {

	/**
	 * 
	 */
	public PE731() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter coordinations for the points x1, y1, x2, y2, x3, y3, x4, y4: ");
		double[][] coordinations = new double[4][2];
		for (int row = 0; row < coordinations.length; row++) {
			for (int column = 0; column < coordinations[row].length; column++) {
				coordinations[row][column] = input.nextDouble();
			}
		}
		double[] xy = getIntersectingPoint(coordinations);
		if (xy[0] > 0 && xy[1] > 0)
			System.out.println("The intersecting point is at: (" + xy[0] + ", " + xy[1] + ")");
		else
			System.out.println("Two lines are parallel");
		
	}
	public static double[] getIntersectingPoint(double[][] points) {
	    double[] getIntersectingPoint = new double[2];
		
		double a = (points[0][1] - points[1][1]);
	    double b = -(points[0][0] - points[1][0]);
	    double c = (points[2][1] - points[3][1]);
	    double d = -(points[2][0] - points[3][0]);
	    double e = (a * points[0][0] - (-b) * points[0][1]);
	    double f = (c * points[2][0] - (-d) * points[2][1]);
	    double denominator = a * d - b * c;
	   
	    getIntersectingPoint[0] = (e * d - b * f) / denominator;
	    getIntersectingPoint[1] = (a * f - e * c) / denominator;
	    
	    return getIntersectingPoint;
	}

}
