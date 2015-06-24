/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author jslapnicka
 * @Date & @Time 19. 1. 2015 2015 9:46:52 
 */
public class L2307_CountKeywords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Java source file: ");
		String fileName = input.nextLine();
		input.close();

		File file = new File(fileName);
		if (file.exists()) {
			System.out.println("The number of keywords in " + fileName + " is " + countKeywords(file));
		} else
			System.out.println("File " + fileName + " does not exist !");
	}

	public static int countKeywords(File file) {
		// Array of all Java keyword + true, false and null;
		String[] keywordString = {"abstract", "assert", "boolean",
				"break", "byte", "case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else", "enum",
				"extends", "for", "final", "finally", "float", "goto",
				"if", "implements", "import", "instanceof", "int",
				"interface", "long", "native", "new", "package", "private",
				"protected", "public", "return", "short", "static",
				"strictfp", "super", "switch", "synchronized", "this",
				"throw", "throws", "transient", "try", "void", "volatile",
				"while", "true", "false", "null"};

		Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywordString));
		int count = 0;
		
		try {
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				String word = input.next();
				if (keywordSet.contains(word))
					count++;
			}
			input.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}
		
		return count;		
	}
	
	

}
