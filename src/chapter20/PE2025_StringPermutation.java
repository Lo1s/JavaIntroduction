/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 24. 11. 2014 2014 10:36:23 
 */
public class PE2025_StringPermutation {

	public static void displayPermutation(String s) {
		displayPermutation("", s);
	}
	
	/** Helper method */
	public static void displayPermutation(String s1, String s2) {
		if (s2.length() > 0)
			for (int i = 0; i < s2.length(); i++) {
				displayPermutation(new StringBuilder(String.valueOf(s1)).append(s2.charAt(i)).toString(), 
						new StringBuilder(String.valueOf(s2.substring(0, i))).append(s2.substring(i + 1)).toString());
			}
		else
			System.out.println(s1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayPermutation("abc");
	}

}
