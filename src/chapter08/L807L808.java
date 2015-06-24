/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 *
 */
public class L807L808 {
	/** Radius of the circle - instance variable */
	double radius;
	
	/** The number of objects created */
	static int numberOfObjects = 0;
	
	/** Construct a circle with radius 1 (no-arg construct) */
	L807L808() {
		radius = 1;
		numberOfObjects++;
	}
	
	/** Construct a circle with a specified radius */
	L807L808(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}
	
	/** return numberOfObjects */
	static int getNumberOfObjects() {
		return numberOfObjects;
	}
	
	/** Return the area of this circle */
	double getArea() {
		return radius * radius * Math.PI;
	}
	
	/** Client of the L807 class */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Before creating objects");
		System.out.println("The number of Circle objects is " + L807L808.numberOfObjects);
		
		// Create c1
		L807L808 c1 = new L807L808();
		
		// Display c1 BEFORE c2 is created
		System.out.println("\nAfter creating c1");
		System.out.println("c1: radius (" + c1.radius + ") and number of Circle objects (" + L807L808.numberOfObjects + ")");
		
		// Create c2
		L807L808 c2 = new L807L808(5);
		
		// Modify the c1
		c1.radius = 9;
		
		// Display c1 and c2 AFTER c2 was created
		System.out.println("\nAfter creating c2 and modifying c1");
		System.out.println("c1: radius (" + c1.radius + ") and number of Circle objects (" + L807L808.numberOfObjects + ")");
		System.out.println("c2: radius (" + c2.radius + ") and number of Circle objects (" + L807L808.numberOfObjects + ")");
	}

}
