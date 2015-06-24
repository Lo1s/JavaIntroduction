/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 5. 9. 2014 2014 14:46:49 
 */
public class PE1511_ComparableCircle extends L1501_GeometricObject implements Comparable<PE1511_ComparableCircle> {
	private double radius;

	public PE1511_ComparableCircle() {

	}

	public PE1511_ComparableCircle(double radius) {
		this.radius = radius;
	}

	public PE1511_ComparableCircle(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 	2 * radius * Math.PI;
	}

	public double getDiameter() {
		return this.radius * 2;
	}

	public void printCircle() {
		System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
	}
	
	@Override
	public int compareTo(PE1511_ComparableCircle c) {
		if (c.getArea() > this.getArea())
			return -1;
		else if (c.getArea() < this.getArea())
			return 1;
		else
			return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		return radius == ((PE1511_ComparableCircle)o).radius;
	}
}
