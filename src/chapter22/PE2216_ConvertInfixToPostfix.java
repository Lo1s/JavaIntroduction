/**
 * 
 */
package chapter22;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 12. 1. 2015 2015 15:40:14 
 */
public class PE2216_ConvertInfixToPostfix {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an expression: ");
		System.out.print(infixToPostfix(input.nextLine()));
		input.close();
		// 1+2 * (200 - 3545 * (2-(3+5))) *(((2)))
	}

	public static String infixToPostfix(String expression) {
		expression = insertBlanks("(" + expression + ")");

		String[] expressionSplit = expression.split(" ");
		LinkedList<Character> operators = new LinkedList<Character>();
		String result = "";

		for (int i = 0; i < expressionSplit.length; i++) {
			if (expressionSplit[i].length() > 0) {
				// Extract brackets
				if (expressionSplit[i].equals("(") ) {
					int numberOfConsecutiveBrackets = expressionSplit[i].length();
					for (int j = 0; j < numberOfConsecutiveBrackets; j++)
						operators.offer(expressionSplit[i].charAt(j));
				} else if (expressionSplit[i].equals(")")) {
					while (operators.getLast() != '(') {
						result += operators.pollLast() + " ";
					}
					if (operators.getLast() == '(')
						operators.removeLast();
				}	
				// Extract operators
				if (expressionSplit[i].charAt(0) == '+' || expressionSplit[i].charAt(0) == '-') {
					while (operators.getLast() == '*' || 
							operators.getLast() == '/' || 
							operators.getLast() == '+' || 
							operators.getLast() == '-')
						result += operators.pollLast() + " ";
					operators.offer(expressionSplit[i].charAt(0));
				}
				if (expressionSplit[i].charAt(0) == '*') {
					while (operators.getLast().equals('*') || operators.equals('/'))
						result += operators.pollLast() + " ";						
					operators.addLast(expressionSplit[i].charAt(0));
				}
				// Extract numbers
				if (expressionSplit[i].matches("[0-9]+")) {
					result += expressionSplit[i] + " ";
				}

			}
		}
		System.out.println(operators);

		return result;
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
