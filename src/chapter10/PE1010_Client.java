/**
 * 
 */
package chapter10;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 17:28:44 
 */
public class PE1010_Client {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int date = 0; 
		int answer;

		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Is your birthday in Set" + (i  + 1) + "?");
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					System.out.print(L1010_GuessDate.getValue(i, j, k) + " ");
				}
				System.out.println();
			}

			System.out.print("\nEnter 0 for No and 1 for Yes: ");
			answer = input.nextInt();

			if (answer == 1)
				date += L1010_GuessDate.getValue(i, 0, 0);
		}
		System.out.println("Your birthday is: " + date);

	}

}