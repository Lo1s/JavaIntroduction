/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 25. 8. 2014 2014 9:44:47 
 */
public class PE1411_RemoveText {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
			
		// Check command line parameters usage
		if (args.length != 2) {
			System.out.println("Usage: java PE1411_RemoveText string filename");
			System.exit(1);
		}
		
		String remove = args[0];
		File file = new File(args[1]);
		
		// Check if source file exists
		if (!file.exists()) {
			System.out.println("File do not exist !");
			System.exit(2);
		}
		
		Scanner input = new Scanner(file);
				
		String[] buffer = new String[100];
		int numberOfItems = 0;
		
		for (int i = 0; input.hasNext(); i++) {
			numberOfItems++;
			String temp = input.next();
			if (temp.equals(remove))
				buffer[i] = "";
			else
				buffer[i] = temp;
		}
	
		PrintWriter output = new PrintWriter(file);
		for (int i = 0; i < numberOfItems; i++) {
			output.print(buffer[i]);
		}
		
		input.close();
		output.close();
		System.out.println("Operation has been successfully executed !");
	}

}
