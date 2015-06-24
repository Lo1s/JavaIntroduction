/**
 * 
 */
package chapter25;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author jslapnicka
 * @Date & @Time 17. 6. 2015 2015 8:09:06 
 */
public class PE2501_Comparator<E extends Comparable<E>> implements Comparator<E>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(E o1, E o2) {
		return o1.compareTo(o2);
	}
	

}
