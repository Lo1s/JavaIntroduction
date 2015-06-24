/**
 * 
 */
package chapter19;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 10:09:21 
 */
public class PE1901_CreateTextFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fileName = new File("C:/Java/examples/Exercise19_01.txt");
		
		// Create an output stream
		PrintWriter output = new PrintWriter(new FileOutputStream(fileName, true));
				
		// Append data
		if (fileName.exists())
			for (int i = 0; i < 100; i++) {
				int random = (int)(Math.random() * 100);
				output.write(random + " ");
			}
		
		// Close the stream
		output.close();
	}

}
