/**
 * 
 */
package chapter11;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 14:20:26 
 */
public class L1108_TestArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** Create a list to store cities */
		ArrayList<String> cityList = new ArrayList<String>();
		
		/** Add some cities in the list */
		cityList.add("London");
		cityList.add("Denver");
		cityList.add("Paris");
		cityList.add("Miami");
		cityList.add("Seoul");
		cityList.add("Tokyo");
		// Contains [London, Denver, Paris, Miami, Seoul, Tokyo]
		
		System.out.println("List size ? " + cityList.size());
		System.out.println("Is Miami in the list ? " + cityList.contains("Miami"));
		System.out.println("The location of Denver in the list ? " + cityList.indexOf("Denver"));
		System.out.println("Is the list empty ? " + cityList.isEmpty());
		
		/** Insert a new city */
		cityList.add(2, "Xian");
		// Contains [London, Denver, Xian, Paris, Miami, Seoul, Tokyo]
		
		/** Remove a city from the list */
		cityList.remove("Miami");
		// Contains [London, Denver, Xian, Paris, Seoul, Tokyo]
		
		/** Remove a city from the index 1 */
		cityList.remove(1);
		// Contains [London, Xian, Paris, Seoul, Tokyo]
		
		// Display the contents in the list
		System.out.println(cityList.toString());
		
		// Display the contents in the list in reverse order
		for (int i = cityList.size() - 1; i >= 0; i--) {
			System.out.print(cityList.get(i) + " ");
		}
		System.out.println();
		
		// Create a list to store two circles
		ArrayList<L1102_CircleFromSimpleGeometricObject> list = new ArrayList<L1102_CircleFromSimpleGeometricObject>();
		
		// Add two circles
		list.add(new L1102_CircleFromSimpleGeometricObject(2));
		list.add(new L1102_CircleFromSimpleGeometricObject(3));
		
		// Display the Area of the first circle in the list
		System.out.println("The Area of the circle ? " + ((L1102_CircleFromSimpleGeometricObject)list.get(0)).getArea());
		
	}

}
