/**
 * 
 */
package chapter24;



import java.util.Scanner;



/**
 * @author jslapnicka
 * @Date & @Time 23. 1. 2015 2015 8:42:16 
 */
public class PE2402_MaxIncreasingOrderedSubsequence_e10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int LEARN_IT = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.next();
		input.close();
		System.out.print(findOrderedSubstring(s));
	}

	public static String findOrderedSubstring(String s) {
		// store the length of the max substring ending at index i
		int[] maxLength = new int[s.length()];
		// store the index of the previous element in the sequence 
		int[] previous = new int[s.length()];
		// WelcomeWelcopeWelcamez
		
		for (int i = 0; i < s.length(); i++) {
			previous[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				System.out.println(s.charAt(i) + " > " + s.charAt(j) + " | maxLength[i] = " + maxLength[i] + " < " + "maxLength[j] + 1 = " + (maxLength[j] + 1));
				if (s.charAt(i) > s.charAt(j) && maxLength[i] < maxLength[j] + 1) {
					maxLength[i] = maxLength[j] + 1;
					previous[i] = j;
				}
			}
		}
		
		// Find the largest subsequence length and ending index
		int maxL = maxLength[0];
		int index = 0;
		for (int i = 1; i < s.length(); i++) {
			if (maxL < maxLength[i]) {
				maxL = maxLength[i];
				index = i;
			}
		}
		
		// Construct the subsequence by tracing through previous
		char[] chars = new char[maxL + 1];
		int i = maxL;
		while (index != -1) {
			chars[i--] = s.charAt(index);
			index = previous[index];
		}
		
		return new String(chars);
	}

}
