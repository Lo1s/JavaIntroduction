/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 26. 8. 2014 2014 15:20:22 
 */
public class PE1419_CountWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("C:/Java/Lincoln.txt");
		
		Scanner input = new Scanner(file);
		int count = 0;
		
		while (input.hasNext()) {
			if (Character.isLetter(input.next().charAt(0)))
				count++;
		}
		input.close();
		System.out.println("Number of words in Lincoln's Gettysburg adress: " + count);
	}

}
