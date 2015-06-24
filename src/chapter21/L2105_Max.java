/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 8:33:29 
 */
public class L2105_Max {
	/** Return the maximum of two objects */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Comparable max(Comparable o1, Comparable o2) {
		if (o1.compareTo(o2) > 0)
			return o1;
		else
			return o2;
	}
	
	public static void main(String[] args) {
		System.out.println(L2105_Max.max("Ahoj", "Cau"));
	}
}
