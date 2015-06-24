/**
 * 
 */
package chapter19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 8:21:12 
 */
public class L1901_TestFileStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Create output stream to the file
		FileOutputStream output = new FileOutputStream("C:/Java/examples/temp.dat");
		
		// Output value to the file
		for (int i = 0; i < 10; i++)
			output.write(i);
		
		// Close the output stream
		output.close();
		
		FileInputStream input = new FileInputStream("C:/Java/examples/temp.dat");
		
		// Read values from the file
		int value;
		while ((value = input.read()) != -1)
			System.out.print(value + " ");
		
		// Close the input stream
		input.close();
		
	}

}
