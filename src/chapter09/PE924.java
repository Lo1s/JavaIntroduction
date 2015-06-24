/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 2. 7. 2014 2014 11:09:25 
 */
public class PE924 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStringBuilder2 s1 =
				new MyStringBuilder2(new char[]{'a', 'b', 'c', 'd', 'p'});
		MyStringBuilder2 s2 = new MyStringBuilder2("xyz");
		
		System.out.println("Insert: " + s2.insert(1, s1) + "\n");
		System.out.println("Reverse: " + s2.reverse());
		System.out.println("Substring: " + s1.substring(1));
		System.out.println("To upper case: " + s1.toUpperCase());


		
	}

}

class MyStringBuilder2 {
	private int size = 0;
	private int capacity = 0;
	private char[] buffer;

	public MyStringBuilder2() {
	}

	public MyStringBuilder2(char[] chars) {
		buffer = new char[chars.length];
		size = capacity = chars.length;
		System.arraycopy(chars, 0, buffer, 0, chars.length);
	}

	public MyStringBuilder2(String s) {
		capacity = size = s.length();
		buffer = new char[capacity];

		for (int i = 0; i < s.length(); i++)
			buffer[i] = s.charAt(i);
	}
	public int length() {
		return size;
	}
	public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
		String temp = s.toString();
		char[] result = new char[offset + (buffer.length - offset) + temp.length()];

		for (int i = 0; i < offset; i++) {
			result[i] = buffer[i];
		}

		for (int i = offset; i < (temp.length() + offset); i++) {
			result[i] = temp.charAt(i - offset);
		}

		for (int i = (temp.length() + offset); i < result.length; i++) {
			result[i] = buffer[offset++];
		}

		return new MyStringBuilder2(result);		
	}
	public MyStringBuilder2 reverse() {
		for (int i = 0; i < size /2; i++) {
			char temp = buffer[i];
			buffer[i] = buffer[size - i - 1];
			buffer[size - i - 1] = temp;
		}
		return this;
	}
	public MyStringBuilder2 substring(int begin) {
		char[] result = new char[buffer.length - begin];
		for (int i = begin; i < buffer.length; i++) {
			result[i - begin] = buffer[i]; 
		}

		return new MyStringBuilder2(result);
	}
	public MyStringBuilder2 toUpperCase() {
		for (int i = 0; i < size; i++) {
			buffer[i] = Character.toUpperCase(buffer[i]);
		}
		return this;
	}
	public MyStringBuilder2 append(int i) {
		return append(new MyStringBuilder2(String.valueOf(i)));
	}
	public MyStringBuilder2 append(MyStringBuilder2 s) {
		String temp = s.toString();
		if (capacity < size + temp.length()) {
			increaseCapacity(2 * (size + temp.length()));
		}
		for (int i = 0; i < temp.length(); i++) {
			buffer[i + size] = temp.charAt(i);
		}

		size += temp.length();

		return this;
	}
	private void increaseCapacity(int newCapacity) {
		char[] temp = new char[newCapacity];
		System.arraycopy(buffer, 0, temp, 0, size);
		capacity = newCapacity;
		buffer = temp;
	}
	public String toString() {
		char[] temp = new char[size];
		for (int i = 0; i < size; i++) {
			temp[i] = buffer[i];
		}
		return new String(temp);
	}
}
