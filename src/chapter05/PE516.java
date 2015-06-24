/**
 * 
 */
package chapter05;

/**
 * @author Jura
 *
 */
public class PE516 {

	/**
	 * 
	 */
	public PE516() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int year = 2000; year <= 2020; year++) {
			System.out.println(year + ": " + numberOfDaysInAYear(year) + " days.");
		}

	}
	public static int numberOfDaysInAYear(int year) {
		int days = 0;
		if (hdR.mtd.isLeapYear(year))
			days = 366;
		else
			days = 365;
		return days;
	}

}
