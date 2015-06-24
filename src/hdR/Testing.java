package hdR;

/**
 * @author jslapnicka
 *
 */

public class Testing {
	
	
	public static void main(String[] args) {
		int k = 39;
		int d = 5;
		int sum = 0;
		
		for (int i = 1; i <= 15; i++) {
			System.out.printf("%2d", i);
			int a = k - d * (i - 1);
			sum = sum + a;
			System.out.print(": " + a + ", ");
		}
		System.out.println("\nSum: " + sum);
	}
	
	public static void arithmeticSeries(int n) {
		
	}
}
