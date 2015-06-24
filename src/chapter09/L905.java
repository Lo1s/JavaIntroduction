/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 26. 6. 2014 2014 12:25:06 
 */
public class L905 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: java L905 \"operand1 operator operand2\"");	
			System.exit(1);
		}
		
		int result = 0;
		
		// Split the args
		String[] tokens = args[0].split(" ");
		
		// Calculate the operands by the operator
		switch(tokens[1].charAt(0)) {
			case '+': result = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]); break;
			case '-': result = Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]); break;
			case '*': result = Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]); break;
			case '/': result = Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]); break;
		}
		
		// Display thte result 
		System.out.println(tokens[0] + ' ' + tokens[1] + ' ' + tokens[2] + " = " + result);
		
		
	}

}
