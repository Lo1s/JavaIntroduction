/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 25. 8. 2014 2014 15:56:08 
 */
public class PE1413_CountCharactersWordsLines {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: java PE1413_CountCharactersWordsLines filename");
			System.exit(1);
		}
		
		File file = new File(args[0]);
		
		if (!file.exists()) {
			System.out.println("File does not exist ! ");
			System.exit(2);
		}
		
		Scanner input = new Scanner(file);
		int countWords = 0;
		int countChars = 0;
		int countLines = 0;
		
		
		while (input.hasNext()) {
			String s = input.nextLine();
			String[] stringArray = s.split(" ");
			// Count words
			if (stringArray.length > 0)
				countWords += stringArray.length;
			
			for (int i = 0; i < stringArray.length; i++) {
				countChars += stringArray[i].length();
			}
			
			if (countChars > 0 && countLines == 0)
				countLines++;
			
			if (input.hasNextLine())
				countLines++;
		}
		input.close();
		
		System.out.println(countChars + " characters\n"
				+ countWords + " words\n"
				+ countLines + " lines");
	}

}
