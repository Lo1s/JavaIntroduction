/**
 * 
 */
package chapter01;

/**
 * @author Jura
 *
 */
public class PE112 {

	/**
	 * 
	 */
	public PE112() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double miles = 24.0;
		double kilometers = miles * 1.6;
		double averageSpeedInMiles = (miles / 100.0) * 60.0;
		double averageSpeedInKilometers = averageSpeedInMiles * 1.6;
		
		System.out.println("The average speed of the runner for 24 miles is: " + averageSpeedInMiles + " MPH.");
		System.out.println("The average speed of the runner for " + kilometers + " is: " + averageSpeedInKilometers + " KMH.");
		

	}

}
