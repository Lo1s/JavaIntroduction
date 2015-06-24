/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 10:04:22 
 */
public class PE2006_SumSeries {

	public static double m(int i) {
		if (i == 1)
			return (double)i/2;
		else
			return (double)i / ((double)i + 1) + m(i - 1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println("m(" + i + "): " + m(i));
		}
	}

}
