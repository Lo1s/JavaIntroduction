/**
 * 
 */
package chapter05;

/**
 * @author Jura
 *
 */

public class PE512 {

	/**
	 * 
	 */
	public PE512() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ch1 = '1';
		int ch2 = 'z';
		int numberPerLine = 10;
		
	
		printChars((char)ch1, (char)ch2, numberPerLine);

	}
	public static void printChars(char ch1, char ch2, int numberPerLine) {
		int lineCheck = 0;
		for (int i = 0; ch1 + i <= ch2; i++) {
			System.out.print((char)(ch1 + i) + " ");
			lineCheck++;
			if (lineCheck == 10) {
				System.out.println();
				lineCheck = 0;
			}
			
		}
	}

}
