/**
 * 
 */
package chapter22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 15:30:37 
 */
public class L2202_TestIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> collection = new ArrayList<String>();
		collection = Arrays.asList("New York", "Atlanta", "Dallas", "Madison");
		
		Iterator<String> iterator = collection.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next().toUpperCase() + " ");
		System.out.println();
	}

}
