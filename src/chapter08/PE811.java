/**
 * 
 */
package chapter08;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 12. 6. 2014 2014 9:47:38 
 */
public class PE811 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the values for a, b, c, d, e and f in that order: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		
		LinearEquation lE = new LinearEquation(a, b, c, d, e, f);
		
		if (lE.isSolvable())
			System.out.println("X: " + lE.getX() +
					"\nY: " + lE.getY());
		else
			System.out.println("The equation has no solution.");
	}

}
class LinearEquation {
	// Data field
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	// Constructor 
	LinearEquation(double newA, double newB, double newC, double newD, double newE, double newF) {
		a = newA;
		b = newB;
		c = newC;
		d = newD;
		e = newE;
		f = newF;
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
	 * @return the d
	 */
	public double getD() {
		return d;
	}

	/**
	 * @return the e
	 */
	public double getE() {
		return e;
	}

	/**
	 * @return the f
	 */
	public double getF() {
		return f;
	}
	
	/**
	 * 
	 * @return true if equation is solvable
	 */
	public boolean isSolvable() {
		if (a * d - b * c !=0)
			return true;
		else
			return false;
	}
	
	/**
	 * @return solution
	 */
	public double getX() {
		return (e * d - b * f) / (a * d - b * c);  
	}
	
	public double getY() {
		return (a * f - e * c) / (a * d - b * c);
	}
	
}
