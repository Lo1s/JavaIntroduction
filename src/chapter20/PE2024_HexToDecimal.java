/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 24. 11. 2014 2014 10:07:17 
 */
public class PE2024_HexToDecimal {

	public static int hexToDecimal(String hexString) {
		return hexToDecimal(hexString, hexString.length() - 1, 0);
	}

	/** Auxiliary tail-recursive method */
	private static int hexToDecimal(String hexString, int index, int value) {
		if (index < 0)
			return value;
		else {
			if (hexString.charAt(hexString.length() - 1 - index) >= 65)
				value += (hexString.charAt(hexString.length() - 1 - index) - 65 + 10) * Math.pow(16, index);
			else {
				value += (hexString.charAt(hexString.length() - 1 - index) - 48) * Math.pow(16, index);
			}
			return hexToDecimal(hexString, index - 1, value);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hexToDecimal("1A2B3C"));
	}

}
