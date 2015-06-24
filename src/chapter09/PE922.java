/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 2. 7. 2014 2014 8:22:05 
 */
public class PE922 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStringBuilder1 s1 =
				new MyStringBuilder1(new char[]{'A', 'B', 'C', 'D', 'P'});
		MyStringBuilder1 s2 = new MyStringBuilder1("xyz");

		System.out.println(s1.toLowerCase().toString());
		
	    System.out.println(s1.length());
	    System.out.println(s1.charAt(3));
	
	    s2.append(123456789);
	
	    System.out.println(s2.toString());
	    System.out.println(s1.substring(1, 2));
	


	}

}

class MyStringBuilder1 {
	private char[] buffer;
	private int size = 0;
	private int capacity = 0;

	public MyStringBuilder1(String s) {
		capacity = size = s.length();
		this.buffer = new char[capacity];
		
		for (int i = 0; i < s.length(); i++) {
			buffer[i] = s.charAt(i);
		}
	}
	public MyStringBuilder1(char[] chars) {
		buffer = new char[chars.length];
		size = capacity = chars.length;
		System.arraycopy(chars, 0, buffer, 0, chars.length);
	}
	private void increaseCapacity(int newCapacity) {
		char[] temp = new char[newCapacity];
		System.arraycopy(buffer, 0, temp, 0, size);
		capacity = newCapacity;
		buffer = temp;
	}

	public MyStringBuilder1 append(MyStringBuilder1 s) {
		if (capacity < size + s.length()) {
			increaseCapacity(2 * (size + s.length()));
		}
		for (int i = 0; i < s.length(); i++) {
			buffer[i + size] = s.charAt(i);
		}

		size += s.length();

		return this;
	}
	public MyStringBuilder1 append(int i) {
		return append(new MyStringBuilder1(String.valueOf(i)));
	}
	public int length() {
		return size;
	}
	public char charAt(int index) {
		return buffer[index];
	}
	public MyStringBuilder1 toLowerCase() {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = Character.toLowerCase(buffer[i]);
		}

		return this;
	}
	public MyStringBuilder1 substring(int begin, int end) {
		char[] result = new char[end - begin];
		for (int i = begin; i < end; i++) {
			result[i - begin] = buffer[i]; 
		}

		return new MyStringBuilder1(result);
	}
	public String toString() {
		char[] temp = new char[size];
		for (int i = 0; i < size; i++) {
			temp[i] = buffer[i];
		}
		return new String(temp);
	}
}