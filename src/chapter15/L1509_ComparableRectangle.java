/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 3. 9. 2014 2014 15:33:55 
 */
public class L1509_ComparableRectangle extends L1503_Rectangle implements Comparable<L1509_ComparableRectangle> {

	public L1509_ComparableRectangle(double width, double height) {
		super(width, height);
	}

	@Override
	public int compareTo(L1509_ComparableRectangle o) {
		if (getArea() > o.getArea())
			return 1;
		else if (getArea() < o.getArea())
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Width: " + getWidth() + " Height: " + getHeight() +
				" Area: " + getArea();
	}

}
