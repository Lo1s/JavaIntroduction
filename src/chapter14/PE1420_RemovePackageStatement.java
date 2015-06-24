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
 * @Date & @Time 26. 8. 2014 2014 15:54:18 
 */
public class PE1420_RemovePackageStatement {

	/**
	 * @param args
	 */

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: java PE1418_AddPackageStatement srcRootDirectory");
			System.exit(1);
		}

		File file = new File(args[0]);

		if (!file.exists()) {
			System.out.println("File does not exist !");
			System.exit(2);
		}

		File[] files = file.listFiles();
		
		StringBuilder buffer = new StringBuilder();

		for (int i = 0; i < files.length; i++) {
			File javaFile = new File("C:/Java/srcRootDirectory/chapter" + (i + 1) + "/ch" + (i + 1) + ".java");
			Scanner input = new Scanner(javaFile);
			while (input.hasNextLine()) {
				buffer.append(input.nextLine() + "\n");
			}
			PrintWriter output = new PrintWriter(files[i] + "/ch" + (i + 1) + ".java");
			buffer.delete(buffer.indexOf("package chapter" + (i + 1) + ";"), buffer.indexOf("package chapter" + (i + 1) + ";") + 17);
			output.println(buffer.toString());
			buffer.setLength(0);
			output.close();
			input.close();
		}
	}

}