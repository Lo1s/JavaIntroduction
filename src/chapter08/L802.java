/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 *
 */
public class L802 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a circle with radius 1
		L802 circle1 = new L802();
		System.out.println("The area of the circle of the radius " + circle1.radius + " is " + circle1.getArea());
		// Create a circle with radius 25
		L802 circle2 = new L802(25);
		System.out.println("The area of the circle of the radius " + circle2.radius + " is " + circle2.getArea());
		// Create a circle with a radius 125
		L802 circle3 = new L802(125);
		System.out.println("The area of the circle of the radius " + circle3.radius + " is " + circle3.getArea());
		
		// Modify the radius
		circle2.radius = 100; // or circle2.setRadius(100);
		System.out.println("The area of the circle of the radius " + circle2.radius + " is " + circle2.getArea());
	}
	double radius;
	
	/** Construct a circle with radius 1 */
	L802() {
		radius = 1;
	}
	/** Construct a circle with a specified radius */
	L802(double newRadius) {
		radius = newRadius;
	}
	/** Return area of the circle */
	double getArea() {
		return radius * radius * Math.PI;
	}
	/** Return perimeter of the circle */
	double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	/** Set a new radius for a circle */
	void setRadius(double newRadius) {
		radius = newRadius;
	}
}

