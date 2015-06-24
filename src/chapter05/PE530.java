/**
 * 
 */
package chapter05;


/**
 * @author Jura
 *
 */
public class PE530 {

	/**
	 * 
	 */
	public PE530() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int diceToss1 = hdR.mtd.getRandomNumber(1, 6);
		int diceToss2 = hdR.mtd.getRandomNumber(1, 6);
		int sum = diceToss1 + diceToss2;
		int nextSum = 0;
		int points = 0;
		if (sum == 2 || sum == 3 || sum == 12) {
			System.out.println("You rolled " + diceToss1 + " + " + diceToss2 + " = " + sum);
			System.out.println("You lose");
		} else if (sum == 7 || sum == 11) {
			System.out.println("You rolled " + diceToss1 + " + " + diceToss2 + " = " + sum);
			System.out.println("You win");
		} else {
			points = sum;
			System.out.println("You rolled " + diceToss1 + " + " + diceToss2 + " = " + sum);
			System.out.println("Points: " + points);

		
		if (points > 0) {
			points = sum;
			while (nextSum != points && sum != 7) {
				nextSum = sum;
				diceToss1 = hdR.mtd.getRandomNumber(1, 6);
				diceToss2 = hdR.mtd.getRandomNumber(1, 6);
				sum = diceToss1 + diceToss2;
				points = sum;
				System.out.println("You rolled " + diceToss1 + " + " + diceToss2 + " = " + sum);
				System.out.println("Points: " + points);
				if (nextSum == sum)
					nextSum = sum;
				else 
					nextSum = 0;
						
				}
			}
			if (sum == 7)
				System.out.println("You lose");
			else
				System.out.println("You win");
		}
		
	
	}
}
