/**
 * 
 */
package chapter07;

/**
 * @author jslapnicka
 *
 */
public class PE703 {

	/**
	 * 
	 */
	public PE703() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Students' answers to the questions
		char[][] answers = {
				{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
				{'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
				{'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
				{'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

		// Key to the questions
		char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

		// Grade all answers
		int[] correctCount = new int[answers.length];
		for (int i = 0; i < answers.length; i++) {
			// Grade one student
			for (int j = 0; j < answers[0].length; j++) {
				if (answers[i][j] == keys[j])
					correctCount[i]++;
			}
		}
		int counter = 0;
		while (counter < answers.length) {
			int min = 0;
			for (int i = 0; i < correctCount.length; i++) {
				if (correctCount[min] >= correctCount[i] && correctCount[i] < 999) {
					min = i;
				}
			}
			System.out.println("Student " + min + "'s correct count is " +
					correctCount[min]);
			correctCount[min] = 999;
			counter++;
		}
	}

}
