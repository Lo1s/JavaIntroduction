/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
public class PE406 {

	/**
	 * 
	 */
	public PE406() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double milesToKilometers = 1.609;
		double kilometersToMiles = 0.621;
		int kilometers = 20;
		
		System.out.println("Miles    Kilometers    |    Kilometers    Miles");
		for (int miles = 1; miles <= 10; miles++) {
			System.out.printf("%5d%11.3f%8s%9d%14.3f", miles, (milesToKilometers * miles), "|", kilometers, (kilometersToMiles * kilometers));
			System.out.println();
			kilometers += 5;
		}

	}

}
