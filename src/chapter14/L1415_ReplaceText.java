/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 19. 8. 2014 2014 11:12:01 
 */
public class L1415_ReplaceText {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// Check command line parameters usage
		if (args.length != 4) {
			System.out.println("Usage: java L1415_ReplaceText sourceFile targetFile oldStr newStr");
			System.exit(1);
		}
		
		// Check if source file exists
		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			System.out.println("Source file does not exist !");
			System.exit(2);
		}
		
		// Check if target file exists
		File targetFile = new File(args[1]);
		if (targetFile.exists()) {
			System.out.println("Target file " + args[1] + " already exists !");
			System.exit(3);
		}
		
		// Create a Scanner for input and PrintWriter for output
		Scanner input = new Scanner(sourceFile);
		PrintWriter output = new PrintWriter(targetFile);
		
		while (input.hasNext()) {
			String s1 = input.nextLine();
			String s2 = s1.replaceAll(args[2], args[3]);
			output.println(s2);
		}
		
		input.close();
		output.close();
		
	}

}
