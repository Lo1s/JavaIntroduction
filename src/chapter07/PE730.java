/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE730 {

	/**
	 * 
	 */
	public PE730() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a00, a01, a10, a11 in that order: ");
		double[][] a = new double[2][2];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = input.nextDouble();
			}
		}
		System.out.println("Enter b0 & b1: ");
		double[] b = new double[2];
		b[0] = input.nextDouble();
		b[1] = input.nextDouble();

		double[] xy = linearEquation(a, b);

		if (xy[0] != 0 && xy[1] != 0)
			System.out.println("x is " + xy[0] + " and y is " + xy[1]);
		else
			System.out.println("The equation has no solution");
	}
	// Method for computing the linear equation
	public static double[] linearEquation(double[][] a, double[] b) {
		double denominator = a[0][0] * a[1][1] - a[0][1] * a[1][0];
		double[] linearEquation = new double[2];
		if (denominator == 0)
			return linearEquation;
		else {
			linearEquation[0] = (b[0] * a[1][1] - b[1] * a[0][1]) / denominator;
			linearEquation[1] = (b[1] * a[0][0] - b[0] * a[1][0]) / denominator;
		}
		return linearEquation;
	}

}
