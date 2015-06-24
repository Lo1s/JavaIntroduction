/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 10:26:17 
 */
public class PE2008_ReverseInteger {

	static int temp = 0;
	
	public static void reverseDisplay(int value) {		
		if (value != 0) {
			System.out.print(value % 10);
			value = value / 10;
			reverseDisplay(value);
		}
			 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = 12345;
		reverseDisplay(test);		
	}

}
