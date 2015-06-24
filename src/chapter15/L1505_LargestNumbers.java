/**
 * 
 */
package chapter15;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 3. 9. 2014 2014 12:49:45 
 */
public class L1505_LargestNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(45);
		list.add(3445.33);
		// Add a BigInteger
		list.add(new BigInteger("3432323234344343101"));
		// Add a BigDecimal
		list.add(new BigDecimal("2.0909090989091343433344343"));
		
		System.out.println("The largest numbers is: " + getLargestNumber(list));
	}
	
	public static Number getLargestNumber(ArrayList<Number> list) {
		if (list == null || list.size() == 0)
			return null;
		
		Number number = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (number.doubleValue() < list.get(i).doubleValue())
				number = list.get(i).doubleValue();
		}
		
		return number;
	}

}
