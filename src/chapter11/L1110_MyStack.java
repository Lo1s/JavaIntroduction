/**
 * 
 */
package chapter11;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 15:45:57 
 */
public class L1110_MyStack {
	private ArrayList<Object> stack = new ArrayList<Object>();
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int getSize() {
		return stack.size();
	}
	
	public Object peek() {
		return stack.get(getSize() - 1);
	}
	
	public Object pop() {
		Object o = stack.get(getSize() - 1);
		stack.remove(getSize() - 1);
		return o;
	}
	
	public void push(Object o) {
		stack.add(o);
	}
	
	@Override
	public String toString() {
		return "stack: " + stack.toString();
	}
}
