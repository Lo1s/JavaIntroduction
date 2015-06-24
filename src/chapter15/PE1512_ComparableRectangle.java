/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 5. 9. 2014 2014 15:28:18 
 */
public class PE1512_ComparableRectangle extends L1501_GeometricObject implements Comparable<PE1512_ComparableRectangle> {

	private double width;
	private double height;
	
	public PE1512_ComparableRectangle() {
		
	}
	
	public PE1512_ComparableRectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public PE1512_ComparableRectangle(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * (width + height);
	}
	
	@Override
	public boolean equals(Object o) {
		return getArea() == ((PE1512_ComparableRectangle)o).getArea();
	}
	
	@Override
	public int compareTo(PE1512_ComparableRectangle r) {
		if (this.getArea() > r.getArea())
			return 1;
		else if (this.getArea() < r.getArea())
			return -1;
		else
			return 0;
	}
	
}

