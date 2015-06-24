/**
 * 
 */
package chapter23;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jslapnicka
 * @Date & @Time 19. 1. 2015 2015 8:37:43 
 */
public class L2304_TestTreeSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		
		TreeSet<String> treeSet = new TreeSet<String>(set);
		System.out.println("Sorted tree set: " + treeSet);
		
		// Use the methods in SortedSet interface
		System.out.println("first(): " + treeSet.first());
		System.out.println("last(): " + treeSet.last());
		System.out.println("headSet(\"New York\"): " + treeSet.headSet("New York"));
		System.out.println("tailSet(\"New York\"): " + treeSet.tailSet("New York"));
		
		// Use the methods in navigable interface
		System.out.println("lower(\"P\"): " + treeSet.lower("P"));
		System.out.println("higher(\"P\"): " + treeSet.higher("P"));
		System.out.println("floor(\"P\"): " + treeSet.floor("P"));
		System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));
		System.out.println("pollFirst(): " + treeSet.pollFirst());
		System.out.println("pollLast(): " + treeSet.pollLast());
		System.out.println("New tree set: " + treeSet);
	}

}
