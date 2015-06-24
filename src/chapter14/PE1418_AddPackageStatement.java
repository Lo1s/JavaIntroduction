/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



/**
 * @author jslapnicka
 * @Date & @Time 26. 8. 2014 2014 14:18:50 
 */
public class PE1418_AddPackageStatement {

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
		
		for (int i = 0; i < files.length; i++) {
			PrintWriter output = new PrintWriter(files[i] + "/ch" + (i + 1) + ".java");
			output.println("package chapter" + (i + 1));
			output.close();
		}
		
		
	}

}
