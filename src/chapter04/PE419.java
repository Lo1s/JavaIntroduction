package chapter04;
/**
 * Listing 4.19
 */

/**
 * @author jslapnicka
 *
 */
public class PE419 {

	/**
	 * 
	 */
	public PE419() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m;
		for (int i = 1; i <= 128; i = i * 2) {
			int k = 1;
			for (int j = 128; j >= 1; j = j / 2) {
				if (j > i) {
					System.out.print("    ");
				} else if (j == i || j < i) {
					System.out.printf("%4d", k);
					k = k + k ;
				}
			}
			m = i;
			for (int l = 1; l <= 64; l = l + l){
			int n = m/2;
				if ((n) >= 1) {
					System.out.printf("%4d", n);
					m = m/2;
				} else {
						break;
					
				}
							}
			System.out.println();
		}

	}

}
