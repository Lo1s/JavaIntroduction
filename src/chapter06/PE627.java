/**
 * 
 */
package chapter06;

import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE627 {

	/**
	 * 
	 */
	public PE627() {
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
			System.out.print("Two lists are identical");
		else
			System.out.print("Two lists are not identical");
	}
	// Checks if two arrays are identical
	public static boolean equals(int[] list1, int[] list2) {
		java.util.Arrays.sort(list2);
		boolean[] check = new boolean[list1.length];
		for (int i = 0; i < list1.length && i < list2.length; i++) {
			if (list1.length == list2.length && java.util.Arrays.binarySearch(list2, list1[i]) >= 0)
				check[i] = true;
			else {
				check[i] = false;
				break;
			}
		}
		boolean checkFinal = false;
		for (int i = 0; i < check.length; i++) {
			if (check[i])
				checkFinal = true;
			else
				checkFinal = false;
		}
		return checkFinal;
	}


}
