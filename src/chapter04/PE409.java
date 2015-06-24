/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
import java.util.Scanner;
public class PE409 {

	/**
	 * 
	 */
	public PE409() {
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
		String student2 = "";
		double score2 = 0;
		
		for (int i = 2; i <= numberOfStudents; i++) {
			System.out.print("Enter the name of the student: ");
			String studentTemp = input.next();
			System.out.print("Enter the score of the student: ");
			double scoreTemp = input.nextDouble();
			student2 = studentTemp;
			score2 = scoreTemp;
			
			if (scoreTemp > score) {
				student2 = student;
				score2 = score;
				student = studentTemp;
				score = scoreTemp;
			}
		
		}
		System.out.println("Student with the highest score of " + (int)score + " is: " + student);
		System.out.print("The second highest score is " + (int)score2 + " and it belongs to: " + student2);
		input.close();

	}

}
