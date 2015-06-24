/**
 * 
 */
package chapter05;

/**
 * @author Jura
 *
 */
public class PE514 {

	/**
	 * 
	 */
	public PE514() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("  i" + "          " + "m(i)");
		System.out.println("_________________________");

		for (int i = 1; i <= 901; i = i + 100) {
			System.out.printf("%3d%15.4f", i, computeM(i));
			System.out.println();
		}
	}

	public static double computeM(int i) {
		double mI = 0;
		for (int j = 1; j <= i; j++ ) {
			mI += 4 * (Math.pow(-1D, j + 1)/(2 * j - 1));
		}
		return mI;

	}
}