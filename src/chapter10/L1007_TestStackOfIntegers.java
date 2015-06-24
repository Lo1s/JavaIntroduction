/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 7. 7. 2014 2014 14:03:20 
 */
public class L1007_TestStackOfIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1008_StackOfIntegers stack = new L1008_StackOfIntegers();
		
		for (int i = 0; i < 10; i++)
			stack.push(i);
		while (!stack.empty())
			System.out.print(stack.pop() + " ");
	}

}
