/**
 * 
 */
package chapter21;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 8:19:09 
 */
public class PE2109_SortArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> testInt = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++)
			testInt.add(i);
		System.out.println("Original: " + testInt.toString());
		PE2108_ShuffleArrayList.shuffle((testInt));
		System.out.println("Shuffled: " + testInt.toString());
		sort(testInt);
		System.out.println("Sorted: " + testInt.toString());
	}

	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			int minIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).compareTo(list.get(minIndex)) < 0)
					minIndex = j;
			}
			E temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
		}
	}
}
