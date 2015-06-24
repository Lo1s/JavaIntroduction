/**
 * 
 */
package chapter22;

import java.io.Serializable;
import java.util.Comparator;

import chapter15.L1501_GeometricObject;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 15:42:46 
 */
@SuppressWarnings("serial")
public class L2204_GeometricObjectComparator implements Comparator<L1501_GeometricObject>, Serializable {
	
	public int compare(L1501_GeometricObject o1, L1501_GeometricObject o2) {
		double area1 = o1.getArea();
		double area2 = o2.getArea();
		
		if (area1 < area2)
			return -1;
		else if (area1 == area2)
			return 0;
		else
			return 1;
	}
}
