/**
 * 
 */
package chapter06;
import java.io.*;
import java.util.Scanner;


/**
 * @author jslapnicka
 *
 */
public class L601 {

	/**
	 * 
	 */
	public L601() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {  
		// TODO Auto-generated method stub
	
		Scanner input = new Scanner(new File("L601-input.txt"));
	
		boolean isCovered[] = new boolean[99];
		int number = input.nextInt();
		
		while (number != 0) {
			isCovered[number - 1] = true;
			number = input.nextInt();
		}
		
		boolean allCovered = true;
		for (int i = 0; i < isCovered.length; i++) {
			if (!isCovered[i]) {
				allCovered = false;
				break;
			}
		}
		
		if (allCovered)
			System.out.println("The tickets cover all numbers !");
		else
			System.out.println("The tickets does not cover all numbers !");		
		
		for (int i = 0; i < isCovered.length; i++) {
			if (!isCovered[i])
			System.out.println("[" + (i + 1) + "] " +  isCovered[i]);
		}
		
	}
}
