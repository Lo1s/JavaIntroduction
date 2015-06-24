/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE536 {

	/**
	 * 
	 */
	public PE536() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of side: ");
		int numberOfSides = input.nextInt();
		System.out.print("Enter the side: ");
		double side = input.nextDouble();
		
		System.out.print("The area of the polygon is: " + polygonArea(numberOfSides, side));

	}
	public static double polygonArea(int numberOfSides, double side) {
		double area = (numberOfSides * Math.pow(side, 2)) / (4 * Math.tan(Math.PI/numberOfSides));
		return area;
	}

}
