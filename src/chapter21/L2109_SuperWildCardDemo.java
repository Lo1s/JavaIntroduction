/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 9:00:50 
 */
public class L2109_SuperWildCardDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L2101_GenericStack<String> stack1 = new L2101_GenericStack<String>();
		L2101_GenericStack<Object> stack2 = new L2101_GenericStack<Object>();
		stack2.push("Java");
		stack2.push(2);
		stack1.push("Sun");
		add(stack1, stack2);
		L2108_AnyWildCardDemo.print(stack2);
	}
	
	public static <T> void add(L2101_GenericStack<T> stack1, L2101_GenericStack<? super T> stack2) {
		while (!stack1.isEmpty())
			stack2.push(stack1.pop());
	}

}
