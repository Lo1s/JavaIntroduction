/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
import java.util.Scanner;
public class PE408 {

	/**
	 * 
	 */
	public PE408() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter number of students: ");
		int numberOfStudents = input.nextInt();
		
		System.out.print("Enter the name of the student: ");
		String student = input.next();
		System.out.print("Enter the score of the student: ");
		double score = input.nextDouble();
		
		for (int i = 2; i <= numberOfStudents; i++) {
			System.out.print("Enter the name of the student: ");
			String studentTemp = input.next();
			System.out.print("Enter the score of the student: ");
			double scoreTemp = input.nextDouble();
			
			if (scoreTemp > score) {
				student = studentTemp;
				score = scoreTemp;
			}
		}
		System.out.print("Student with the highest score of " + (int)score + " is: " + student);
		input.close();

	}

}
