/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 9. 7. 2014 2014 10:59:23 
 */
public class PE1003_Client {
	public static void main(String[] args) {
		PE1003_MyInteger test = new PE1003_MyInteger(123456789);
		System.out.println(test.getValue());
		System.out.println(PE1003_MyInteger.isEven(test));
		System.out.println(PE1003_MyInteger.isEven(123456789));
		System.out.println(PE1003_MyInteger.isOdd(test));
		System.out.println(PE1003_MyInteger.isOdd(123456789));
		System.out.println(test.equals(test));
		System.out.println(test.equals(123456789));
		
		System.out.println(PE1003_MyInteger.parseInt("123456789"));
		char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println(PE1003_MyInteger.parseInt(chars));
	}
	
}
