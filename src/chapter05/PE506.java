/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE506 {

	/**
	 * 
	 */
	public PE506() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of lines: ");
		int n = input.nextInt();
		displayPattern(n);
	}
	
	public static void displayPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= 1; j--) {
				if (j > i && j < 10)
					System.out.print("  ");
				if (j > i && j < 100 && j >= 10)
					System.out.print("   ");
				if (j > i && j < 1000 && j >= 100)
					System.out.println("    ");
				else if (j <= i && j >= 1 && j < 10)
					System.out.printf("%2d", j);
				else if (j <= i && j >= 1 && j < 100 && j >= 10)
					System.out.printf("%3d", j);
				else if (j <= i && j >= 1 && j < 1000 && j >= 100)
					System.out.printf("%4d", j);
			}
			System.out.println();
		}
	}

}
