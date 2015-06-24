/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 16. 7. 2014 2014 12:58:17 
 */
public class PE1101_Triangle extends PE1101_GeometricObject {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	public PE1101_Triangle() {
		
	}
	
	public PE1101_Triangle(double side1, double side2, double side3) {
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
