/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.geometry.Point2D;

/**
 * @author jslapnicka
 * @Date & @Time 29. 1. 2015 2015 12:34:24 
 */
public class PE2409_GiftWrappingForConvexHull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("How many points are in the set ? ");
		int numberOfPoints = input.nextInt();
		System.out.print("Enter " + numberOfPoints + " points: ");
		double[][] s = new double[numberOfPoints][2];
		for (int i = 0; i < s.length; i++) {
			s[i][0] = input.nextDouble();
			s[i][1] = input.nextDouble();
		}
		ArrayList<Point2D> convexHull = getConvexHull(s);
		System.out.println("The convex hull is:");
		for (int i = 0; i < convexHull.size(); i++) {
			System.out.println("(" + convexHull.get(i) + ")");
		}
		input.close();
	}

	/*How many points are in the set? 6
			Enter 6 points: 1 2,4 2,5 2 1,5 34,5 5,5 6 6 2,4 5,5 9
			The convex hull is
			(1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)*/

	public static ArrayList<Point2D> getConvexHull(double[][] s) {
		ArrayList<Point2D> convexHull = new ArrayList<Point2D>();

		// Find the rightmost lowest point
		Point2D h0 = new Point2D(s[0][0], s[0][1]);
		for (int i = 0; i < s.length; i++) {
			if (h0.getY() < s[i][1]) {
				h0 = new Point2D(s[i][0], s[i][1]);
			} else if (h0.getY() == s[i][1] && h0.getX() < s[i][0])
				h0 = new Point2D(s[i][0], s[i][1]);
		}
		convexHull.add(h0);
		Point2D t0 = h0;
		// Find t1 to form the first line
		do {
			Point2D t1 = new Point2D(s[0][0], s[0][1]);
			for (int i = 1; i < s.length; i++) {
				double side = whichSide(t0.getX(), t0.getY(), t1.getX(), t1.getY(), s[i][0], s[i][1]);
				if (side > 0.0D) {
					t1 = new Point2D(s[i][0], s[i][1]);
				} else if (side == 0.0D && distance(s[i][0], s[i][1], t0.getX(), t0.getY()) > distance(t1.getX(), t1.getY(), t0.getX(), t0.getY())) {
					t1 = new Point2D(s[i][0], s[i][1]);
				}
			}
			
			if (t1.getX() != h0.getX() || t1.getY() != h0.getY()) {
				convexHull.add(t1);
				t0 = t1;
			} else {
				return convexHull;
			}
			
		} while (true);
	}




	public static double whichSide(double x0, double y0, double x1, double y1, double x2, double y2) {
		return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}
