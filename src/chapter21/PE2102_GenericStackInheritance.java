/**
 * 
 */
package chapter21;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 12:47:57 
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class PE2102_GenericStackInheritance extends ArrayList {

	public int getSize() {
		return super.size();
	}

	public Object peek() {
		return super.get(super.size() - 1);
	}

	@SuppressWarnings("unchecked")
	public void push(Object o) {
		super.add(o);
	}

	public Object pop() {
		Object o = super.get(getSize() - 1);
		super.remove(getSize() - 1);
		return o;
	}

	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public String toString() {
		return "stack: " + super.toString();
	}
}


