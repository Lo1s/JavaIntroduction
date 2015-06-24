/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author jslapnicka
 * @Date & @Time 21. 1. 2015 2015 10:11:29 
 */
public class PE2309_GuessCapitals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Load data from the input file
		TreeMap<String, String> statesAndCapitals = new TreeMap<String, String>();
		try {
			Scanner input = new Scanner(new File ("C:/Java/Test/Cities.txt"));

			while (input.hasNext()) {
				statesAndCapitals.put(input.next().replace('_', ' ').toLowerCase(), input.next().replace('_', ' '));	// Replace "_" with the space
			}
			input.close();
		} catch (FileNotFoundException ex) {
			System.out.print("Problem with the input file !");
		}

		// Prompts the user to enter state and displays capital city afterwards
		Scanner userGuess = new Scanner(System.in);
		String guess;
		do {
			System.out.print("Enter a state (or \"stop\" for terminating): ");
			guess = userGuess.nextLine().toLowerCase();
			if (guess.equals("stop"))
				System.out.println("Good bye !");
			else if (statesAndCapitals.get(guess) == null)
				System.out.println("No such a state exists !");
			else
				System.out.println("Capital for " + guess + " is: " + statesAndCapitals.get(guess));
		} while (!guess.equals("stop"));

		userGuess.close();
	}

}
