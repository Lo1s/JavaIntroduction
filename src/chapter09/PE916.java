/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 10:19:11 
 */
public class PE916 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyString1 s = new MyString1(new char[] {'a', 'b', 'c'});
		System.out.println("charAt: 1: " + s.charAt(1));
		System.out.println("Length: " + s.length());
		System.out.println("SubString 1-2: ");
		for (int i = 0; i < s.substring(1, 3).length(); i++) {
			System.out.println(s.substring(1, 3).charAt(i));
		}
		MyString1 test = new MyString1(new char[]{'A', 'H', 'O', 'J', 'I', 'k'});
		for (int i = 0; i < test.length(); i++) {
			System.out.println(test.toLowerCase().charAt(i));			
		}
		MyString1 s2 = new MyString1(new char[]{'a', 'b', 'd'});
		System.out.println(s.equals(s2));
		for (int i = 0; i < MyString1.valueOf(1337331).length(); i++) {
			System.out.println(MyString1.valueOf(1337331).charAt(i));
		}
	}
}

class MyString1 {
	private char[] chars;

	public MyString1(char[] chars) {
		this.chars = new char[chars.length];
		System.arraycopy(chars, 0, this.chars, 0, chars.length);
	}

	public char charAt(int index) {
		return chars[index];
	}

	public int length() {
		return chars.length;
	}
	public MyString1 substring(int begin, int end) {
		char[] temp = new char[chars.length];
		for (int i = begin; i < end; i++) {
			temp[i - begin] = chars[i];
		}
		return new MyString1(temp);
	}

	public MyString1 toLowerCase() {
		char[] temp = new char[chars.length];
		for (int i = 0; i < chars.length; i++) {
			temp[i] = Character.toLowerCase(chars[i]);
		}
		return new MyString1(temp);
	}

	public boolean equals(MyString1 s) {
		for (int i = 0; i < s.length(); i++) {
			if (chars[i] != s.charAt(i))
				return false;
		}
		return true;
	}

	public static MyString1 valueOf(int i) {
		char[] temp = new char[40];
		int size = 0;
		
		while (i != 0) {
			int number = i % 10;
			i = i / 10;
			temp[size] = (char)('0' + number);
			size++;
		}
		
		char[] reversed = new char[size];
		for (int j = 0; j < reversed.length; j++) {
			reversed[j] = temp[size - 1 - j];
		}
		return new MyString1(reversed);
	}
}
