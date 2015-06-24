/**
 * 
 */
package chapter23;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jslapnicka
 * @Date & @Time 16. 1. 2015 2015 14:40:03 
 */
public class L2301_TestHashSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set = new HashSet<String>();
		
		// Add strings to the set
		set.add("Paris");
		set.add("New York");
		set.add("London");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		
		System.out.println(set);
		
		// Display the elements in the hash set via iterator
		for (String element: set) {
			System.out.print(element.toUpperCase() + " ");
		}
		
		
	}

}
