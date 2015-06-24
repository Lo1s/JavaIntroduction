/**
 * 
 */
package chapter23;

import java.util.Set;
import java.util.TreeSet;

import chapter15.L1501_GeometricObject;
import chapter15.L1502_Circle;
import chapter15.L1503_Rectangle;
import chapter22.L2204_GeometricObjectComparator;

/**
 * @author jslapnicka
 * @Date & @Time 19. 1. 2015 2015 8:52:08 
 */
public class L2305_TestTreeSetWithComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<L1501_GeometricObject> set = new TreeSet<L1501_GeometricObject>(new L2204_GeometricObjectComparator());
		
		set.add(new L1503_Rectangle(4, 5));
		set.add(new L1502_Circle(40));
		set.add(new L1502_Circle(40));
		set.add(new L1503_Rectangle(4, 1));
		
		System.out.println("A sorted set of geometric objects");
		for (L1501_GeometricObject object: set) {
			System.out.println("area = " + object.getArea());
		}
	}

}
