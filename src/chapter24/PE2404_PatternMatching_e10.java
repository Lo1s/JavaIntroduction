/**
 * 
 */
package chapter24;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 23. 1. 2015 2015 18:01:25 
 */
public class PE2404_PatternMatching_e10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();
		
		input.close();
		System.out.print("matched at index: " + match(s1, s2));
	}
	
	public static int match(String s1, String s2) {
		int count = 0;
		int index = -1;
		// worst-case time complexity is O(n);
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(count)) {
				if (count == 0) {
					index = i;	
				}
				if (count == s2.length() - 1)
					break;
				else
					count++;
			} else {
				if (s1.charAt(i) == s2.charAt(0)) {
					index = i;
					count = 1;
				} else {
					count = 0;
					index = -1;
				}
			}
		}

		return index;
	}

}
