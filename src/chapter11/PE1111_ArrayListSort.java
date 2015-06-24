/**
 * 
 */
package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 7. 2014 2014 13:26:24 
 */
public class PE1111_ArrayListSort {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter five integers: ");
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			list.add(Integer.valueOf(input.nextInt()));
		}
		
		System.out.println(list.toString());
		sort(list);
		System.out.println(list.toString());
	}

	public static void sort(ArrayList<Integer> list) {
		int temp = list.get(0);

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
}
