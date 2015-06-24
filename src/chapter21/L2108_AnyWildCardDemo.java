/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 8:57:23 
 */
public class L2108_AnyWildCardDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L2101_GenericStack<Integer> intStack = new L2101_GenericStack<Integer>();
		intStack.push(1);
		intStack.push(2);
		intStack.push(-2);

		print(intStack);
	}

	/** Print objects and empties the stack */
	public static void print(L2101_GenericStack<?> stack) {
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

}
