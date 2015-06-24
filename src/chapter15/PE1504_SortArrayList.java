/**
 * 
 */
package chapter15;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 13:29:13 
 */
public class PE1504_SortArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Number> list = new ArrayList<Number>();

		for (int i = 0; i < 20; i++) {
			list.add(i);
		}

		System.out.println("Before shuffle: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	
		System.out.println("\nAfter shuffle: ");
		PE1503_ShuffleArrayList.shuffle(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println("\nAfter sort: ");
		sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}

	public static void sort(ArrayList<Number> list) {
		Number min; 

		for (int i = 0; i < list.size(); i++) {
			min = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (min.doubleValue() > list.get(j).doubleValue()) {
					min = list.get(j);
					list.set(j, list.get(i));
					list.set(i, min);
				}
			}
		}
	}

}
