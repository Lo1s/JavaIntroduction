/**
 * 
 */
package chapter19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 9:19:37 
 */
public class L1907_TestObjectStreamForArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		int[] numbers = {1, 2, 3, 4, 5};
		String[] strings = {"John", "Susan", "Kim"};
		
		// Create an output stream for file array.dat
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:/Java/examples/array.dat"));
		
		// Write arrays to the object output stream
		output.writeObject(numbers);
		output.writeObject(strings);
		
		// Close the stream
		output.close();
		// Create an input stream for file array.dat
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:/Java/examples/array.dat"));
				
		int[] newNumbers = (int[])(input.readObject());
		String[] newStrings = (String[])(input.readObject());
		
		// Display arrays
		for (int i = 0; i < newNumbers.length; i++) {
			System.out.print(newNumbers[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < newStrings.length; i++) {
			System.out.print(newStrings[i] + " ");
		}
		System.out.println();
		
		// Close the stream
		input.close();
	}

}
