/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 18:08:52 
 */
public class PE1011_Circle2D {
	private double x;
	private double y;
	private double radius;

	public PE1011_Circle2D() {
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}

	public PE1011_Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	public double getPerimeter() {
		return Math.PI * this.radius * 2;
	}

	public boolean contains(double x, double y)
	{
		double d = distance(x, y, this.x, this.y);
		return d <= radius;
	}

	public boolean contains(PE1011_Circle2D circle)
	{
		double d = distance(x, y, circle.x, circle.y);
		return d + circle.radius <= radius;
	}

	public boolean overlaps(PE1011_Circle2D circle)
	{
		return distance(x, y, circle.x, circle.y) <= radius + circle.radius;
	}

	private static double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}
