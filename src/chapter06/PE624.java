/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE624 {

	/**
	 * 
	 */
	public PE624() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		int[] deck = new int[52];

		// Creating the deck of cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}

		// Shuffling the deck
		for (int i = 0; i < deck.length; i++) {
			int randomIndex = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[randomIndex];
			deck[randomIndex] = temp;

		}

		// Picking the cards
		int[] suitCounter = new int[suits.length];
		for (int i = 0; i < 52 && !isPicked(suitCounter); i++) {
			System.out.println(ranks[deck[i] % 13] + " of " + suits[deck[i] / 13]);
			suitCounter[deck[i] / 13]++;
		}
	}
	// Check if all suits had been already used
	public static boolean isPicked(int[] array) {
		boolean[] check = new boolean[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0)
				check[i] = true;
		}
		for (int i = 0; i < check.length; i++) {
			if (!check[i])
				return false;
		}
		return true;
	}
}
