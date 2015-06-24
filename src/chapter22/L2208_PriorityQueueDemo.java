/**
 * 
 */
package chapter22;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author jslapnicka
 * @Date & @Time 11. 12. 2014 2014 8:55:58 
 */
public class L2208_PriorityQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> queue1 = new PriorityQueue<String>();
		queue1.offer("Oklahoma");
		queue1.offer("Indiana");
		queue1.offer("Georgia");
		queue1.offer("Texas");
		
		System.out.println("Priority queue using Comparable:");
		while (queue1.size() > 0)
			System.out.print(queue1.remove() + " ");
		
		PriorityQueue<String> queue2 = new PriorityQueue<String>(4, Collections.reverseOrder());
		queue2.offer("Oklahoma");
		queue2.offer("Indiana");
		queue2.offer("Georgia");
		queue2.offer("Texas");
		
		System.out.println("\nPriority queue using Comparator:");
		while (queue2.size() > 0) {
			System.out.print(queue2.remove() + " ");
		}
	}

}
