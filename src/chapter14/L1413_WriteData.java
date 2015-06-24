/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jslapnicka
 * @Date & @Time 19. 8. 2014 2014 10:38:31 
 */
public class L1413_WriteData {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:/Java/scores.txt");
		if (file.exists()) {
			System.out.println("File already exists !");
			System.exit(1);
		}
		
		// Create a file
		PrintWriter output = new PrintWriter(file);
		
		// Write formatted output to the file
		output.print("John T Smith ");
		output.println(90);
		output.print("Erik K Jones ");
		output.println(85);
		
		// Close the file
		output.close();
	}

}
