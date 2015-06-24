/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 8:48:58 
 */
public class PE2002_FibonacciNumbers {

	public static long fib(int index) {
		long f0 = 0;
		long f1 = 1;
		long currentFib = 0;
		
		for (int i = 1; i < index; i++) {
			currentFib = f0 + f1;
			f0 = f1;
			f1 = currentFib;
		}
		
		return currentFib;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(10));
	}

}
