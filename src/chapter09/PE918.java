/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 1. 7. 2014 2014 9:49:59 
 */
public class PE918 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyString2 s = new MyString2(new char[] {'a', 'b', 'c'});
		System.out.println(s.compare("abg") + "\n");
		for (int i = 0; i < s.substring(1).length(); i++) {
			System.out.println(s.substring(1).charAt(i));
		}
		for (int i = 0; i < s.toUpperCase().length(); i++) {
			System.out.println(s.toUpperCase().charAt(i));
		}
		for (int i = 0; i < MyString2.valueOf(true).length(); i++) {
			System.out.println(MyString2.valueOf(true).charAt(i));
		}
		

	}

}

class MyString2 {
	private char[] chars;
	
	public MyString2(char[] chars) {
		this.chars = new char[chars.length];
		System.arraycopy(chars, 0, this.chars, 0, chars.length);
	}
	public int compare(String s) {
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != s.charAt(i)) {
				return chars[i] - s.charAt(i);
			}
		}
		return 0;
	}
	public MyString2 substring(int begin) {
		char[] temp = new char[chars.length];
		
		for (int i = begin; i < chars.length; i++) {
			temp[i - begin] = chars[i];
		}
		return new MyString2(temp);
	}
	public MyString2 toUpperCase() {
		char[] temp = new char[chars.length];
		
		for (int i = 0; i < chars.length; i++) {
			temp[i] = Character.toUpperCase(chars[i]);
		}
		return new MyString2(temp);
	}
	public char[] toChars() {
		return chars;
	}
	public static MyString2 valueOf(boolean b) {
		if (b)
			return new MyString2("true".toCharArray());
		else
			return new MyString2("false".toCharArray());
	}
	public int length() {
		return chars.length;
	}
	public char charAt(int index) {
		return chars[index];
	}
}
