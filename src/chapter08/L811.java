/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 *
 */
public class L811 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a Circle object with radius 1
		L809 myCircle = new L809(1);
		
		// Print areas for radius 1, 2, 3, 4, and 5.
		int n = 5;
		printAreas(myCircle, n);
		
		// See myCircle.radius and times
		System.out.println("\n" + "Radius is " + myCircle.getRadius());
		System.out.println("n is " + n);
	}
	/** Print a table of areas for radius */
	public static void printAreas(L809 c, int times) {
		System.out.println("Radius \t\tArea");
		while (times >= 1) {
			System.out.println(c.getRadius() + "\t\t" + c.getArea());
			c.setRadius(c.getRadius() + 1);
			times--;
		}
	}
	

}
