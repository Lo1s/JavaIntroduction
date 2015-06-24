/**
 * 
 */
package chapter22;


import java.util.Comparator;

import chapter15.L1501_GeometricObject;
import chapter15.L1502_Circle;
import chapter15.L1503_Rectangle;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 15:50:54 
 */
public class L2205_TestComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1501_GeometricObject g1 = new L1503_Rectangle(5, 5);
		L1501_GeometricObject g2 = new L1502_Circle(5);
		
		L1501_GeometricObject g = max(g1, g2, new L2204_GeometricObjectComparator());
		
		System.out.println("The area of the larger object is " + g.getArea());
		System.out.println("The area of the smaller object is: " + (max(g1, g2, new L2204_GeometricObjectComparator()) == g1 ? g2.getArea() : g1.getArea()));
	}
	
	public static L1501_GeometricObject max(L1501_GeometricObject g1, L1501_GeometricObject g2, Comparator<L1501_GeometricObject> c) {
		if (c.compare(g1, g2) > 0)
			return g1;
		else
			return g2;
	}

}
