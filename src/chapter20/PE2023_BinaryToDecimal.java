/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 24. 11. 2014 2014 8:57:57 
 */
public class PE2023_BinaryToDecimal {

	public static int binaryToDecimal(String binaryString) {
		return binaryToDecimal(binaryString, 0, 0);
	}

	/** Auxiliary tail-recursive method */
	public static int binaryToDecimal(String binaryString, int value, int index) {
		if (index > binaryString.length() - 1)
			return value;
		
		int mask = 1;
		value = value << 1;
		
		if (binaryString.charAt(index) == '1') {
			value = value | mask;
			return binaryToDecimal(binaryString, value, index + 1);
		} else 
			return binaryToDecimal(binaryString, value, index + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binaryToDecimal("11010101"));
	}

}
