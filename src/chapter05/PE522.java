/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE522 {

	/**
	 * 
	 */
	public PE522() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		double n = input.nextDouble();
		
		System.out.println(mySqrtRoot(n));
	}
	public static double mySqrtRoot(double n) {
		double nextGuess = 2;
		double lastGuess = 1;
		while ((Math.round(lastGuess * 1000) / 1000) != (Math.round(nextGuess * 1000) / 1000)) {
			lastGuess = nextGuess;
			nextGuess = (lastGuess + n / lastGuess) / 2;
		}
		return nextGuess;
	}

}
