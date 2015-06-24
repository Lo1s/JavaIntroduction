/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 26. 8. 2014 2014 8:25:53 
 */
public class PE1414_ProcessScoresInTextFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: java PE1414_ProcessScoresInTextFile filename");
			System.exit(1);
		}
		
		File file = new File(args[0]);
		
		if (!file.exists()) {
			System.out.println("File does not exist !");
			System.exit(2);
		}
		
		int sum = 0;
		
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {
			sum += input.nextInt();
		}
		input.close();
		System.out.println("Sum is " + sum);
	}

}
