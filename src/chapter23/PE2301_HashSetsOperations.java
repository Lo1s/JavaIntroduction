/**
 * 
 */
package chapter23;

import java.util.HashSet;

/**
 * @author jslapnicka
 * @Date & @Time 19. 1. 2015 2015 12:49:39 
 */
public class PE2301_HashSetsOperations {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set1 = new HashSet<String>();
		set1.add("George");
		set1.add("Jim");
		set1.add("John");
		set1.add("Blake");
		set1.add("Kevin");
		set1.add("Michael");
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("George");
		set2.add("Katie");
		set2.add("Kevin");
		set2.add("Michelle");
		set2.add("Ryan");
		
		// Find union, difference, intersection
		HashSet<String> set1clone = (HashSet<String>)set1.clone();
		System.out.println("Set1: " + set1);
		System.out.println("Set2: " + set2);
		
		set1clone.addAll(set2);
		System.out.println("Union by set1.addAll(set2): " + set1clone);
		
		set1clone = (HashSet<String>)set1.clone();
		set1clone.removeAll(set2);
		System.out.println("Difference by set1.removeAll(set2): " + set1clone);
		
		set1clone = (HashSet<String>)set1.clone();
		set1clone.retainAll(set2);
		System.out.println("Intersection by set1.retailAll(set2): " + set1clone);
	}

}
