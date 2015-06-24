/**
 * 
 */
package chapter10;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 9:04:04 
 */
public class PE1005_PrimeFactors {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int number = input.nextInt();
		
		L1008_StackOfIntegers stack = new L1008_StackOfIntegers();
		
		int denominator = 2;
		do {
			if (number % denominator != 0)
				denominator++;
			
			if (number % denominator == 0) {
				stack.push(denominator);
				number /= denominator;
			} 
		} while (number != 1);
		
		
		while (stack.getSize() != 0) {
			System.out.print(stack.pop() + " ");
		}
		
	}

}

