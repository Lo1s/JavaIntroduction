/**
 * 
 */
package chapter21;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 8:39:18 
 */
public class PE2110_LargestElementInArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> testInt = new ArrayList<Integer>();
		testInt.add(80);
		testInt.add(100);
		testInt.add(500);
		testInt.add(1);
		testInt.add(99);
		System.out.println("max: " + max(testInt));
	}
	
	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).compareTo(max) > 0)
				max = list.get(i);
		}
		return max;
	}

}
