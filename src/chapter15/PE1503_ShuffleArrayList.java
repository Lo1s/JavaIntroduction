/**
 * 
 */
package chapter15;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 13:06:15 
 */
@SuppressWarnings("serial")
public class PE1503_ShuffleArrayList extends ArrayList<Number> {
	
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<Number>();
		
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
		
		System.out.println("Before shuffle: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println("\nAfter shuffle: ");
		shuffle(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	
	public static void shuffle(ArrayList<Number> list) {
		double temp = 0;
		
		for (int i = 0; i < list.size(); i++) {
			int random = (int)(Math.random() * ((list.size() - 1) - 0) + 1);
			temp = list.get(i).doubleValue();
			list.set(i, list.get(random));
			list.set(random, (int)temp);
		}
	}
}
