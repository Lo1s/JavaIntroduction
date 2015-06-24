/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author hydRa
 *
 */
public class PE601 {

	/**
	 * 
	 */
	public PE601() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// Prompts the user for number of students
		System.out.print("Enter a number of students: ");
		int numberOfStudents = input.nextInt();
		
		// Prompts the user for scores and saving them into the array scores
		System.out.print("Enter " + numberOfStudents + " scores: ");
		int[] scores = new int[numberOfStudents];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = input.nextInt();
		}
		
		// Searching for the best
		int bestScore = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (bestScore < scores[i])
				bestScore = scores[i];
		}
		
		// Grading system
		String grade = "";
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= bestScore - 10 || scores[i] == bestScore) {
				grade = "A";
				System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grade);
			} else if (scores[i] >= bestScore - 20) {
				grade = "B";
				System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grade);
			} else if (scores[i] >= bestScore - 30) {
				grade = "C";
				System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grade);
			} else if (scores[i] >= bestScore - 40) {
				grade = "D";
				System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grade);
			}
		}
		
		
			

	}

}
