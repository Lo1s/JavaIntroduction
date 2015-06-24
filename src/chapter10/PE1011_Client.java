/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 18:09:06 
 */
public class PE1011_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1011_Circle2D c1 = new PE1011_Circle2D(2, 2, 5.5);
		System.out.println("Area: " + c1.getArea());
		System.out.println("Perimeter " + c1.getPerimeter());
		System.out.println("Contains points: " + c1.contains(3, 3));
		System.out.println("Contains circle: " + c1.contains(new PE1011_Circle2D(4, 5, 10.5)));
		System.out.println("Overlaps: " + c1.overlaps(new PE1011_Circle2D(3, 5, 2.3)));
		
	}

}
