/**
 * 
 */
package chapter20;

import java.io.File;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 20. 11. 2014 2014 15:38:14 
 */
public class L2007_DirectorySize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a directory or a file: ");
		Scanner input = new Scanner(System.in);
		String directory = input.nextLine();
		input.close();
		// Display the size
		System.out.print(getSize(new File(directory)) + " bytes");
	}
	
	public static long getSize(File file) {
		long size = 0; // Store the total size of all
		
		if (file.isDirectory()) {
			File[] files = file.listFiles(); // All files and subdirectories
			for (int i = 0; files != null && i < files.length; i++) {
				size += getSize(files[i]); // Recursive call
			}
		}
		else { // Base case
			size += file.length();
		}
		
		return size;
	}

}
