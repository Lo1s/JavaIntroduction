/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 10:58:48 
 */
public class PE2010_CharacterCount {

	static int count = 0;

	public static int count(String str, char c) {
		if (str.length() == 0)
			return count;
		else {
			if (c == str.charAt(0))
				count++;
			return count(str.substring(1), c);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("Mississippi", 's'));
	}

}
