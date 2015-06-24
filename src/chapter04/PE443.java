package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE443 {

	/**
	 * 
	 */
	public PE443() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of seconds: ");
		int numberOfSeconds = input.nextInt();
		long startTime = System.currentTimeMillis() / 1000;
		long endTime = startTime + numberOfSeconds;
		
		while (System.currentTimeMillis() / 1000 < endTime) {
			while (startTime != System.currentTimeMillis() / 1000) {
				startTime += 1;
				if (endTime - startTime > 1)
					System.out.println((endTime - startTime) + " seconds remaining.");
				else if (endTime - startTime == 1)
					System.out.println("1 second remaining");
			}	
		}
		System.out.println("Stopped.");
		
		

	}

}
