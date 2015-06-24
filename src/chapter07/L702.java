/**
 * 
 */
package chapter07;

/**
 * @author hydRa
 *
 */
public class L702 {

	/**
	 * 
	 */
	public L702() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] answers = {
				{'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
				{'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
				{'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
				{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
		
		char[] key = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
		
		for (int row = 0; row < answers.length; row++) {
			int counter = 0;
			for (int column = 0; column < answers[row].length; column++) {
				if (answers[row][column] == key[column])
					counter++;
			}
			System.out.println("Student " + (answers.length - row) + "'s correct count is: " + counter);
		}
	}

}
