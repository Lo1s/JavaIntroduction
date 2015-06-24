/**
 * 
 */
package chapter10;

import java.math.BigDecimal;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 8:28:35 
 */
public class PE1020 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal e = BigDecimal.ONE;
		BigDecimal division = BigDecimal.ONE;

		for (int i = 1; i < 1000; i++) {
			division = division.divide(new BigDecimal(i), 25, BigDecimal.ROUND_UP);
			e = e.add(division);

			if (i % 100 == 0)
				System.out.println(e);				
		}
	}
}
