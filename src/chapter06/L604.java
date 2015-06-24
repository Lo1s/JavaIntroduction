/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class L604 {

	/**
	 * 
	 */
	public L604() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] chars = createArray(100);
		
		System.out.println("The lowercase letters are:");
		displayArray(chars, 20);
		
		// Creating an array for counting the letters
		int[] counts = createCounts(chars, 26);
		
		System.out.println("\n");
		System.out.println("The occurences of each letter are:");
		displayCounts(counts);
	}
	
	
	// Creates and array of random letters
	public static char[] createArray(int numberOfElements) {
		// Creating array
		char[] chars = new char[numberOfElements];
		
		// Initializing with random letters
		for (int i = 0; i < chars.length; i++) {
			chars[i] = hdR.mtd.getRandomLowerCaseLetter();
		}
		
		return chars;
	}
	
	// Display an array separated into lines per requested number of items
	public static void displayArray(char[] array, int numberOfItemsPerLine) {
		int lineCheck = 0;
		for (int i = 0; i < array.length; i++) {
			if (lineCheck == numberOfItemsPerLine) {
				System.out.println();
				lineCheck = 0;
			} else {
				System.out.print(array[i] + " ");
				lineCheck++;
			}
		}
	}
	
	// Creating the integer Array for counting the letters
	public static int[] createCounts(char[] array, int numberOfElements) {
		int[] counts = new int[numberOfElements];
		
		for (int i = 0; i < array.length; i++)
			counts[array[i] - 'a']++;
		
		return counts;
		
	}
	
	// Display the result with calculated letters in the array
	public static void displayCounts(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if ((i + 1) % 10 == 0)
				System.out.println(array[i] + " " + (char)(i + 'a'));
			else
				System.out.print(array[i] + " " + (char)(i + 'a') + " ");
		}
	}
	
	
	
}
