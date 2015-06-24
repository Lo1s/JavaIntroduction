/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 11. 7. 2014 2014 14:32:41 
 */
public class PE1013_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1013_MyRectangle2D r1 = new PE1013_MyRectangle2D(2, 2, 5.5, 4.9);
		System.out.println("r1 area: " + r1.getArea());
		System.out.println("r1 perimeter: " + r1.getPerimeter());
		System.out.println("r1.contains(3, 3) ? " + r1.contains(3, 3));
		System.out.println("r1.contains(new PE1013_MyRectangle2D(4, 5, 10.5, 3.2) ? " + r1.contains(new PE1013_MyRectangle2D(4, 5, 10.5, 3.2)));
		System.out.println("r1.overlaps(new PE1013_MyRectangle2D(3, 5, 2.3, 5.4) ? " + r1.overlaps(new PE1013_MyRectangle2D(3, 5, 2.3, 5.4)));
	}

}
