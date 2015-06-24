/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 17:13:05 
 */
public class PE2017_CharacterOccurence {

	public static int count(char[] chars, char ch) {
		return count(chars, ch, chars.length - 1);
	}
	
	/** Auxiliary recursive method */
	public static int count(char[] chars, char ch, int high) {
		if (high < 0)
			return 0;
		else
			return count(chars, ch, high - 1) + (chars[high] == ch ? 1 : 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = new char[]{'M', 'i', 's', 's', 'i', 's', 's', 'i', 'p', 'p', 'i'};
		System.out.println(count(chars, 's'));		
	}

}
