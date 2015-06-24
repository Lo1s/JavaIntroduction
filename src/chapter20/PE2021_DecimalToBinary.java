/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 24. 11. 2014 2014 8:25:53 
 */
public class PE2021_DecimalToBinary {

	
	public static String decimalToBinary(int value) {
		return decimalToBinary(value, 7, "");
	}
	
	public static String decimalToBinary(int value, int index, String binaryString) {
		int mask = 1;
		
		if (index >= 0) {
			int temp = value >> index;
			int bit = temp & mask;
			binaryString += bit;
			return decimalToBinary(value, index - 1, binaryString);
		}
		return binaryString;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decimalToBinary(47));
	}

}
