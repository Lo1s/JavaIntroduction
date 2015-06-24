/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE617 {

	/**
	 * 
	 */
	public PE617() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of students: ");
		int numberOfStudents = input.nextInt();

		String[] names = new String[numberOfStudents];
		String[] surnames = new String[numberOfStudents];
		double[] scores = new double[numberOfStudents];

		// Getting the arrays
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.print("Enter the name of the student: ");
			names[i] = input.next();
			surnames[i] = input.next();
			System.out.print("Enter the score of the student: ");
			scores[i] = input.nextDouble();
		}

		// Sorting the arrays in decreasing order

		double tempScores;
		String tempNames;
		String tempSurnames;
		int maxIndex = 0;
		while (maxIndex <= scores.length - 1) {
			for (int i = maxIndex; i < numberOfStudents; i++) {
				if (scores[maxIndex] < scores[i]) {
					tempScores = scores[maxIndex];
					tempNames = names[maxIndex];
					tempSurnames = surnames[maxIndex];
					scores[maxIndex] = scores[i];
					names[maxIndex] = names[i];
					surnames[maxIndex] = surnames[i];
					scores[i] = tempScores;
					names[i] = tempNames;
					surnames[i] = tempSurnames;
				}
			}
			maxIndex++;
		}
		
		for (int i = 0; i < scores.length; i++) {
			System.out.print("Score: [" + scores[i] + "]" + " - " + names[i] + " " + surnames[i] + "\n");
		}
	}
	
}
