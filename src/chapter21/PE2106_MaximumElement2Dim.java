/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 14:55:52 
 */
public class PE2106_MaximumElement2Dim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[][] testInt = {{1, 2, 3}, {2, 0, 5}, {3, 4, 2}};
		Double[][] testDouble = {{1.0, 2.5, 3.8}, {3.5, 2.5, 2.6}, {3.2, 2.9, 1.5}};
		
		System.out.println("int max: " + max(testInt));
		System.out.println("double max: " + max(testDouble));
	}
	
	public static <E extends Comparable<E>> E max(E[][] list) {
		E max = list[0][0];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j].compareTo(max) > 0)
					max = list[i][j];
			}
		}
		return max;
	}

}
