/**
 * 
 */
package chapter22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 14:42:09 
 */
public class L2201_TestCollection {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> collection1 = new ArrayList<String>();
		collection1.add("New York");
		collection1.add("Atlanta");
		collection1.add("Dallas");
		collection1.add("Madison");
		System.out.println("A list of cities in collection1: ");
		System.out.println(collection1);
		
		System.out.println("Is Dallas in the collection ? " + collection1.contains("Dallas"));
		collection1.remove("Dallas");
		System.out.println("\n" + collection1.size() + " cities are in collection1 now");
		
		Collection<String> collection2 = Arrays.asList("Seatle", "Portland", "Los Angeles", "Atlanta");
		System.out.println("\nA list of cities in collection2: ");
		System.out.println(collection2);
		
		ArrayList<String> c1 = (ArrayList<String>)(collection1.clone());
		c1.addAll(collection2);
		System.out.println("\nCities in collection1 or collection2: ");
		System.out.println(collection2);
		System.out.println(c1);
		
		c1 = (ArrayList<String>)(collection1.clone());
		c1.retainAll(collection2);
		System.out.print("\nCities in collection1 and collection2: ");
		System.out.println(c1);
		
		c1 = (ArrayList<String>)(collection1.clone());
		c1.removeAll(collection2);
		System.out.print("\nCities in collection1, but not in 2: ");
		System.out.println(c1);
		
		
		
	}

}
