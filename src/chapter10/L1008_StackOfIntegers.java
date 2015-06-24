/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 7. 7. 2014 2014 14:03:58 
 */
public class L1008_StackOfIntegers {
	private int[] elements;;
	private int size;
	private static final int DEFAULT_CAPACITY = 16;
	
	public L1008_StackOfIntegers() {
		this(DEFAULT_CAPACITY);
	}
	
	public L1008_StackOfIntegers(int capacity) {
		elements = new int[capacity];
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	public int peek() {
		return elements[size - 1];
	}
	
	public void push(int value) {
		if (size >= elements.length) {
			int[] temp = new int[2 * elements.length];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		} 
		elements[size++] = value;
	}
	
	public int pop() {
		return elements[--size];
	}
	
	public int getSize() {
		return size;
	}
}
