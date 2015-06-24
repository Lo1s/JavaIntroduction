/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 12:34:47 
 */
public class PE1502_Triangle extends L1501_GeometricObject {

	private double side1;
	private double side2;
	private double side3;
	
	public PE1502_Triangle() {
		// TODO Auto-generated constructor stub
	}
	
	public PE1502_Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	@Override
	public double getArea() {
		double s = (side1 + side2 + side3) / 2D;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	@Override 
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
}
