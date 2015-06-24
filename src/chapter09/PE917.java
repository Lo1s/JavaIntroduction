/**
 * 
 */
package chapter09;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 11:22:14 
 */
public class PE917 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// Load data from the input file
		Scanner input = new Scanner(new File ("PE917-input.txt"));
		String[][] statesAndCapitals = new String[50][2];
		for (int i = 0; i < statesAndCapitals.length; i++) {
			statesAndCapitals[i][0] = input.next().replace('_', ' ');	// Replace "_" with the space
			statesAndCapitals[i][1] = input.next().replace('_', ' ');	// Replace "_" with the space
		}

		// Prompts the user for answer on all items stored in an array
		String[] answers = new String[50];
		int correct = 0;
		Scanner userInput = new Scanner(System.in);
		for (int i = 0; i < statesAndCapitals.length; i++) {
			System.out.println("What is the capital of " + statesAndCapitals[i][0] + "? ");
			answers[i] = userInput.nextLine();
			if (answers[i].equalsIgnoreCase(statesAndCapitals[i][1])) {
				System.out.println("Your answer is correct !");
				correct++;
			} else {
				System.out.println("The correct answer should be: " + statesAndCapitals[i][1]);
			}
		}
		System.out.println("\nThe correct count is: " + correct);
	}

}
