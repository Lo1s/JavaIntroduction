/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 4. 7. 2014 2014 10:38:02 
 */
public class PE928 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int countNumberPos1 = 0;
		int countNumberPos2 = 0;
		int firstNumber = 0; 
		String operator = "";
		int secondNumber = 0;
		int result = 0;
		if (args.length == 1) {
			for (int i = 0; i < args[0].length(); i++) {
				if (Character.isDigit(args[0].charAt(i)))
					countNumberPos1++;
				else {
					firstNumber = Integer.parseInt(args[0].substring(0, countNumberPos1));
					operator += args[0].charAt(i);
					break;
				}
			}
			for (int i = countNumberPos1 + 1; i < args[0].length(); i++) {
				if (Character.isDigit(args[0].charAt(i)))
					countNumberPos2++;
				if (i == args[0].length() - 1) {
					secondNumber = Integer.parseInt(args[0].substring((i - countNumberPos2) + 1, (i + 1)));
					countNumberPos2 = 0;
					break;
				}
			}
			switch(operator.charAt(0)) {
			case '+': result = firstNumber + secondNumber; break;
			case '-': result = firstNumber - secondNumber; break;
			case '*': result = firstNumber * secondNumber; break;
			case '/': result = firstNumber / secondNumber; break;
			}
			System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
		} else if (args.length > 1) {
			switch (args[1].charAt(0)) {
			case '+': result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]); break;
			case '-': result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]); break;
			case '*': result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]); break;
			case '/': result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]); break;
			}
			System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);		
		}
			
	}

}
