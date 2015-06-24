/**
 * 
 */
package chapter20;

import java.io.File;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 27. 11. 2014 2014 10:10:41 
 */
public class PE2030_FindWords {

	static int numberOfFiles = 0;
	static int numberOfSearchedFiles = 0;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 2) {
			System.out.println("Usage java PE2030_FindWords dirName word");
			System.exit(0);
		}
		
		String dir = args[0];
		String word = args[1];
		File file = new File(dir);
		System.out.println("Total number of files: " + findFile(file, word));
		System.out.println("Number of files containing a word: " + numberOfSearchedFiles);
	}

	public static long findFile(File file, String word) {
		if (file.isDirectory()) {
			File[] fileList = file.listFiles();
			for (int i = 0; fileList != null && i < fileList.length; i++) {
				findFile(fileList[i], word);
			}
		} else {
			numberOfFiles++;
			findWord(file, word);
		}
		return numberOfFiles;
	}

	public static void findWord(File file, String word) {
		try {
			Scanner input = new Scanner(file);
			String temp = "";
			while (input.hasNext()) {
				temp = input.nextLine();
				if (temp.indexOf(word) > -1) {
					numberOfSearchedFiles++;
					System.out.println(file + " : " + temp);
				}
			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
