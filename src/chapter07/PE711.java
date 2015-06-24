/**
 * 
 */
package chapter07;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE711 {

	/**
	 * 
	 */
	public PE711() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 511: ");
		int number = input.nextInt();
		while (number > 511) {
			System.out.print("Entered number is outside the range of: 0 - 511, please re-enter: ");
			number = input.nextInt();
		}
		int[] toss = new int[9];
		toss = convertToBinary(toss, number);
		displayArray(toss);
	}
	// Converts to binary
	public static int[] convertToBinary(int[] array, int input) {
		int[] binaryDigits = new int[array.length];
		for (int i = 0; i < binaryDigits.length; i++) {
			binaryDigits[i] = (int)Math.pow(2, i);
		}
		for (int j = array.length - 1; j >= 0; j--) {
			if(input >= binaryDigits[j]) {
				array[array.length - 1 - j] = 1;
				input = input - binaryDigits[j];
			} else
				array[array.length - 1 - j] = 0;
		}
		return array;
	}
	// Prints an array
	public static void displayArray(int[] array) {
		int checkRow = 0;
		String token = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0)
				token = "H";
			else
				token = "T";
			System.out.print(token + " ");
			checkRow++;
			if (checkRow == 3) {
				System.out.println();
				checkRow = 0;
			}
		}
	}


}
