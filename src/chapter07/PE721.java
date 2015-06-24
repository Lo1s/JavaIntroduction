/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE721 {

	/**
	 * 
	 */
	public PE721() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of cities: ");
		int numberOfCities = input.nextInt();
		System.out.print("Enter the coordinates of the cities: ");
		double[][] coordinates = new double[numberOfCities][2];
		for (int i = 0; i < numberOfCities; i++) {
			coordinates[i][0] = input.nextDouble();
			coordinates[i][1] = input.nextDouble();
		}
		double[] coordinations = shortestDistance(coordinates);
		System.out.print("The central city is at (" + coordinations[0] + ", " + coordinations[1] + ")");
		
	}
	// Finds tthe city with the shortest distance to all inputed
	public static double[] shortestDistance(double[][] array) {
		double shortestDistance = 0;
		double[] result = new double[2];
		for (int i = 0; i < array.length; i++) {
			shortestDistance += distance(array[0][0], array[0][1], array[i][0], array[i][1]);
		}
		for (int city = 0; city < array.length; city++) {
			double distance = 0;	
			for (int i = 0; i < array.length; i++) {
				distance += distance(array[city][0], array[city][1], array[i][0], array[i][1]);
			}
			if (shortestDistance >= distance) {
				shortestDistance = distance;
				result[0] = array[city][0];
				result[1] = array[city][1];
			}
		}
		return result;
	}
	// Calculates the distance
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}
