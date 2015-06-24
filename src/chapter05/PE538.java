/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE538 {

	/**
	 * 
	 */
	public PE538() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lineCheck = 0;
		for (int i = 1; i <= 100; i++) {
			System.out.print(hdR.mtd.getRandomUpperCaseLetter());
			lineCheck++;
			if (lineCheck == 10) {
				System.out.println();
				lineCheck = 0;
			}
		}
		System.out.println("\n\n");
		for (int i = 1; i <= 100; i++) {
			System.out.print(hdR.mtd.getRandomDigitCharacter());
			lineCheck++;
			if (lineCheck == 10) {
				System.out.println();
				lineCheck = 0;
			}
		}

	}

}
