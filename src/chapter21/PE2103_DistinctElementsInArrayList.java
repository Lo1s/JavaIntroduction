/**
 * 
 */
package chapter21;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 13:02:31 
 */
public class PE2103_DistinctElementsInArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> test = new ArrayList<String>();
		test.add("ahoj");
		test.add("cau");
		test.add("ahoj");
		test.add("dobytku");
		test.add("dobitku");
		test.add("cau");
		test.add("1");
		test.add("2");
		test.add("1");
		
		System.out.println("Result: " + removeDuplicates(test).toString());
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> result = new ArrayList<E>();
		boolean isDuplicate = false;
		for (int i = 0; i < list.size(); i++) {
			isDuplicate = false;
			E temp = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (temp.equals(list.get(j))) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate)
				result.add(temp);
		}
		return result;
	}

}
