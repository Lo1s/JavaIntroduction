/**
 * 
 */
package chapter19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 11:22:19 
 */
public class PE1904_ConvertTextFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		if (args.length != 2) {
			System.out.println("Usage: java PE1904_ConvertTextFile sourceFile targetFile");
			System.exit(0);
		}
		
		File sourceFile = new File("C:/Java/examples/" + args[0]);
		if (!sourceFile.exists()) {
			System.out.println("Source file " + sourceFile +" does not exist !");
			System.exit(1);
		}
		
		File targetFile = new File("C:/Java/examples/" + args[1]);
		if (targetFile.exists()) {
			System.out.println("Target file " + targetFile + " already exists !");
			System.exit(2);
		}
		
		// Read the contents of the text file by text I/O
		StringBuilder builder = new StringBuilder();
		Scanner input = new Scanner(sourceFile);
		while (input.hasNextLine()) {
			builder.append(input.nextLine() + "\n");
		}
		
		// Create an output stream
		DataOutputStream output = new DataOutputStream(new FileOutputStream(targetFile));
		output.writeUTF(builder.toString());
		
		// Create an input stream
		DataInputStream inputIO = new DataInputStream(new FileInputStream(targetFile));
		
		try {
			while (true)
				System.out.println(inputIO.readUTF());
		}
		catch (EOFException ex) {
			System.out.println("End of the file");
		}
	}

}
