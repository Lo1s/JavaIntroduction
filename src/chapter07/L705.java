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
public class L705 {

	/**
	 * 
	 */
	public L705() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(new File("L705-input.txt"));
		final int NUMBER_OF_DAYS = 10;
		final int NUMBER_OF_HOURS = 24;
		double[][][] data = new double[NUMBER_OF_DAYS][NUMBER_OF_HOURS][2];
		
		for (int i = 0; i < NUMBER_OF_DAYS * NUMBER_OF_HOURS; i++) {
			int day = input.nextInt();
			int hour = input.nextInt();
			double temperature = input.nextDouble();
			double humidity = input.nextDouble();
			data[day - 1][hour - 1][0] = temperature;
			data[day - 1][hour - 1][1] = humidity;
		}
		
		// Calculates the average temp and humidity
		double[] averageTemp = new double[NUMBER_OF_DAYS];
		double[] averageHumidity = new double[NUMBER_OF_DAYS];
		for (int day = 0; day < NUMBER_OF_DAYS; day++) {
			double totalTemp = 0;
			double totalHumidity = 0;
			for (int hour = 0; hour < NUMBER_OF_HOURS; hour++) {
				totalTemp += data[day][hour][0];
				totalHumidity += data[day][hour][1];
			}
			averageTemp[day] = totalTemp / NUMBER_OF_HOURS;
			averageHumidity[day] = totalHumidity / NUMBER_OF_HOURS;
		}
		
		// Displays the average for certain days
		System.out.println("                   Temperature             Humidity");
		for (int day = 0; day < NUMBER_OF_DAYS ; day++) {
			System.out.println((day + 1) + ". day average: " + averageTemp[day] + "        " + averageHumidity[day]);
		}
	}

}
