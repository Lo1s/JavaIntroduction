/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 12:00:50 
 */
public class PE1405_IllegalTriangleException {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	public PE1405_IllegalTriangleException() {
		// TODO Auto-generated constructor stub
	}		
	
	public PE1405_IllegalTriangleException(double side1, double side2, double side3) throws IllegalTriangleException {
		if ((side1 + side2) < side3 || (side1 + side3) < side2 || (side2 + side3) < side1)
			throw new IllegalTriangleException();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	/**
	 * @return the side1
	 */
	public double getSide1() {
		return side1;
	}

	/**
	 * @return the side2
	 */
	public double getSide2() {
		return side2;
	}

	/**
	 * @return the side3
	 */
	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
		double s = (side1 + side2 + side3) / 2D;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 +
				" side3 = " + side3;
	}	
}

class IllegalTriangleException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalTriangleException() {
		System.out.println("The sum of the two sides is not greater than the third side !");		
	}
	
}
