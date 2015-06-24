package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE427 {

	/**
	 * 
	 */
	public PE427() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2001;
		final int YEARS_PER_LINE = 11;
		while (year <= 2100) {
			int i = 1;
			while (i % YEARS_PER_LINE != 0 && year != 2101) {
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
					System.out.print(year + " ");
					i++;
				}
				year++;
				
		   }
			System.out.println();
		}

	}

}
