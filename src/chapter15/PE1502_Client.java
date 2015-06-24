/**
 * 
 */
package chapter15;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 12:54:51 
 */
public class PE1502_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Side1: ");
		double side1 = input.nextDouble();
		System.out.print("Side2: ");
		double side2 = input.nextDouble();
		System.out.print("Side3: ");
		double side3 = input.nextDouble();
		
		System.out.print("Color: ");
		String color = input.next();
		System.out.print("Filled ?: ");
		boolean filled = input.nextBoolean();
		
		PE1502_Triangle triangle = new PE1502_Triangle(side1, side2, side3);
		triangle.setColor(color);
		triangle.setFilled(filled);
		input.close();
		System.out.println("Area: " + triangle.getArea() +
				"\nPerimeter: " + triangle.getPerimeter() +
				"\nColor: " + triangle.getColor() +
				"\nFilled ?: " + triangle.isFilled());
	}

}
