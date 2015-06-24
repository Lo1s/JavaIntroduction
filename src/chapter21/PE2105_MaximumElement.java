/**
 * 
 */
package chapter21;


/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 14:43:02 
 */
public class PE2105_MaximumElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] testInt = {1, 2, 3, 5, 0, 6, 13, 21, 2};
		Double[] testDouble = {5.0, 2.0, 3.5, 5.1, 0.2};
		
		System.out.println("testInt's max: " + max(testInt));
		System.out.println("testDouble's max: " + max(testDouble));
	}
	
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0];
		for (int i = 0; i < list.length; i++) {
			if (list[i].compareTo(max) > 0)
				max = list[i];
		}
		
		return max;
	}

}
