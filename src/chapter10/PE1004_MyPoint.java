/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 8:35:08 
 */
public class PE1004_MyPoint {
	private double x;
	private double y;

	public PE1004_MyPoint() {
		// TODO Auto-generated constructor stub
		this.x = 0;
		this.y = 0;
	}

	public PE1004_MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double distance(PE1004_MyPoint test) {
		return distance(this, test);
	}

	public static double distance(PE1004_MyPoint p1, PE1004_MyPoint p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
				* (p1.y - p2.y));
	}
}
