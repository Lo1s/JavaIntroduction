/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 *
 */
public class L801 {

	/**
	 * 
	 */
	public L801() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a circle with a radius 1
		SimpleCircle circle1 = new SimpleCircle();
		System.out.println("The area of the circle with the radius of " + circle1.radius + " is " + circle1.getArea());
		// Create a circle with a radius 25
		SimpleCircle circle2 = new SimpleCircle(25);
		System.out.println("The area of the circle with the radius of " + circle2.radius + " is " + circle2.getArea());
		// Create a circle with a radius 125
		SimpleCircle circle3 = new SimpleCircle(125);
		System.out.println("The area of the circle with the radius of " + circle3.radius + " is " + circle3.getArea());
		
		// Modify circle radius
		circle2.radius = 100; // or circle2.setRadius(100);
		System.out.println("The area of the circle with the radius of " + circle2.radius + " is " + circle2.getArea());
	}

}
// Define the circle class with two constructors
class SimpleCircle {
	double radius;
	/** Construct a circle with radius 1 */
	SimpleCircle() {	
		radius = 1;
	}
	/** Construct a circle with a specified radius */
	SimpleCircle(double newRadius) {
		radius = newRadius;
	}
	/** Return the area of this circle */
	double getArea() {
		return radius * radius * Math.PI;
	}
	/** Return the perimeter of the circle */
	double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	void setRadius (double newRadius) {
		radius = newRadius;
	}
}
