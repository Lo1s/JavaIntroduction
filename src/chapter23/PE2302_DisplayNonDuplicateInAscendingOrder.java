/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author jslapnicka
 * @Date & @Time 19. 1. 2015 2015 13:10:16 
 */
public class PE2302_DisplayNonDuplicateInAscendingOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: java PE2302_DisplayNonDuplicateInAscendingOrder filename.txt");
			System.exit(0);
		}
		
		StringBuilder builder = new StringBuilder();
		
		try {
			Scanner input = new Scanner(new File(args[0]));
			while (input.hasNextLine()) {
				builder.append(input.nextLine() + "\n");
			}
			input.close();
		} 
		catch (FileNotFoundException ex) {
			System.out.println("File does not exist !");
		}
		
		String text = builder.toString();
		TreeSet<String> treeSet = new TreeSet<String>(Arrays.asList(text.split("[ \n\t\r.,:;!?(){}]")));
		
		while (!treeSet.isEmpty()) {
			System.out.println(treeSet.pollFirst());
		}
	}

}
