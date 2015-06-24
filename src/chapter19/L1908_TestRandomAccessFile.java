/**
 * 
 */
package chapter19;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 9:29:25 
 */
public class L1908_TestRandomAccessFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Create a random access file
		RandomAccessFile inout = new RandomAccessFile("C:/Java/examples/inout.dat", "rw");
		
		// Clear the file to destroy the old contents, if any
		inout.setLength(0);
		
		// Write new integers to the file
		for (int i = 0; i < 200; i++) {
			inout.writeInt(i);
			System.out.print("[" + i + "]");
		}
		System.out.println();
		// Display the current length of the file
		System.out.println("Current file length is " + inout.length());
		
		// Retrieve the first number
		inout.seek(0); // Move the file pointer to the beginning
		System.out.println("The first number is: " + inout.readInt());
		
		// Retrieve the second number
		inout.seek(1 * 4); // Move the file pointer to the second number
		System.out.println("The second number is " + inout.readInt());
		
		// Retrieve the tenth number
		inout.seek(9 * 4); // Move the file pointer to the tenth number
		System.out.println("The tenth number is " + inout.readInt());
		
		// Modify the eleventh number
		inout.writeInt(555);
		
		// Append a new number
		inout.seek(inout.length()); // Move the file pointer to the end
		inout.writeInt(999);
		
		// Display the new length
		System.out.println("The new length is " + inout.length());
		
		// Retrieve the eleventh number
		inout.seek(10 * 4); // Move the file pointer to the end
		System.out.println("The eleventh number is " + inout.readInt());
		
		inout.close();
		
	}

}
