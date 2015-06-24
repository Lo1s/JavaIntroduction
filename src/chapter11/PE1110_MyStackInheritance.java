/**
 * 
 */
package chapter11;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 21. 7. 2014 2014 12:52:08 
 */
public class PE1110_MyStackInheritance extends ArrayList<Object> {

	static final long serialVersionUID = 0;
	
	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	public int getSize() {
		return super.size();
	}
	
	public Object peek() {
		return super.get(getSize() - 1);
	}
	
	public Object pop() {
		Object o = super.get(getSize() - 1);
		super.remove(getSize() - 1);
		return o;
	}
	
	public void push(Object o) {
		super.add(o);
	}
	
	@Override
	public String toString() {
		return "stack: " + super.toString();
	}
}