/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE517 {

	/**
	 * 
	 */
	public PE517() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = input.nextInt();
		printMatrix(n);

	}
	public static void printMatrix(int n) {
		int number = hdR.mtd.getRandomNumber(0, 1);
		for (int c = 1; c <= n; c++) {
			for (int l = 1; l <= n; l++) {
				number = hdR.mtd.getRandomNumber(0, 1);
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}

}
