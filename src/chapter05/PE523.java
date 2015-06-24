/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE523 {

	/**
	 * 
	 */
	public PE523() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		
		double a = distance(x2, y2, x3, y3);
		double b = distance(x1, y1, x3, y3);
		double c = distance(x1, y1, x2, y2);
		
		double angleA = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2.0 * b * c)));
		double angleB = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2.0 * a * c)));
		double angleC = Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2.0 * a * b)));
		
		System.out.print("The three angles are: ");
		System.out.print((double)Math.round(angleA * 100D) / 100D + ", ");
		System.out.print((double)Math.round(angleB * 100D) / 100D + ", ");
		System.out.print((double)Math.round(angleC * 100D) / 100D);

	}
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

}
