/**
 * 
 */
package chapter15;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author jslapnicka
 * @Date & @Time 3. 9. 2014 2014 14:31:08 
 */
public class L1508_SortComparableObjects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cities = {"Savannah", "Boston", "Atlanta", "Tampa"};
		Arrays.sort(cities);
		for (String city: cities)
			System.out.print(city + " ");
		System.out.println();
		
		BigInteger[] hugeNumbers = {new BigInteger("2323231092923992"), new BigInteger("432232323239292"), new BigInteger("54623239292")};
		Arrays.sort(hugeNumbers);
		
		for (BigInteger number: hugeNumbers)
			System.out.print(number + " ");
	}

}
