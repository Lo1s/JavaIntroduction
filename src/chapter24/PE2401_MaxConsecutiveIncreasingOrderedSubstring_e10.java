/**
 * 
 */
package chapter24;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 23. 1. 2015 2015 8:16:09 
 */
public class PE2401_MaxConsecutiveIncreasingOrderedSubstring_e10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.next();
		input.close();

		System.out.println(findConsecutiveOrderedSubstring(s));
	}

	public static String findConsecutiveOrderedSubstring(String s) {
		StringBuilder builder = new StringBuilder();
		StringBuilder tempBuilder = new StringBuilder();
		char minChar = s.charAt(0);
		tempBuilder.append(minChar);

		// Algorithm with time complexity O(n)
		for (int i = 1; i < s.length(); i++) {
			if (minChar < s.charAt(i)) {
				tempBuilder.append(s.charAt(i));
				minChar = s.charAt(i);
			}
			if (minChar > s.charAt(i) || i == (s.length() - 1)) {
				if (tempBuilder.length() > builder.length())
					builder.replace(0, builder.length(), tempBuilder.toString());
				tempBuilder.delete(0, tempBuilder.length());
				minChar = s.charAt(i);
				tempBuilder.append(minChar);
			}

		}

		return builder.toString();
	}

}
