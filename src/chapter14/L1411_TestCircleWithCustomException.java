/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 19. 8. 2014 2014 8:45:42 
 */
public class L1411_TestCircleWithCustomException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new CircleWithCustomException(5);
			new CircleWithCustomException(-5);
			new CircleWithCustomException(0);
		}
		catch (L1410_InvalidRadiusException ex) {
			System.out.println(ex);
		}
		
		System.out.println("Number of objects created: " + CircleWithCustomException.getNumberOfObjects());
	}

}

class CircleWithCustomException {
	private double radius;
	private static int numberOfObjects = 0;
	
	public CircleWithCustomException() throws L1410_InvalidRadiusException {
		this(1.0);
	}
	
	public CircleWithCustomException(double newRadius) throws L1410_InvalidRadiusException {
		setRadius(newRadius);
		numberOfObjects++;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double newRadius) throws L1410_InvalidRadiusException {
		if (newRadius >= 0)
			radius = newRadius;
		else
			throw new L1410_InvalidRadiusException(newRadius);
	}
	
	public static int getNumberOfObjects() {
		return numberOfObjects;
	}
	
	public double findArea() {
		return radius * radius * Math.PI;
	}
}
