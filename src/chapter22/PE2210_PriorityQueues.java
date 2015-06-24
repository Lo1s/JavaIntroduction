/**
 * 
 */
package chapter22;


import java.util.PriorityQueue;

/**
 * @author hydRa
 * @Date & @Time 17. 12. 2014 2014 12:36:59 
 */
public class PE2210_PriorityQueues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> list1 = new PriorityQueue<String>();
		PriorityQueue<String> list2 = new PriorityQueue<String>();
		
		list1.offer("George");
		list1.offer("Jim");
		list1.offer("John");
		list1.offer("Blake");
		list1.offer("Kevin");
		list1.offer("Michael");
		
		list2.offer("George");
		list2.offer("Katie");
		list2.offer("Kevin");
		list2.offer("Michelle");
		list2.offer("Ryan");
		
		PriorityQueue<String> temp;
		temp = new PriorityQueue<String>(list1);
		temp.addAll(list2);
		System.out.println("union: " + temp);
		
		temp = new PriorityQueue<String>(list1);
		temp.removeAll(list2);
		System.out.println("difference: " + temp);
		
		temp = new PriorityQueue<String>(list1);
		temp.retainAll(list2);
		System.out.println("intersection: " + temp);
	}

}
