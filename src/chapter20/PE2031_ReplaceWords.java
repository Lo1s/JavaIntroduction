/**
 * 
 */
package chapter20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 27. 11. 2014 2014 14:27:55 
 */
public class PE2031_ReplaceWords {

	static long numberOfFiles = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.out.println("Usage: java PE2031_ReplaceWords dirName oldWord newWord");
			System.exit(0);
		}

		File file = new File(args[0]);
		String oldWord = args[1];
		String newWord = args[2];

		findFile(file, oldWord, newWord);
	}

	public static long findFile(File file, String oldWord, String newWord) {

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; files != null && i < files.length; i++) {
				findFile(files[i], oldWord, newWord);
			}
		} else {
			numberOfFiles++;
			replaceWord(file, oldWord, newWord);
		}
		return numberOfFiles;		
	}

	public static void replaceWord(File file, String oldWord, String newWord) {
		StringBuilder builder = new StringBuilder();
		try {
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				String temp = input.nextLine().replaceAll(oldWord, newWord);
				builder.append(temp + "\n");
			}
			input.close();
			PrintWriter output = new PrintWriter(file);
			output.write(builder.toString());
			output.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

}
