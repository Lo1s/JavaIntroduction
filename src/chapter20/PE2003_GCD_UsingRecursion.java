/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 8:57:51 
 */
public class PE2003_GCD_UsingRecursion {

	public static int gcd(int m, int n) {
		if ((m % n) == 0)
			return n;
		else
			return gcd(n, m % n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(100, 25));
	}

}
