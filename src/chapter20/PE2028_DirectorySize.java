/**
 * 
 */
package chapter20;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 26. 11. 2014 2014 16:16:35 
 */
public class PE2028_DirectorySize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a directory or a file: ");
		String directory = input.nextLine();

		// Display the size
		long i = System.currentTimeMillis();
		try {
			System.out.print(getSize(directory) + " bytes.");
			System.out.println("\nCalculations took " + (System.currentTimeMillis() - i) + " miliseconds");
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		input.close();		
	}

	public static long getSize(String directory) {
		long size = 0;
		int numberOfFiles = 0;
		File file = new File(directory);
		ArrayList<File[]> directoryList = new ArrayList<File[]>();
		if (file.isDirectory()) {
			directoryList.add(file.listFiles());
			for (int i = 0; i < directoryList.size(); i++) {
				for (int j = 0; j < directoryList.get(i).length; j++) {
					if (directoryList.get(i)[j].isDirectory()) {
						directoryList.add(directoryList.get(i)[j].listFiles());
					} else {
						size += directoryList.get(i)[j].length();
						numberOfFiles++;
					}

				}
			}
			System.out.println("Number of files: " + numberOfFiles);
			System.out.println("Number of directories: " + (directoryList.size() - 1));
			return size;	
		} else {
			numberOfFiles = (file.isFile() ? numberOfFiles += 1: 0);
			System.out.println("Number of files: " + numberOfFiles);
			return size += file.length();
		}	
	}

}
