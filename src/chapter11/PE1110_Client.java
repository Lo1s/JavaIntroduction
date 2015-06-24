/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 21. 7. 2014 2014 12:57:18 
 */
public class PE1110_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PE1110_MyStackInheritance stack = new PE1110_MyStackInheritance();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.println(stack.toString());
		
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

}
