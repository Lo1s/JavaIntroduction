/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 10:11:22 
 */
public class PE2007_FibonacciSeries {

	static int count;
	
	/** Auxiliary trail-recursive method */
	private static long fib(int n) {
		count++;
		if (n == 0) {
			return 0;
		} if (n == 1) {
			return 1;
		} else
			return fib(n - 1) + fib(n - 2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Fibonacci number on " + 5 + " index is " + fib(10));
		System.out.println("Number of calls: " + count);
	}

}
