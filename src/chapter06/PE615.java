/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE615 {

	/**
	 * 
	 */
	public PE615() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[10];
		hdR.mtd.createArray(test);
		
		test = hdR.mtd.distinctNumbers(test);
		for (int i = 0; i < test.length; i++) {
			if (test[i] > 0)
				System.out.print(test[i] + " ");
		}
	}

}
