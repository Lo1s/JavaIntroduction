/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE509 {

	/**
	 * 
	 */
	public PE509() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("  Feet            Meters            |            Meters            Feet");
		System.out.println("_________________________________________________________________________");
		
		double feet = 1;
		double meters = 20;
		
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%6.1f%17.3f%14s%17.1f%17.3f\n", feet, hdR.mtd.feetToMeters(feet), "|", meters, hdR.mtd.metersToFeet(meters));
			feet += 1;
			meters += 5;

		}

	}

}
