/**
 * 
 */
package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 17. 7. 2014 2014 15:38:56 
 */
public class PE1104_ArrayListMax {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter list of Integers in order to find its maximum (input ends with the 0): ");
		Integer value = new Integer(input.nextInt());
		
		while (!value.equals(0)) {
			list.add(value);
			value = new Integer(input.nextInt());
		}
		
		System.out.println("The max is: " + max(list));
	}
	// Returns max from the ArrayList
	public static Integer max(ArrayList<Integer> list) {
		Integer max = list.get(0);
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max)
				max = list.get(i);
		}
		
		if (list.size() == 0 || list.contains(null))
			return null;
		else
			return max;
	}
}
