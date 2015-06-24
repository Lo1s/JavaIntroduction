/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 7:43:22 
 */
public class L2101_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L2101_GenericStack<String> stack1 = new L2101_GenericStack<String>();
		stack1.push("London");
		stack1.push("Paris");
		stack1.push("Berlin");
		
		L2101_GenericStack<Integer> stack2 = new L2101_GenericStack<Integer>();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		
		System.out.println(stack1.toString());
		System.out.println(stack2.toString());
	}

}
