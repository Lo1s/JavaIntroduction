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
 * @Date & @Time 25. 8. 2014 2014 14:32:16 
 */
public class PE1412_ReformatJavaSourceCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// Check the command parameters
		if (args.length != 1) {
			System.out.println("Usage: java PE1412_ReformatJavaSourceCode");
			System.exit(1);
		}

		File sourceFile = new File(args[0]);

		// Check if the file exists
		if (!sourceFile.exists()) {
			System.out.println("File does not exist !");
			System.exit(2);
		}

		StringBuilder buffer = new StringBuilder();
		Scanner input = new Scanner(sourceFile);

		while (input.hasNext()) {
			String s = input.nextLine();
			String s1 = s.trim();
			if (s1.charAt(0) == '{') {
				buffer.append(" {");
				if (s1.length() > 1)
					buffer.append("\r\n" + s.replace('{', ' '));
			} else
				buffer.append("\r\n" + s);
		}

		input.close();

		// Write the formatted text into the file
		PrintWriter output = new PrintWriter(sourceFile);
		output.print(buffer.toString());
		output.close();

	}

}
