/**
 * 
 */
package chapter23;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 1. 2015 2015 16:16:41 
 */
public class PE2315_AdditionQuiz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number1 = (int)(System.currentTimeMillis() % 10);
		int number2 = (int)(System.currentTimeMillis() / 7 % 10);
		HashSet<Integer> enteredNumbers = new HashSet<Integer>();
		Scanner input = new Scanner(System.in);

		System.out.print("What is " + number1 + " + " + number2 + " ? ");
		int enteredNumber = input.nextInt();

		int calculation = number1 + number2;  

		while(enteredNumber != calculation) {
			if (enteredNumbers.contains(enteredNumber)) {
				System.out.println("You already entered 12");
				System.out.print("Wrong answer. Try again ! What is "
						+ number1 + " + " + number2 + " ? ");
				enteredNumber = input.nextInt();
			} else {
				System.out.print("Wrong answer. Try again ! What is "
						+ number1 + " + " + number2 + " ? ");
				enteredNumbers.add(enteredNumber);
				enteredNumber = input.nextInt();
			}
		} 
		
		System.out.println("You got it ! Congratz !");
		enteredNumbers.clear();
		input.close();
	}
}