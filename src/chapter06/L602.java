/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class L602 {

	/**
	 * 
	 */
	public L602() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating the array for deck
		int[] deck = new int[52];
		
		// Creating the array for suits
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		
		// Initializing the array deck
		for (int i = 0; i < deck.length; i++)
			deck[i] = i;
		
		// Shuffle the cards
		for (int i = 0; i < deck.length; i++) {
			int randomIndex = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[randomIndex];
			deck[randomIndex] = temp;
		}
		
		// Display the first four cards
		for (int i = 0; i < 4; i++) {
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);
		}
	}

}
