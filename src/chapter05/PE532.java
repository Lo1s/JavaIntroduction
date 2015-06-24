/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE532 {

	/**
	 * 
	 */
	public PE532() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int countWin = 0;
		int countLose = 0;
		while (countWin + countLose <= 10000) {
			int diceToss1 = hdR.mtd.getRandomNumber(1, 6);
			int diceToss2 = hdR.mtd.getRandomNumber(1, 6);
			int sum = diceToss1 + diceToss2;
			int nextSum = 0;
			int points = 0;
			if (sum == 2 || sum == 3 || sum == 12) {
				//System.out.println("You rolled " + diceToss1 + " + " + diceToss2 + " = " + sum);
				//System.out.println("You lose");
				countLose++;
			} else if (sum == 7 || sum == 11) {
				//System.out.println("You rolled " + diceToss1 + " + " + diceToss2 + " = " + sum);
				//System.out.println("You win");
				countWin++;
			} else {
				points = sum;
				//System.out.println("You rolled " + diceToss1 + " + " + diceToss2 + " = " + sum);
				//System.out.println("Points: " + points);


				if (points > 0) {
					while (nextSum != points && nextSum != 7) {
						diceToss1 = hdR.mtd.getRandomNumber(1, 6);
						diceToss2 = hdR.mtd.getRandomNumber(1, 6);
						sum = diceToss1 + diceToss2;
						if (sum == points || sum == 7) {
							points = sum;
							nextSum = points;
						} else 
							points = sum;
						//System.out.println("You rolled " + diceToss1 + " + " + diceToss2 + " = " + sum);
						//System.out.println("Points: " + points);
					}
					if (sum == 7)
						countLose++;
						//System.out.println("You lose");
					else
						countWin++;
						//System.out.println("You win");
				}
			}

		}
		System.out.println("Count of wins: " + countWin);
		System.out.println("Count of loses: " + countLose);
	}
}

