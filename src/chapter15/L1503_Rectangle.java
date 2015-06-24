/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 2. 9. 2014 2014 10:56:28 
 */
public class L1503_Rectangle extends L1501_GeometricObject {

	private double width;
	private double height;
	
	public L1503_Rectangle() {
		
	}
	
	public L1503_Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public L1503_Rectangle(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * (width + height);
	}
	
}

