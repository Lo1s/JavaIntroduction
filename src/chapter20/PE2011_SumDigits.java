/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 12:53:03 
 */
public class PE2011_SumDigits {

	public static int sumDigits(long n) {
		if (n == 0)
			return 0;
		else
			return (int)(n % 10) + sumDigits(n / 10L);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumDigits(1337));
	}

}
