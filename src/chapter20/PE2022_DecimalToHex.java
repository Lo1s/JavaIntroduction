/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 24. 11. 2014 2014 8:36:49 
 */
public class PE2022_DecimalToHex {


	public static String decimalToHex(int value) {
		StringBuilder builder = new StringBuilder();
		return decimalToHex(value, builder);			
	}

	public static String decimalToHex(int value, StringBuilder hexString) {
		if (value < 1) {
			return hexString.toString();
		} else {
			if ((value % 16) > 9)
				hexString.insert(0, (char)(65 + value % 16 - 10));
			else
				hexString.insert(0, value % 16);
			return decimalToHex(value / 16, hexString);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decimalToHex(2500));
	}

}
