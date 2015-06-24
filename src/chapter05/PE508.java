/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE508 {

	/**
	 * 
	 */
	public PE508() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Celsius            Fahrenheit            |            Fahrenheit            Celsius");
		System.out.println("___________________________________________________________________________________");
		
		double celsius = 40;
		double fahrenheit = 120;
		
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%5.1f%20.1f%17s%20.1f%20.2f\n", celsius, hdR.mtd.celsiusToFahrenheit(celsius), "|", fahrenheit, hdR.mtd.fahrenheitToCelsius(fahrenheit));
			celsius -= 1;
			fahrenheit -= 10;

		}

	}

}
