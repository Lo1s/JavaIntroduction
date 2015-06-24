/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 5. 9. 2014 2014 13:04:19 
 */
public class PE1507_Circle extends PE1507_GeometricObjectComparable {

private double radius;
	
	public PE1507_Circle() {
		
	}
	
	public PE1507_Circle(double radius) {
		this.radius = radius;
	}
	
	public PE1507_Circle(double radius, String color, boolean filled) {
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
