/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 20. 11. 2014 2014 17:12:37 
 */
public class L2010_ComputeFactorialTailRecursion {

	public static long factorial(int n) {
		return factorial(n, 1); // Call auxiliary method
	}
	
	/** Auxiliary trail-recursive method for factorial */
	private static long factorial(int n, int result) {
		if (n == 0)
			return result;
		else
			return factorial(n - 1, n * result); // Recursive call
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Factorial of " + 5 + " is " + factorial(5));
	}

}
