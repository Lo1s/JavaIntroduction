/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 27. 8. 2014 2014 17:30:55 
 */
public class PE1422_ReplaceText {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// Check command line parameters usage
		if (args.length != 3) {
			System.out.println("Usage: java PE1422_ReplaceText dir oldStr newStr");
			System.exit(1);
		}

		// Check if source file exists
		File fileName = new File(args[0]);
		if (!fileName.exists()) {
			System.out.println("Folder does not exist !");
			System.exit(2);
		}
		
		// Check if the source is a directory
		if (!fileName.isDirectory()) {
			System.out.println("Source is not a directory !");
			System.exit(3);
		}
		
		String sourceString = args[1];
		String targetString = args[2];
		
		File[] files = fileName.listFiles();
		ArrayList<StringBuilder> bufferList = new ArrayList<StringBuilder>();
		
		for (int i = 0; i < files.length; i++) {
			Scanner input = new Scanner(files[i]);
			while (input.hasNextLine()) {
				bufferList.add(new StringBuilder().append(input.nextLine()));
			}
			input.close();
		}
		
		for (int i = 0; i < files.length; i++) {
			PrintWriter output = new PrintWriter(files[i]);
			output.print(bufferList.get(i).toString().replaceAll(sourceString, targetString));
			output.close();
		}
	}

}