package chapter15;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 10:25:48 
 */

public class PE1518_CalculatorWithRationals {
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java L905 \"operand1 operator operand2\"");	
			System.exit(1);
		}
		
		PE1517_RationalWithBigInteger result = new PE1517_RationalWithBigInteger();
		
		// Split the args
		String[] tokens = args[0].split(" ");
		
		PE1517_RationalWithBigInteger r1 = new PE1517_RationalWithBigInteger(new BigInteger(tokens[0].charAt(0) + ""), 
				new BigInteger(tokens[0].charAt(2) + ""));
		PE1517_RationalWithBigInteger r2 = new PE1517_RationalWithBigInteger(new BigInteger(tokens[2].charAt(0) + ""), 
				new BigInteger(tokens[2].charAt(2) + ""));
		
		// Calculate the operands by the operator
		switch(tokens[1].charAt(0)) {
			case '+': result = r1.add(r2); break;
			case '-': result = r1.subtract(r2); break;
			case '*': result = r1.multiply(r2); break;
			case '/': result = r1.divide(r2); break;
		}
		
		// Display the result 
		System.out.println(tokens[0] + ' ' + tokens[1] + ' ' + tokens[2] + " = " + result);
		
		
	}
}
