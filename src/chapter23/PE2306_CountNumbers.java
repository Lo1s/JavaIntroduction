/**
 * 
 */
package chapter23;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author jslapnicka
 * @Date & @Time 20. 1. 2015 2015 14:50:02 
 */
public class PE2306_CountNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, Integer> mapInput = new TreeMap<Integer, Integer>();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter numbers (input ends with the 0 entered): ");
		int number;
		while ((number = input.nextInt()) != 0) {
			if (mapInput.containsKey(number)) {
				mapInput.replace(number, mapInput.get(number), mapInput.get(number) + 1);
			} else {
				mapInput.put(number, 1);
			}
		}
		
		
		/*int max = 0;
		for (int i = 1; i < mapInput.size(); i++) {
			if (mapInput.get(i) > max)
				max = mapInput.get(i);
		}*/
		
		int max = Collections.max(mapInput.values());
		
		HashSet<Integer> result = new HashSet<Integer>();
		for (int i = 1; i < mapInput.size(); i++) {
			if (mapInput.get(i) == (max))
				result.add(i);
		}
		
		System.out.println(result);
		input.close();
	}

}
