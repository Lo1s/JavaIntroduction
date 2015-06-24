/**
 * 
 */
package chapter10;


/**
 * @author jslapnicka
 * @Date & @Time 9. 7. 2014 2014 10:57:52 
 */
public class PE1003_MyInteger {
	private int value;

	public PE1003_MyInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static boolean isEven(int value) {
		return (value % 2 == 0);
	}

	public static boolean isOdd(int value) {
		return (value % 2 != 0);
	}

	public static boolean isPrime(int value) {
		if (value > 1)
			for (int i = 2; i < value; i++)
				if (value % i == 0)
					return false;
				else if (value <= 1)
					return false;
		return true;
	}

	public static boolean isEven(PE1003_MyInteger test) {
		return isEven(test.value);
	}

	public static boolean isOdd(PE1003_MyInteger test) {
		return isOdd(test.value);
	}

	public static boolean isPrime(PE1003_MyInteger test) {
		return isPrime(test.value);
	}

	public boolean equals(int value) {
		return (this.value == value);
	}

	public boolean equals(PE1003_MyInteger test) {
		return equals(test.value);
	}

	public static int parseInt(char[] chars) {
		int result = 0;
		for (int i = 0; i < chars.length; i++) {
			if (i != chars.length - 1) {
				result += chars[i] - '0';
				result *= 10;
			} else
				result += chars[i] - '0';
		}
		return result;
	}
	
	public static int parseInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i != s.length() - 1) {
				result += s.charAt(i) - '0';
				result *= 10;
			} else
				result += s.charAt(i) - '0';
		}
		return result;
	}
}
