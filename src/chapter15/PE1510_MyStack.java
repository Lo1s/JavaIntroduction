/**
 * 
 */
package chapter15;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 5. 9. 2014 2014 14:07:02 
 */
public class PE1510_MyStack implements Cloneable {

	private ArrayList<Object> list = new ArrayList<Object>();

	PE1510_MyStack() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<Object>();
	}


	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getSize() {
		return list.size();
	}

	public Object peek() {
		return list.get(getSize() - 1);
	}

	public Object pop() {
		Object o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}

	public void push(Object o) {
		list.add(o);
	}

	@Override
	public String toString() {
		return "list: " + list.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object clone() throws CloneNotSupportedException {
		PE1510_MyStack stack;
		stack = (PE1510_MyStack)super.clone();
		stack.list = (ArrayList<Object>)list.clone();
		return stack;
	}
}