/**
 * 
 */
package chapter05;

/**
 * @author Jura
 *
 */
public class PE520 {

	/**
	 * 
	 */
	public PE520() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Degree          Sin          Cos");
		System.out.println("_________________________________");
		for (int degree = 0; degree <= 360; degree += 10) {
			System.out.printf("%3d", degree);
			getSinCos(degree);
		}
	
	}
	public static void getSinCos(int degree) {
		System.out.printf("%17.4f%13.4f", Math.sin(degree * Math.PI / 180), Math.cos(degree * Math.PI /180));
		System.out.println();
	}
	

}
