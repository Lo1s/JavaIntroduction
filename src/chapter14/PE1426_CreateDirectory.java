/**
 * 
 */
package chapter14;

import java.io.File;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 28. 8. 2014 2014 12:46:07 
 */
public class PE1426_CreateDirectory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a directory name: ");
		Scanner input = new Scanner(System.in);
		String directory = input.next();
		
		File dir = new File(directory);
		
		if (dir.exists()) {
			System.out.println("Directory already exists");
			System.exit(1);
		}
		
		if (dir.mkdir())
			System.out.println("Directory created successfully !");
		input.close();
	}

}
