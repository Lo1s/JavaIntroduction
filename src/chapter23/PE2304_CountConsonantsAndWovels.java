/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author jslapnicka
 * @Date & @Time 20. 1. 2015 2015 7:55:56 
 */
public class PE2304_CountConsonantsAndWovels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file: ");
		File file = new File(input.nextLine());
		input.close();
		Set<Character> vowels = new HashSet<Character>(Arrays.asList(new Character[] {'a', 'e', 'i', 'o', 'u'}));

		int countVowels = 0;
		int countConsonants = 0;

		try {
			Scanner scanFile = new Scanner(file);
			while (scanFile.hasNext()) {
				String word = scanFile.next();
				word = word.toLowerCase();
				for (int i = 0; i < word.length(); i++) {
					if (vowels.contains(word.charAt(i)))
						countVowels++;
					else if (Character.isLetter(word.charAt(i)))
						countConsonants++;
				}
			}
			scanFile.close();
		} 
		catch (FileNotFoundException ex) {
			System.out.println("File not found !");
		}
		
		
		System.out.println("Number of vowels: " + countVowels + "\nNumber of consonants: " + countConsonants);
	}

}
