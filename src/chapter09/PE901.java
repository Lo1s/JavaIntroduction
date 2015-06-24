/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 26. 6. 2014 2014 13:02:39 
 */
public class PE901 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your Social Security Number (format: DDD-DD-DDDD): ");
		String ssn = input.nextLine();

		System.out.println("Your Social Security Number is " + (ssn.matches("\\d{3}-\\d{2}-\\d{4}") ? "valid" : "invalid"));
	}

}
