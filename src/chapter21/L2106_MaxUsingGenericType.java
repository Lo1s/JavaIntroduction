/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 8:39:16 
 */
public class L2106_MaxUsingGenericType {

	public static <E extends Comparable<E>> E max(E o1, E o2) {
		if (o1.compareTo(o2) > 0)
			return o1;
		else
			return o2;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(max("ahoj", "cau"));
	}

}
