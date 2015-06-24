/**
 * 
 */
package chapter07;

import java.util.Scanner;
import java.io.*;

/**
 * @author jslapnicka
 *
 */
public class PE708 {

	/**
	 * 
	 */
	public PE708() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(new File("PE708-input.txt"));
		
		// Create an array to store points
	    double[][] points = {{-1, 3}, {-1, -1}, {1, 1}, {0, 0.5},
	    	      {2, 0.5}, {2, -1}, {3, 3}, {4, 2}, {4, -0.5}, };
	    
	    // Second array for test
		double[][] points2 = new double[8][2];
		for (int i = 0; i < points2.length; i++) {
			points2[i][0] = input.nextDouble();
			points2[i][1] = input.nextDouble();
		}

		// p1 and p2 are the indices in the points array
		int p1 = 0, p2 = 1; // Initial two points
		double shortestDistance = distance(points[p1][0], points[p1][1], 
				points[p2][0], points[p2][1]); // Initialize shortestDistance

		// Compute distance for every two points
		double[] distance = new double[(points.length * (points.length - 1)) / 2];
		double[][] coordinates = new double[distance.length][4];
		int counter = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				distance[counter] = distance(points[i][0], points[i][1],
				          points[j][0], points[j][1]); // Find distance
				coordinates[counter][0] = points[i][0];
				coordinates[counter][1] = points[i][1];
				coordinates[counter][2] = points[j][0];
				coordinates[counter][3] = points[j][1];

				if (distance[counter] < shortestDistance) {
					shortestDistance = distance[counter];
				}
				counter++;
			}

		}
		
		// Display result
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == shortestDistance) {
				System.out.println("The closest two points are " +
						"(" + coordinates[i][0] + ", " + coordinates[i][1] + ") and (" +
						coordinates[i][2] + ", " + coordinates[i][3] + ") with the distance of: " + distance[i]);	
			}
		}

	}

	/** Compute the distance between two points (x1, y1) and (x2, y2)*/
	public static double distance(
			double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}
