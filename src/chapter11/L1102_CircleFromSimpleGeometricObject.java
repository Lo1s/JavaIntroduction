/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 11:24:53 
 */
public class L1102_CircleFromSimpleGeometricObject extends
		L1101_SimpleGeometricObject {
	private double radius;
	
	public L1102_CircleFromSimpleGeometricObject() {
		
	}
	
	public L1102_CircleFromSimpleGeometricObject(double radius) {
		this.radius = radius;
	}
	
	public L1102_CircleFromSimpleGeometricObject(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		isFilled(filled);
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double getPerimeter() {
		return 	2 * radius * Math.PI;
	}
	
	public double getDiameter() {
		return this.radius * 2;
	}
	
	public void printCircle() {
		System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
	}
}
