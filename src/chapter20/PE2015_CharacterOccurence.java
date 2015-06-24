/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 14:26:44 
 */
public class PE2015_CharacterOccurence {

	public static int count(String str, char c) {
		return count(str, c, str.length() - 1, 0);
	}
	
	
	/** Helper recursive method */
	public static int count(String str, char c, int high, int count) {
		if (high < 0)
			return count;
		else {
			if (c == str.charAt(high))
				count++;
			return count(str, c, --high, count);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("Mississippi", 's'));
	}

}
