/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 12:41:27 
 */
public class L1106_DynamicBindingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m(new GraduateStudent());
		m(new Student());
		m(new Person());
		m(new Object());
	}
	public static void m(Object x) {
		System.out.println(x.toString());
	}
}

class GraduateStudent extends Student {
	
}

class Student extends Person {
	@Override
	public String toString() {
		return "Student";
	}
}

class Person extends Object {
	@Override
	public String toString() {
		return "Person";
	}
}
