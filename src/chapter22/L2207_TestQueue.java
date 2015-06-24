/**
 * 
 */
package chapter22;


/**
 * @author jslapnicka
 * @Date & @Time 11. 12. 2014 2014 8:52:30 
 */
public class L2207_TestQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Queue<String> queue = new java.util.LinkedList<String>();
		queue.offer("Oklahoma");
		queue.offer("Indiana");
		queue.offer("Georgia");
		queue.offer("Texas");
		
		while (queue.size() > 0)
			System.out.print(queue.remove() + " ");
		System.out.print("\nsize: " + queue.size());
	}

}
