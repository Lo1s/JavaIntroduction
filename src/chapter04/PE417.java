package chapter04;
/**
 * 
 */

/**
 * @author Jura
 *
 */
import java.util.Scanner;


public class PE417 {

	/**
	 * 
	 */
	public PE417() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of lines (1-15): ");
		int numberOfLines = input.nextInt();
		
		int m;
		for (int i = 1; i <= numberOfLines; i++) {
			int k = i;
			for (int j = numberOfLines; j >= 1; j--) {
				if (j > i) {
					System.out.print("    ");
				} else if (j == i || j < i) {
					System.out.printf("%4d", k);
				if (k > 1)
					k--;
				}
			}
			m = 2;
			for (int l = 1; l < i; l++) {
				if (m > 1 ) {
					System.out.printf("%4d", m);
					m++;
				} else {
						break;
					
				}
							}
			System.out.println();
		}

	}

}
