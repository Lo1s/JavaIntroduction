package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE440 {

	/**
	 * 
	 */
	public PE440() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMBER_OF_FLIPS = 1000000;
		int countHeads = 0;
		int countTails = 0;
		
		for (int i = 1; i <= NUMBER_OF_FLIPS; i++) {
			int random = 1 + (int)(Math.random() * 2);
			if (random == 1)
				countHeads++;
			else if (random == 2)
				countTails++;			
		}
		System.out.println("Number of Heads: " + countHeads + "\n" +
		"Number of Tails: " + countTails);

	}

}
