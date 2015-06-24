package chapter05;
/**
 * 
 */

/**
 * @author Jura
 *
 */
public class L501 {

	/**
	 * 
	 */
	public L501() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		int j = 2;
		int k = max(i, j);
		
		System.out.print("The max of " + i + " and " + j + " is " + k);
	}
	
	public static int max(int num1, int num2) {
		int result;
		
		if (num1 > num2) 
			result = num1;
			else
				result = num2;
		return result;
	}

}
