/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 14:00:09 
 */
public class PE2014_NumberOfUpperCaseLetters {

	public static int countUpperCase(String s) {
		return countUpperCase(s, 0);
	}

	/** Auxiliary method */
	private static int countUpperCase(String s, int count) {
		if (s.length() == 0)
			return count;
		else  {
			if (Character.isUpperCase(s.charAt(0)))
				count++;
		}
		return countUpperCase(s.substring(1, s.length()), count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countUpperCase("TesTiCek"));
	}

}
