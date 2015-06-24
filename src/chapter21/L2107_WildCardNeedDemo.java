/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 8:41:39 
 */
public class L2107_WildCardNeedDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L2101_GenericStack<Integer> intStack = new L2101_GenericStack<Integer>();
		intStack.push(1); // 1 is autoboxed into new Integer(1)
		intStack.push(2);
		intStack.push(-2);
		
		System.out.print("The max number is " + max(intStack));
	}
	
	/** Find the maximum in a stack of numbers */
	public static double max(L2101_GenericStack<? extends Number> stack) {
		double max = stack.pop().doubleValue(); // Initialize max
		
		while (!stack.isEmpty()) {
			double value = stack.pop().doubleValue();
			if (value > max)
				max = value;
		}
		
		return max;
	}

}
