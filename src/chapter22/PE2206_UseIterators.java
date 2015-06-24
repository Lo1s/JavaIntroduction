/**
 * 
 */
package chapter22;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * @author jslapnicka
 * @Date & @Time 12. 12. 2014 2014 10:54:47 
 */
public class PE2206_UseIterators {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		
		for (int i = 0; i < 500000; i++) {
			numbers.add(i);
			
		}
		
		Iterator<Integer> iterator = numbers.iterator();
		
		long startTimeIterator = System.currentTimeMillis();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		long endTimeIterator = System.currentTimeMillis();
		
		
		long startTimeGet = System.currentTimeMillis();
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		long endTimeGet = System.currentTimeMillis();
		
		System.out.println("Iterator: " + (endTimeIterator - startTimeIterator) / 1000); 
		System.out.println("Get: " + (endTimeGet - startTimeGet) / 1000);
	}

}
