/**
 * 
 */
package chapter08;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 12. 6. 2014 2014 9:11:22 
 */
public class PE810 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * Prompts the user for the input values
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the values for a, b, c in that order: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		// Constructor
		QuadraticEquation qE = new QuadraticEquation(a, b, c);
		// Output
		if (qE.getDiscriminant() > 0)
			System.out.println("1st root: " + qE.getRoot1() +
					"2nd root: " + qE.getRoot2());
		else if (qE.getDiscriminant() == 0)
			System.out.println("One root: " + qE.getRoot1());
		else
			System.out.println("The equation has no roots.");
	}

}
class QuadraticEquation {
	// Data field
	private double a;
	private double b;
	private double c;

	// Constructors with methods
	QuadraticEquation(double newA, double newB, double newC) {
		a = newA;
		b = newB;
		c = newC;
	}

	/**
	 * @return the a
	 */
	public double getA() {
		return a;
	}

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}

	/**
	 * @return the c
	 */
	public double getC() {
		return c;
	}

	/** 
	 * Calculate the discriminant
	 */
	public double getDiscriminant() {
		return Math.pow(b, 2) - 4 * (a * c);
	}

	/**
	 * Calculate the roots
	 */
	public double getRoot1() {
		return (-b + Math.sqrt(Math.pow(b, 2) - 4 * (a * c))) / 2 * a;
	}
	public double getRoot2() {
		return (-b - Math.sqrt(Math.pow(b, 2) - 4 * (a * c))) / 2 * a;
	}
}
