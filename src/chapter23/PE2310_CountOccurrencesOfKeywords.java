/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jslapnicka
 * @Date & @Time 21. 1. 2015 2015 10:36:24 
 */
public class PE2310_CountOccurrencesOfKeywords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file path: ");
		// C:\Java\Test\L2301_TestHashSet.java
		String filePath = input.nextLine();
		File fileName = new File(filePath);
		
		String[] keywords = {"abstract", "assert", "boolean",
				"break", "byte", "case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else", "enum",
				"extends", "for", "final", "finally", "float", "goto",
				"if", "implements", "import", "instanceof", "int",
				"interface", "long", "native", "new", "package", "private",
				"protected", "public", "return", "short", "static",
				"strictfp", "super", "switch", "synchronized", "this",
				"throw", "throws", "transient", "try", "void", "volatile",
				"while", "true", "false", "null"};		
		HashSet<String> keyWordsSet = new HashSet<String>(Arrays.asList(keywords));
		StringBuilder builder = new StringBuilder();
		String temp;
		int startIndex;
		int endIndex;
		
		try {
			Scanner fileScan = new Scanner(fileName);
			while (fileScan.hasNextLine()) {
				temp = fileScan.nextLine() + "\n";
				
				// Delete line comments
				if (temp.indexOf("//") > -1) {
					startIndex = temp.indexOf("//");
					if ((temp.indexOf("\n")) > -1)
						temp = temp.substring(0, startIndex);
					startIndex = -1;
				}
				
				// Delete multiple-line comments
				if (temp.indexOf("/**") > -1) {
					while (temp.indexOf("*/") == -1)
						temp = fileScan.nextLine();
					temp = "";
				}
				
				// Delete String expressions
				if (temp.indexOf("\"") > -1) {
					startIndex = temp.indexOf("\"");
					endIndex = temp.lastIndexOf("\"");
					temp = temp.substring(0, startIndex) + temp.substring(endIndex + 1);
				}
				
				builder.append(temp + "\n");
			}
			input.close();
			fileScan.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found !");
		}
		
		TreeMap<String, Integer> containedKeywords = new TreeMap<String, Integer>();
		String[] formattedInput = builder.toString().split("[ \n\t\r.,:;!?(){}]");
		int count = 0;
		for (int i = 0; i < formattedInput.length; i++) {
			if (keyWordsSet.contains(formattedInput[i])) {
				if (!containedKeywords.containsKey(formattedInput[i])) {
					count = 1;
					containedKeywords.put(formattedInput[i], count);
				} else {
					count = containedKeywords.get(formattedInput[i]) + 1;
					containedKeywords.put(formattedInput[i], count);					
				}
			}
		}
		
		
		System.out.println("Number of keywords: " + containedKeywords.size());
		System.out.println("Contained keywords: " + containedKeywords);
		
		Set<Map.Entry<String, Integer>> entrySet = containedKeywords.entrySet();
		
		for (Map.Entry<String, Integer> entry: entrySet)
			System.out.println(entry.getKey() + ":\t" + entry.getValue());
	}

}
