package chapter05;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
public class PE501 {

	/**
	 * 
	 */
	public PE501() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		while (i <= 100) {
			for (int l = 1; l <= 10; l++) {
				System.out.print(getPentagonalNumber(i) + " ");
				i++;
			}
			System.out.println();
			
		}

	}
	
	public static int getPentagonalNumber(int num) {
		int n = num * (3 * num - 1)/2;
		return n;
	}

}
