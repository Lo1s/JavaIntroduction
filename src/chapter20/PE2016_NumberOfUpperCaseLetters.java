/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 15:22:42 
 */
public class PE2016_NumberOfUpperCaseLetters {
	
	public static int count(char[] chars) {
		return count(chars, chars.length - 1);
	}
	
	/** Auxiliary tail-recursive method */
	public static int count(char[] chars, int high) {
		if (high < 0)
			return 0;
		else 
			return count(chars, high - 1) + (Character.isUpperCase(chars[high]) ? 1 : 0);			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = new char[]{'T', 'e', 'S', 'T', 'i', 'k'};
		System.out.println(count(chars));
	}

}
