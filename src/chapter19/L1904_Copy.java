/**
 * 
 */
package chapter19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 8:52:53 
 */
public class L1904_Copy {

	/**
	 * @param args[0] for source file
	 * @param args[1] for target file
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("Usage: java L1904_Copy sourceFile targetFile");
			System.exit(1);
		}
		
		// Check whether the source file exists
		File sourceFile = new File("C:/Java/examples/" + args[0]);
		if (!sourceFile.exists()) {
			System.out.println("Source file " + args[0] + " does not exist !");
			System.exit(2);
		}
		
		// Check whether the target file exists
		File targetFile = new File("C:/Java/examples/" + args[1]);
		if (targetFile.exists()) {
			System.out.println("Target file " + args[1] + " already exists !");
			System.exit(3);
		}
		
		// Create an input stream
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
		
		// Create an input stream
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
		
		// Continuously read a byte from the input and write it to output
		int r, numberOfBytesCopied = 0;
		while ((r = input.read()) != 0) {
			output.write((byte)r);
			numberOfBytesCopied++;
		}
		
		// Close streams
		input.close();
		output.close();
		
		// Display the file size
		System.out.println(numberOfBytesCopied + " bytes copied");
			
	}

}
