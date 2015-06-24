/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 26. 8. 2014 2014 8:38:22 
 */
public class PE1415_WriteReadData {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// Create the file
		File file = new File("C:/Java/Exercise14_15.txt");
		PrintWriter output = new PrintWriter(file);

		// Generate the random numbers and write it into the file
		int count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				output.print((int)(Math.random() * 100) + " ");
				count++;
			}
			output.println();
		}
		output.close();

		// Create scanner
		Scanner input = new Scanner(file);
		
		input.close();

		input = new Scanner(file);
		int[] numbers = new int[count];

		// Read the numbers into an Array
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}
		input.close();
		// Sort the array
		sort(numbers);
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < i + 10; j++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
		}
		
	}

	public static int[] sort(int[] array) {
		int temp = 0;
		int min = array[0];

		for (int i = 0; i < array.length; i++) {
			min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (min > array[j]) {
					temp = min;
					min = array[j];
					array[j] = temp;
					array[i] = min;
				}
			}		
		}
		return array;
	}

}
