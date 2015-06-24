/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 2. 9. 2014 2014 10:56:16 
 */
public class L1502_Circle extends L1501_GeometricObject {

private double radius;
	
	public L1502_Circle() {
		
	}
	
	public L1502_Circle(double radius) {
		this.radius = radius;
	}
	
	public L1502_Circle(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
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
