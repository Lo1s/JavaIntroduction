/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author hydRa
 *
 */
public class PE604 {

	/**
	 * 
	 */
	public PE604() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of scores: ");

		// Saving scores into an array
		int[] counters = new int[100];
		for (int number = input.nextInt(); number > 0; number = input.nextInt()) {
			counters[number]++;
		}

		// Counts total sum and number of scores
		int total = 0;
		int totalIndexes = 0;
		for (int i = 0; i < counters.length; i++) {
			total = total + counters[i] * i;
			if (counters[i] > 0)
				totalIndexes++;				
		}

		// Counts an average
		double average = total / totalIndexes;

		// Counts number of scores above/below average
		int aboveAverage = 0;
		int belowAverage = 0;
		int equalsAverage = 0;
		for (int i = 1; i < counters.length; i++) {
			if (counters[i] > 0) {
				if (i / counters[i] > (int)average) {
					aboveAverage++;
				} else if (i / counters[i] < (int)average) {
					belowAverage++;
				} else if (i / counters[i] == (int)average) {
					equalsAverage++;
				}
			} else if (counters[i] == 0) 
				belowAverage++;
		}

		System.out.println("Total is: " + total + "\n"
				+ "Numbers of scores: " + totalIndexes + "\n"
				+ "Average: " + average + "\n"
				+ "Above average: " + aboveAverage + "\n"
				+ "Below average: " + belowAverage + "\n"
				+ "Equals average: " + equalsAverage + "\n");		
	}

}
