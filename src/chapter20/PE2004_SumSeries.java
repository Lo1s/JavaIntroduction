/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 9:19:18 
 */
public class PE2004_SumSeries {

	public static double m(int i) {
		if (i == 1)
			return 1;
		else
			return m(i - 1) + 1 / (double)i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println("m(" + i + "): " + m(i));
		}
	}
}
