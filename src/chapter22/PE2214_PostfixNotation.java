/**
 * 
 */
package chapter22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * @author hydRa
 * @Date & @Time 19. 12. 2014 2014 16:55:27 
 */
public class PE2214_PostfixNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter an expression: ");
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine();
		input.close();
		expression = insertBlanks(expression);

		String[] expressionSplit = expression.split(" ");
		Queue<Integer> operands = new LinkedList<Integer>();
		Queue<Character> operators = new LinkedList<Character>();

		for (int i = 0; i < expressionSplit.length; i++) {
			if (expressionSplit[i].length() > 0 &&  (expressionSplit[i].charAt(0) == '*' || expressionSplit[i].charAt(0) == '/' || expressionSplit[i].charAt(0) == '+'
					|| expressionSplit[i].charAt(0) == '+' || expressionSplit[i].charAt(0) == '-')) {
				operators.add(expressionSplit[i].charAt(0));
				if (operands.size() > 1) {
					operands.add(calculate(operands.poll(), operands.poll(), operators.poll()));
				}
			}
			else if (expressionSplit[i].length() > 0 && Character.isDigit(expressionSplit[i].charAt(0)))
				operands.add(Integer.parseInt(expressionSplit[i]));
		}

		if (operands.size() > 1) {
			operands.add(calculate(operands.poll(), operands.poll(), operators.poll()));
		}

		System.out.println("The result is: " + operands.poll());
	}

	public static int calculate(int number1, int number2, char operator) {
		switch(operator) {
		case '+': return number1 + number2;
		case '*': return number1 * number2;
		case '-': return number1 - number2;
		case '/': return number1 / number2;	
		}

		return 0;

	}

	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
					s.charAt(i) == '+' || s.charAt(i) == '-' ||
					s.charAt(i) == '*' || s.charAt(i) == '/')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}

}
