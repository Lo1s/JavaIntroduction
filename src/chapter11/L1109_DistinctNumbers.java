/**
 * 
 */
package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 15:41:31 
 */
public class L1109_DistinctNumbers {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter integers (input ends with 0): ");
		int value;
		
		do {
			value = input.nextInt();
			
			if (!list.contains(value) && value != 0)
				list.add(value);
		} while (value != 0);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
