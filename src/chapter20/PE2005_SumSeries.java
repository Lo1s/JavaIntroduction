/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 9:54:35 
 */
public class PE2005_SumSeries {

	public static double m(int i) {
		if (i == 1)
			return (double)i/3;
		else
			return ((double)i / (2 * (double)i + 1)) + m(i - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println("m(" + i + "): " + m(i));
		}
	}

}
