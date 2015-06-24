/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 *
 */
public class L810 {

	/**  Main method */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a circle with radius 5.0
		L809 myCircle = new L809(5.0);
		System.out.println("The area of the circle of radius " + myCircle.getRadius() + " is " + myCircle.getArea());
		
		// Increase myCircle's radius by 10%
		myCircle.setRadius(myCircle.getRadius() * 1.1);
		System.out.println("The area of the circle of radius " + myCircle.getRadius() + " is " + myCircle.getArea());
		
		System.out.println("The number of objects created is " + L809.getNumberOfObjects());
	}

}
