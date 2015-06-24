/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 * @Date & @Time 10. 6. 2014 2014 9:21:10 
 */
public class PE801 {
	// Test the Rectangle(PE801) class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creates a first rectangle with specified width and height
		Rectangle rectangle1 = new Rectangle(4, 40);
		// Creates a second rectangle with specified width and height
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		
		System.out.println("Rectangle 1");
		System.out.println("Width: " + rectangle1.getWidth() + "\n"
				+ "Height: " + rectangle1.getHeight() + "\n"
				+ "Area: " + rectangle1.getArea() + "\n"
				+ "Perimeter: " + rectangle1.getPerimeter() + "\n");
		
		System.out.println("Rectangle 2");
		System.out.println("Width: " + rectangle2.getWidth() + "\n"
				+ "Height: " + rectangle2.getHeight() + "\n"
				+ "Area: " + rectangle2.getArea() + "\n"
				+ "Perimeter: " + rectangle2.getPerimeter() + "\n");
		
	}

}
class Rectangle {
	private double width = 1;
	private double height = 1;
	
	/** No-arg constructor for a triangle */
	public Rectangle() {
		width = 1;
		height = 1;
	}
	
	/** Constructor for a triangle with specified width & height */
	public Rectangle(double newWidth, double newHeight) {
		if (width >= 0 && height >= 0) {
			width = newWidth;
			height = newHeight;
		}
			
	}
	
	/** Computing Area method */
	public double getArea() {
		return width * height;
	}
	
	/** Computing Perimeter method */
	public double getPerimeter() {
		return 2 * height + 2 * width;
	}
	
	/** Accessor for a width */
	public double getWidth() {
		return width;
	}
	
	/** Accessor for a height */
	public double getHeight() {
		return height;
	}
	
}

