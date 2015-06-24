/**
 * 
 */
package chapter19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 9:08:17 
 */
public class L1905_TestObjectOutputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Create an output stream for file object.dat
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:/Java/examples/object.dat"));
		
		// Write a string, double value, and object to the file
		output.writeUTF("John");
		output.writeDouble(85.5);
		output.writeObject(new java.util.Date());
		
		// Close output stream
		output.close();
	}

}
