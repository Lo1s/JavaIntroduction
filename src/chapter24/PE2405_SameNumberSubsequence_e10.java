/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 23. 1. 2015 2015 18:15:09 
 */
public class PE2405_SameNumberSubsequence_e10 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a series of numbers ending with 0: ");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int temp;
		do {
			temp = input.nextInt();
			numbers.add(temp);
		} while (temp != 0);
		
		int[] result = findSubsequence(numbers);
		int index = result[0];
		int count = result[1];
		int value = result[2];
		
		input.close();
		System.out.print("The longest same number sequence starts at index " + index + " with " + count + " values of " + value);
	}
	
	public static int[] findSubsequence(ArrayList<Integer> numbers) {
		int[] result = new int[3];
		int tempIndex = -1;
		int tempCount = 0;
		int tempValue = -1;
		int compareValue;
		
		// worst-case time complexity O(n)
		for (int i = 0; i < numbers.size(); i++) {
			compareValue = numbers.get(i);
			if (compareValue != 0 && numbers.get(i + 1) == compareValue) {
				tempIndex = (tempIndex == -1 ? i : tempIndex);
				tempCount = (tempCount == 0 ? 1 : tempCount);
				tempCount++;
				tempValue = numbers.get(i);
			} else if (compareValue == 0) {
				return result;
			} else {
				if (tempCount > result[1]) {
					result[0] = tempIndex;
					result[1] = tempCount;
					result[2] = tempValue;
				}
				tempIndex = -1;
				tempValue = -1;
				tempCount = 0;
			}
		}		
		return result;
	}

}
