/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 18. 8. 2014 2014 15:56:12 
 */
public class L1407_CircleWithException {

	/** The radius of the circle */
	private double radius = 1;

	/** The number of objects created */
	private static int numberOfObjects = 0;

	/** Construct a circle with a radius = 1 */
	public L1407_CircleWithException() {
		// TODO Auto-generated constructor stub
		numberOfObjects++;
	}

	/** Construct a circle with a specified radius */
	public L1407_CircleWithException(double newRadius) {
		setRadius(newRadius);
		numberOfObjects++;
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double newRadius) throws IllegalArgumentException {
		if (newRadius >= 0)
			radius = (newRadius >= 0) ? newRadius : 0;
		else
			throw new IllegalArgumentException("Radius cannot be negative");
	}

	/** Return number of objects */
	public static int getNumberOfObjects() {
		return numberOfObjects;
	}

	/** Return the area of this circle */
	public double getArea() {
		return radius * radius * Math.PI;
	}
}
