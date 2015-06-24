/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 12:17:53 
 */
public class PE2101_RevisingL2101<E> {

	@SuppressWarnings("unchecked")
	private E[] list = (E[])new Number[10];
	private int count = 0;

	public int getSize() {
		int countSize = 0;
		for (int i = 0; i < list.length; i++)
			if (list[i] != null)
				countSize++;
		return countSize;
	}

	public E peek() {
		return list[this.getSize() - 1];
	}

	@SuppressWarnings("unchecked")
	public void push(E o) {
		list[count++] = o;
		if (count > list.length - 1) {
			E[] tempList = (E[])new Number[list.length * 2];
			for (int i = 0; i < list.length; i++)
				tempList[i] = list[i];
			list = tempList;
		}
	}

	public E pop() {
		E o = list[getSize() - 1];
		list[getSize() - 1] = null;
		return o;
	}

	public boolean isEmpty() {
		if (this.getSize() == 0)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("stack: [");
		for (int i = 0; i < list.length; i++)
			if (list[i] != null)
				builder.append(list[i] + ", ");
		builder.append("]");
		return builder.toString();
	}
}
