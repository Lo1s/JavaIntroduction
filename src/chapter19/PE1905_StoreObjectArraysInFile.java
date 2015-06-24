/**
 * 
 */
package chapter19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 12:24:24 
 */
public class PE1905_StoreObjectArraysInFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// Create an object output stream
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:/Java/examples/Exercise19_05.dat"));
		
		// Create objects for output
		int[] array = new int[] {1, 2, 3, 4, 5};
		Date date = new Date();
		double value = 5.5;
		
		// Write the objects into the file
		output.writeObject((Object)array);
		output.writeObject((Object)date);
		output.writeDouble(value);
		
		// Close the output stream
		output.close();
		
		// Create input object stream for the check
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:/Java/examples/Exercise19_05.dat"));
		int[] newArray = (int[])(input.readObject());
		Date newDate = (Date)(input.readObject());
		double newValue = input.readDouble();
		
		// Close the input stream
		input.close();
		
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
		System.out.println("\n" + newDate);
		System.out.println(newValue + " ");
	}

}
