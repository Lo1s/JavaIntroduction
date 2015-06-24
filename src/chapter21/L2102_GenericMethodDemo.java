/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 7:45:43 
 */
public class L2102_GenericMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] integers = {1, 2, 3, 4, 5};
		String[] strings = {"London", "Paris", "New York", "Austin"};
		
		L2102_GenericMethodDemo.<Integer>print(integers);
		L2102_GenericMethodDemo.<String>print(strings);
	}
	
	public static <E> void print(E[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

}
