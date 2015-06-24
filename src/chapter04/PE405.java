/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
public class PE405 {

	/**
	 * 
	 */
	public PE405() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double kilogramsToPounds = 2.2;
		double poundsToKilograms = 0.453;
		int pounds = 20;
		
		System.out.println("Kilograms    Pounds    |    Pounds    Kilograms");
		for (int kilograms = 1; kilograms <= 199; kilograms += 2) {
			System.out.printf("%5d%13.1f%6s%8d%12.2f", kilograms, (kilogramsToPounds * kilograms), "|", pounds, (poundsToKilograms * pounds));
			System.out.println();
			pounds += 5;
		}

	}

}
