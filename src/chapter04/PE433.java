package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE433 {

	/**
	 * 
	 */
	public PE433() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 5; i < 10000; i++) {
			int number = 0;
			for (int j = i - 1; j > 0; j--) {
				if (i % j == 0) {
					number += j;
					if (number == i && j == 1)
					System.out.print(i + " ");
				}
			}
		}

	}

}
