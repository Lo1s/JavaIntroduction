/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 20. 8. 2014 2014 10:42:57 
 */
public class PE1401_NumberFormatException {

	/**
	 * 
	 */

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("Usage: java L905 \"operand1 operator operand2\"");	
			System.exit(1);
		}
		
		int result = 0;
		
		// Split the args
		String[] tokens = args[0].split(" ");
		
		int num1;
		int num2;
		try {
			num1 = Integer.parseInt(tokens[0]);
		}
		catch (NumberFormatException ex) {
			System.out.println((new StringBuilder("Wrong input: ")).append(tokens[0].toString()));
			return;
		}
		
		try {
			num2 = Integer.parseInt(tokens[2]);
		}
		catch (Exception ex) {
			System.out.println((new StringBuilder("Wrong input: ")).append(tokens[2].toString()));
			return;
		}
		
		// Calculate the operands by the operator
		switch(tokens[1].charAt(0)) {
			case '+': result = num1 + num2; break;
			case '-': result = num1 - num2; break;
			case '*': result = num1 * num2; break;
			case '/': result = num1 / num2; break;
		}
		
		// Display thte result 
		System.out.println(tokens[0] + ' ' + tokens[1] + ' ' + tokens[2] + " = " + result);
	}
}