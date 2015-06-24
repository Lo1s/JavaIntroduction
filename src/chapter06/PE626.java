/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE626 {

	/**
	 * 
	 */
	public PE626() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter list1: ");
		int item = input.nextInt();
		int[] list1 = new int[item];
		for (int i = 0; i < list1.length; i++) {
			list1[i] = input.nextInt();
		}
		
		System.out.print("Enter list2: ");
		int item2 = input.nextInt();
		int[] list2 = new int[item2];
		for (int i = 0; i < list2.length; i++) {
			list2[i] = input.nextInt();
		}
		
		if (equals(list1, list2))
			System.out.print("Two lists are strictly identical");
		else
			System.out.print("Two lists are not identical");
	}
	// Checks if two arrays are strictly identical
	public static boolean equals(int[] list1, int[] list2) {
		boolean check = true;
		for (int i = 0; i < list1.length && i < list2.length && check; i++) {
			if (list1.length == list2.length && list1[i] == list2[i])
				check = true;
			else
				check = false;
		}
		if (check)
			return true;
		else
			return false;
	}

}
