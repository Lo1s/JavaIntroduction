/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 19. 8. 2014 2014 8:41:23 
 */
public class L1410_InvalidRadiusException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double radius;
	
	/** Construct an exception */
	public L1410_InvalidRadiusException(double radius) {
		super("Invalid radius " + radius);
		this.radius = radius;
	}
	
	/** Return the radius */
	public double getRadius() {
		return radius;
	}
}
