/**
 * 
 */
package chapter22;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author hydRa
 * @Date & @Time 18. 12. 2014 2014 12:20:06 
 */
@SuppressWarnings("serial")
public class PE2212_MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {
	
	@Override
	public PE2212_MyPriorityQueue<E> clone() {
		Iterator<E> iterator = this.iterator();
		PE2212_MyPriorityQueue<E> list = new PE2212_MyPriorityQueue<E>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		
		return list;
	}
}
