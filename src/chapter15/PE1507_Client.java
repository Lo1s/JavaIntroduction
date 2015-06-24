/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 5. 9. 2014 2014 12:44:18 
 */
public class PE1507_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PE1507_Circle circle1 = new PE1507_Circle(5D);
        PE1507_Circle circle2 = new PE1507_Circle(4D);
        PE1507_Circle circle = (PE1507_Circle)PE1507_GeometricObjectComparable.max(circle1, circle2);
        System.out.println((new StringBuilder("The max circle's radius is ")).append(circle.getRadius()).toString());
        System.out.println(circle);
	}

}
