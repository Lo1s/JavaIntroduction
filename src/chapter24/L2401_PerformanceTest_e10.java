/**
 * 
 */
package chapter24;

/**
 * @author jslapnicka
 * @Date & @Time 22. 1. 2015 2015 8:44:16 
 */
public class L2401_PerformanceTest_e10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getTime(1000000);
		getTime(10000000);
		getTime(100000000);
		getTime(1000000000);
	}
	
	public static void getTime(long n) {
		long startTime = System.currentTimeMillis();
		long k = 0;
		for (int i = 1; i <= n; i++) {
			k = k + 5;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for n = " + n + " is " + (endTime - startTime) + " milliseconds");
	}

}
