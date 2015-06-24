/**
 * 
 */
package chapter08;



/**
 * @author jslapnicka
 * @Date & @Time 12. 6. 2014 2014 8:08:29 
 */
public class PE809 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** First polygon */
		RegularPolygon pol1 = new RegularPolygon();
		System.out.println("The first polygon");
		System.out.println("Area: " + pol1.getArea() 
				+ "\nPerimeter: " + pol1.getPerimeter() + "\n");
		/** Second polygon */
		RegularPolygon pol2 = new RegularPolygon(6, 4);
		System.out.println("The second polygon");
		System.out.println("Area: " + pol2.getArea()
				+ "\nPerimeter: " + pol2.getPerimeter() + "\n");
		/** Third polygon */
		RegularPolygon pol3 = new RegularPolygon(10, 4, 5.6, 7.8);
		System.out.println("The third polygon");
		System.out.println("Area: " + pol3.getArea()
				+ "\nPerimeter: " + pol3.getPerimeter());
	}

}
class RegularPolygon {
	// Data field
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	
	/** No-arg constructor */
	RegularPolygon() {
		
	}
	/** Constructor with specified values */
	RegularPolygon(int newN, double newSide) {
		n = newN;
		side = newSide;
	}
	
	/** Constructor with specified values and coordinations */
	RegularPolygon(int newN, double newSide, double newX, double newY) {
		n = newN;
		side = newSide;
		x = newX;
		y = newY;
	}
	// Accessors (Getters) for data field
	public int getN() {
		return n;
	}
	public double getSide() {
		return side;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	// Mutators (Setters) for data field
	public void setN(int newN) {
		n = newN;
	}
	public void setSide(double newSide) {
		side = newSide;
	}
	public void setX(double newX) {
		x = newX;
	}
	public void setY(double newY) {
		y = newY;
	}
	
	/** Method that returns the perimeter of the regular polygon */
	public double getPerimeter() {
		return n * side;
	}
	
	/** Method that returns the area of the regular polygon */
	public double getArea() {
		return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI/n));
	}
	
}
