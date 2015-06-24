/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 7:37:09 
 */
public class L2101_GenericStack<E> {
	
	private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
	
	public int getSize() {
		return list.size();
	}
	
	public E peek() {
		return list.get(list.size() - 1);
	}
	
	public void push(E o) {
		list.add(o);
	}
	
	public E pop() {
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
}
