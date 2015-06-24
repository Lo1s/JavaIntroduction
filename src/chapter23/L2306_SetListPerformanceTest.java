/**
 * 
 */
package chapter23;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;


/**
 * @author jslapnicka
 * @Date & @Time 19. 1. 2015 2015 9:08:42 
 */
public class L2306_SetListPerformanceTest {

	/**
	 * @param args
	 */
	
	static final int N = 50000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		
		Collection<Integer> set1 = new HashSet<Integer>(list);
		System.out.println("Member test time for hash set is: " + getTestTime(set1) + " milliseconds");
		System.out.println("Remove element time for hash set is " + getRemoveTime(set1) + " milliseconds");
		
		Collection<Integer> set2 = new LinkedHashSet<Integer>(list);
		System.out.println("Member test time for linked hash set is: " + getTestTime(set2) + " milliseconds");
		System.out.println("Remove element time for linked hash set: " + getRemoveTime(set2) + " milliseconds");
		
		Collection<Integer> set3 = new TreeSet<Integer>(list);
		System.out.println("Member test time for tree set is: " + getTestTime(set3) + " milliseconds");
		System.out.println("Remove element time for tree set: " + getRemoveTime(set3) + " milliseconds");
		
		Collection<Integer> list1 = new ArrayList<Integer>(list);
		System.out.println("Member test time for array list is: " + getTestTime(list1) + " milliseconds");
		System.out.println("Remove element test time for array list is: " + getRemoveTime(list1) + " milliseconds");
		
		Collection<Integer> list2 = new LinkedList<Integer>(list);
		System.out.println("Member test time for linked list is: " + getTestTime(list2) + " milliseconds");
		System.out.println("Remove element test time for linked list is: " + getRemoveTime(list2) + " milliseconds");
		
	}
	
	public static long getTestTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		
		// Test if a member is in the collection
		for (int i = 0; i < N; i++) {
			c.contains((int)(Math.random() * 2 * N));
		}
		return System.currentTimeMillis() - startTime;
	}
	
	public static long getRemoveTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < N; i++) {
			c.remove(i);
		}
		
		return System.currentTimeMillis() - startTime;
	}

}
