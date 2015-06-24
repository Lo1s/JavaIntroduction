/**
 * 
 */
package chapter23;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jslapnicka
 * @Date & @Time 16. 1. 2015 2015 14:45:17 
 */
public class L2302_TestMethodsInCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<String>();
		
		// Add string to the set
		set1.add("London");
		set1.add("Paris");
		set1.add("New York");
		set1.add("San Francisco");
		set1.add("Beijing");
		
		
		System.out.println("set1 is " + set1);
		System.out.println(set1.size() + " elements in the set1");
		
		// Delete a string from the set
		set1.remove("London");
		System.out.println("\nset1 is " + set1);
		System.out.println(set1.size() + " elements in the set1");
		
		// Create set2
		Set<String> set2 = new HashSet<String>();
		set2.add("London");
		set2.add("Shanghai");
		set2.add("Paris");
		System.out.println("\nset2 is " + set2);
		System.out.println(set2.size() + " elements in set2");
		
		System.out.println("\nIs Taipei in set2 ? " + set2.contains("Taipei"));
		set1.addAll(set2);
		System.out.println("\nAfter adding set2 to the set1, set1 is " + set1);
		
		set1.removeAll(set2);
		System.out.println("After removing set2 from the set1, set1 is " + set1);
		
		set1.retainAll(set2);
		System.out.println("After retaining common elements in set2 from set1, set1 is: " + set1);
	}

}
