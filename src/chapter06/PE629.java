/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE629 {

	/**
	 * 
	 */
	public PE629() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] deck = new int[52];
		String[] ranks = {"Ace", "Two,", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

		// Creating deck of cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}


		// Shuffle the deck
		int temp = 0;
		for (int i = 0; i < deck.length; i++) {
			int random = (int)(Math.random() * ((deck.length - 1) + 1));
			temp = deck[i];
			deck[i] = deck[random];
			deck[random] = temp;
		}

		// Pick 4 cards and count sum
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += ((deck[i] % 13) + 1);
			System.out.println(ranks[deck[i] % 13] + " of " + suits[deck[i] / 13] + " - " + ((deck[i] % 13) + 1));
		}
		System.out.println("Total sum of cards is: " + sum + "\n");

		// Pick X cards to sum 24
		sum = 0;
		int counter = 0;
		for (int i = 0; i < deck.length; i++) {
			if (sum + ((deck[i] % 13) + 1) <= 24) {
				sum += ((deck[i] % 13) + 1);
				System.out.println(ranks[deck[i] % 13] + " of " + suits[deck[i] / 13] + " - " + ((deck[i] % 13) + 1));
				counter++;
			} else
				break;
		}
		System.out.println("Total sum of cards is: " + sum);
		System.out.println("Next card would be: " + (((deck[counter + 1]) % 13) + 1));
	}

}
