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
 * @Date & @Time 26. 8. 2014 2014 13:43:21 
 */
public class PE1416_ReplaceText {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// Check command line parameters usage
		if (args.length != 3) {
			System.out.println("Usage: java PE1416_ReplaceText fileName oldStr newStr");
			System.exit(1);
		}

		// Check if source file exists
		File fileName = new File(args[0]);
		if (!fileName.exists()) {
			System.out.println("File does not exist !");
			System.exit(2);
		}

		// Create a Scanner for input
		Scanner input = new Scanner(fileName);
		StringBuilder buffer = new StringBuilder();

		while (input.hasNext()) {
			String s1 = input.nextLine();
			String s2 = s1.replaceAll(args[1], args[2]);
			buffer.append(s2 + "\n");
		}
		input.close();

		// Create PrintWriter for clearing the file and writing the changes
		PrintWriter output = new PrintWriter(fileName);
		output.print(buffer.toString());
		output.close();

		System.out.print(buffer);

	}

}
