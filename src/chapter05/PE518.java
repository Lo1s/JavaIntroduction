/**
 * 
 */
package chapter05;

/**
 * @author Jura
 *
 */
public class PE518 {

	/**
	 * 
	 */
	public PE518() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Number          SquareRoot");
		System.out.println("--------------------------");
		for (int number = 0; number <= 20; number++) {
			getSqrtRoot(number);
	}
	
	}
	public static void getSqrtRoot(int number) {
		double sqrtNumber = Math.sqrt(number);
		System.out.printf("%3d%20.4f", number, sqrtNumber);
		System.out.println();
	}
}
