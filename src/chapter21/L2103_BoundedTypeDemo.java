/**
 * 
 */
package chapter21;

import chapter15.L1501_GeometricObject;
import chapter15.L1502_Circle;
import chapter15.L1503_Rectangle;


/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 7:53:09 
 */
public class L2103_BoundedTypeDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1503_Rectangle rectangle = new L1503_Rectangle(2, 2);
		L1502_Circle circle = new L1502_Circle(2);
		
		System.out.println("Same area ? " + equalArea(rectangle, circle));
		System.out.println("circle: " + circle.getArea());
		System.out.println("rectangle: " + rectangle.getArea());
	}
	
	public static <E extends L1501_GeometricObject> boolean equalArea(E object1, E object2) {
		return object1.getArea() == object2.getArea();
	}
}
