package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE445 {

	/**
	 * 
	 */
	public PE445() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 1; i <= 7; i++) {
			int j = i + 1;
			while (j <= 7) {
				System.out.println(i + " " + j);
				count++; 
				j++;
			}
		}
		System.out.println("The total number of combination is " + count);

	}

}
