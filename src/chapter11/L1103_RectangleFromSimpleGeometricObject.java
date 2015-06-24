/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 12:22:06 
 */
public class L1103_RectangleFromSimpleGeometricObject extends
		L1101_SimpleGeometricObject {
	private double width;
	private double height;
	
	public L1103_RectangleFromSimpleGeometricObject() {
		
	}
	
	public L1103_RectangleFromSimpleGeometricObject(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public L1103_RectangleFromSimpleGeometricObject(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		isFilled(filled);
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

