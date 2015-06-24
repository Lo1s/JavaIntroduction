/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
public class PE444 {

	/**
	 * 
	 */
	public PE444() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int randomX = 0;
		int randomY = 0;
		double sector1 = 0;
		double sector2 = 0;
		double sector3 = 0;
		double sector4 = 0;
		final int HITS = 1000000;
		
		for (int i = 1; i <= HITS; i++) {
			randomX = hdR.mtd.getRandomNumber(-10, 10);
			randomY = hdR.mtd.getRandomNumber(-10, 10);
			// sector 1
			if (randomX <= 0)
				sector1++;
			// sector 2
			if (randomX >= 0 && randomY >= 0 && (randomX + randomY >= 10))
				sector2++;
			// sector 3
			if (randomX >= 0 && randomY >= 0 && (randomX + randomY <= 10))
				sector3++;
			// sector 4
			if (randomX >= 0 && randomY <= 0)
				sector4++;
		}
		System.out.println("Probability for sector 1 is: " + ((sector1 / (double)HITS) * 100.0));
		System.out.println("Probability for sector 2 is: " + ((sector2 / (double)HITS) * 100.0));
		System.out.println("Probability for sector 3 is: " + ((sector3 / (double)HITS) * 100.0));
		System.out.println("Probability for sector 4 is: " + ((sector4 / (double)HITS) * 100.0));

	}		
}
