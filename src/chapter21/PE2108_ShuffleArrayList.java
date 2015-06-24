/**
 * 
 */
package chapter21;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 8:03:17 
 */
public class PE2108_ShuffleArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> testInt = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++)
			testInt.add(i);
		System.out.println(testInt.toString());
		shuffle(testInt);
		System.out.println(testInt.toString());
	}
	
	public static <E extends Comparable<E>> void shuffle(ArrayList<E> list) {
		E temp;
		for (int i = 0; i < list.size(); i++) {
			int random = (int)(Math.random() * ((list.size() - 1) + 1));
			temp = list.get(i);
			list.set(i, list.get(random));
			list.set(random, temp);
		}
		
	}
}
