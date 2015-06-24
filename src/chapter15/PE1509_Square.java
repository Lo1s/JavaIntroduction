/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 5. 9. 2014 2014 13:56:25 
 */
public class PE1509_Square extends L1501_GeometricObject implements Colorable {
	private double side;
	
	public PE1509_Square() {
		// TODO Auto-generated constructor stub
	}
	
	public PE1509_Square(double side) {
		this.side = side;
	}
	
	public double getArea() {
		return Math.pow(side, 2);
	}
	
	public double getPerimeter() {
		return 4 * side;
	}
	
	public void howToColor() {
		System.out.println("Color all four sides.");
	}
}
