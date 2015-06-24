/**
 * 
 */
package chapter22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 11. 12. 2014 2014 15:41:16 
 */
public class PE2203_GuessCapitals {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// Load data from the input file
				Scanner input = new Scanner(new File ("C:/Java/Test/Cities.txt"));
				ArrayList<String> states = new ArrayList<String>(50);
				ArrayList<String> capitals = new ArrayList<String>(50);
				
				while (input.hasNext()) {
					states.add(input.next().replace('_', ' '));	// Replace "_" with the space
					capitals.add(input.next().replace('_', ' '));	// Replace "_" with the space
				}
				input.close();
				Collections.shuffle(states, new Random(20));
				Collections.shuffle(capitals, new Random(20));
				// Prompts the user for answer on all items stored in an array
				String[] answers = new String[50];
				int correct = 0;
				Scanner userInput = new Scanner(System.in);
				for (int i = 0; i < states.size(); i++) {
					System.out.println("What is the capital of " + states.get(i) + "? ");
					answers[i] = userInput.nextLine();
					if (answers[i].equalsIgnoreCase(capitals.get(i))) {
						System.out.println("Your answer is correct !");
						correct++;
					} else {
						System.out.println("The correct answer should be: " + capitals.get(i));
					}
				}
				userInput.close();
				System.out.println("\nThe correct count is: " + correct);
			}

		}
