/**
 * 
 */
package chapter11;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 16. 7. 2014 2014 14:05:06 
 */
public class PE1101_Client {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three sides of the triangle: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		
		PE1101_Triangle triangle = new PE1101_Triangle(side1, side2, side3);
		
		System.out.print("Enter a color of the triangle: ");
		String color = input.next();
		triangle.setColor(color);
		System.out.print("Enter true if filled and false if not: ");
		triangle.isFilled(input.nextBoolean());
		
		System.out.println(triangle.toString());
		System.out.println("Area: " + triangle.getArea());
		System.out.println("Perimeter: " + triangle.getPerimeter());
		System.out.println("Color: " + triangle.getColor());
		System.out.println("Filled ? " + triangle.isFilled());
	}

}
