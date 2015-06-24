/**
 * 
 */
package chapter23;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author jslapnicka
 * @Date & @Time 19. 1. 2015 2015 8:34:08 
 */
public class L2303_TestLinkedHashSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new LinkedHashSet<String>();
		
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		
		System.out.println(set);
		
		for (String element: set) {
			System.out.print(element.toLowerCase() + " ");
		}
		
	}

}
