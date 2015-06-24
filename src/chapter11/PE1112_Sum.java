/**
 * 
 */
package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 7. 2014 2014 15:23:33 
 */
public class PE1112_Sum {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter five integers: ");
		for (int i = 0; i < 5; i++) {
			list.add(input.nextInt());
		}
		
		System.out.print("Sum: " + sum(list));
		
	}
	public static int sum(ArrayList<Integer> list) {
		int sum = 0; 
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}

}
