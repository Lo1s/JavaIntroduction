/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 27. 6. 2014 2014 10:27:32 
 */
public class PE903 {

	/**
	 * A password must have at least eight characters.
	 * A password consists of only letters and digits.
	 * A password must contain at least two digits.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a password");
		System.out.println("A password must have at least eight characters\n"
				+ "A password consists of only letters and digits.\n"
				+ "A password must contain at least two digits.\n");
		String password = input.nextLine();
		
		System.out.println(isValid(password) ? "Valid Password" : "Invalid Password");
	}
	// Checks if the format of the password is valid
	public static boolean isValid(String pass) {
		boolean eightChars = false;
		boolean lettersDigitsOnly = false;
		boolean twoDigits = false;
		
		// Check the length of the password
		if (pass.length() >= 8)
			eightChars = true;
		else {
			System.out.println("Password is too short !");
			return false;
		}
		
		// Checks if only letters and numbers are included
		for (int i = 0; i < pass.length(); i++) {
			if (!Character.isLetterOrDigit(pass.charAt(i))) {
				System.out.println("Password must include only letters and numbers !");
				return false;
			}
		}
		lettersDigitsOnly = true;
		
		// Checks if at least two digits are included
		int counter = 0;
		for (int i = 0; i < pass.length(); i++) {
			if (Character.isDigit(pass.charAt(i)))
				counter++;
		}
		
		if (counter < 2) {
			System.out.println("Password must include at least two numbers !");
			return false;
		} else
			twoDigits = true;
		
		if (!eightChars || !lettersDigitsOnly || !twoDigits)
			return false;
		return true;
	}

}
