/**
 * 
 */
package chapter22;

import java.util.PriorityQueue;

/**
 * @author hydRa
 * @Date & @Time 18. 12. 2014 2014 12:25:42 
 */
public class PE2212_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> test = new PriorityQueue<Integer>();
		PE2212_MyPriorityQueue<Integer> cloneable = new PE2212_MyPriorityQueue<Integer>();
		cloneable.add(1);
		cloneable.add(3);
		cloneable.add(3);
		cloneable.add(7);
		
		System.out.println(cloneable);
		System.out.println(test);
		test = cloneable.clone();
		System.out.println(test);
		System.out.println(test == cloneable);
		
		
	}

}
