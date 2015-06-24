/**
 * 
 */
package chapter22;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author hydRa
 * @Date & @Time 17. 12. 2014 2014 13:04:33 
 */
public class PE2211_MatchGroupingSymbols {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: java PE2211_MatchingGroupingSymbols filename");
			System.exit(1);
		}

		File file = new File(args[0]);
		Scanner input = new Scanner(file);
		String excerpt = "";
		Stack<Character> startSymbol = new Stack<Character>();
		Stack<Character> endSymbol = new Stack<Character>();

		while (input.hasNext()) {
			excerpt += input.nextLine() + "\n";
		}
		input.close();

		for (int i = 0; i < excerpt.length(); i++) {
			if (excerpt.charAt(i) == '{' || excerpt.charAt(i) == '(' || excerpt.charAt(i) == '[')
				startSymbol.push(excerpt.charAt(i));
			else if (excerpt.charAt(i) == '}' || excerpt.charAt(i) == ')' || excerpt.charAt(i) == ']')
				endSymbol.push(excerpt.charAt(i));
		}

		System.out.println(startSymbol);
		System.out.println(endSymbol);
		for (char startElement: startSymbol) {
			char endElement = endSymbol.pop();
			if ((startElement == '{' && endElement != '}') ||
					(startElement == '(' && endElement != ')') ||
					(startElement == '[' && endElement != ']')) {
				System.out.println("Symbols overlap !");
				System.exit(1);
			}	 
		}
		System.out.println("File is ok !");
	}

}
