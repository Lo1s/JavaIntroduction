/**
 * 
 */
package chapter14;

import java.io.File;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 19. 8. 2014 2014 10:47:27 
 */
public class L1414_ReadData {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// Create a file instance
		File file = new File("C:/Java/scores.txt");
		
		// Create a scanner for a file
		Scanner input = new Scanner(file);
		
		// Read data from a file
		while (input.hasNext()) {
			String firstName = input.next();
			String mi = input.next();
			String lastName = input.next();
			int score = input.nextInt();
			System.out.println(firstName + " " + mi + " " + lastName + " " + score);
		}
		
		// Close the file
		input.close();
	}

}
