/**
 * 
 */
package chapter25;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 29. 6. 2015 2015 10:48:48 
 */
public class PE2511_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE2511_HeapCloneEquals<Integer> test = new PE2511_HeapCloneEquals<Integer>();
		for (int i = 0; i < 10; i++) {
			int temp = (int)(Math.random() * 100);
			test.add(temp);
		}
		
		ArrayList<Integer> cloneTest = new ArrayList<Integer>();
		// cloneTest = test.clone();
		cloneTest.add(5);
		System.out.println("Equal ? " + test.equals(cloneTest));
	}
	
	public static void displayArray(Integer[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]);
			if (i < list.length - 1)
				System.out.print(", ");
			else
				System.out.println();
		}
	}

}
