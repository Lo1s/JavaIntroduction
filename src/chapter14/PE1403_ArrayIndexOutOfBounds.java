/**
 * 
 */
package chapter14;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 10:03:20 
 */
public class PE1403_ArrayIndexOutOfBounds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++) {
			array[i] = hdR.mtd.getRandomNumber(0, 100);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index: ");
		try {
			int index = input.nextInt();
			System.out.println("array[" + index + "] is: " + array[index]);
			input.close();
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Out of Bounds");
		}
	}

}
