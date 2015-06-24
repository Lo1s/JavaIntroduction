/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 * @author jslapnicka
 * @Date & @Time 26. 8. 2014 2014 14:16:39 
 */
public class PE1417_HangMan {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
				Scanner input = new Scanner(System.in);
				Scanner fileInput = new Scanner(new File ("PE925-input.txt"));
				String[] word = new String[32];
				for (int i = 0; i < word.length; i++) {
					word[i] = fileInput.nextLine();
				}
				// Creates the guess word list

				// Game on !
				GuessWord guess = new GuessWord();
				guess.setWord(word[(int)(Math.random() * (32 - 1) + 1)]);
				StringBuilder guessWord = new StringBuilder(guess.getWord().length());
				guess.toAsterisks(guessWord);
				int numberOfMisses = 0;

				boolean wannaPlay = true;
				while (wannaPlay) {
					System.out.println("(Guess) Enter a letter in word: " + guessWord.toString());
					char guessChar = input.next().charAt(0);
					if (guess.isRight(guessChar, guessWord))
						guess.modify(guessChar, guessWord);
					else
						numberOfMisses++;
					if (guessWord.toString().equals(guess.getWord())) {
						System.out.println("The word is " + guess.getWord() + ". You missed " + numberOfMisses + (numberOfMisses > 1 ? " times." : " time."));
						System.out.print("Do you want to guess another word ? Enter y or n: ");
						char yesOrNo = input.next().charAt(0);
						if (yesOrNo == 'y') {
							wannaPlay = true;
							guess.setWord(word[(int)(Math.random() * (32 - 1) + 1)]);
							guessWord = new StringBuilder(guess.getWord().length());
							guess.toAsterisks(guessWord);
						} else {
							wannaPlay = false;
							System.out.print("Good bye !");
						}
					}

				}
				input.close();
				fileInput.close();
			}

		}

		class GuessWord { 
			private String word = "";
			
			GuessWord() {		
			}

			// Creates a word made from asterisks
			public void toAsterisks(StringBuilder builder) {
				for (int i = 0; i < word.length() ; i++) {
					builder.replace(i, i + 1, "*");
				}	
			}
			// Randomly choose the word from the input file
			public void chooseWord() {
				
			}
			
			// Checks the quessed char
			public boolean isRight(char ch, StringBuilder builder) {
				for (int i = 0; i < word.length(); i++) {
					if (builder.charAt(i) == '*' && ch == word.charAt(i)) {
						return true;
					} else if (builder.charAt(i) != '*' && ch == word.charAt(i)) {
						System.out.println(ch + " is already in the word !");
						return false;
					}
				}
				System.out.println(ch + " is not in the word !");
				return false;
			}
			// Change the asteriks to the char
			public void modify(char ch, StringBuilder builder) {
				for (int i = 0; i < builder.length(); i++) {
					if (builder.charAt(i) == '*')
						if (ch == word.charAt(i))
							builder.setCharAt(i, ch);
				}
			}
			// Getter for the guess word
			public String getWord() {
				return this.word;
			}
			public String setWord(String newWord) {
				return this.word = newWord;
			}
		}
