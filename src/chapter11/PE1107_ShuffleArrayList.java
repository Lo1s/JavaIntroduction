/**
 * 
 */
package chapter11;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 18. 7. 2014 2014 10:44:34 
 */
public class PE1107_ShuffleArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (Integer i = 0; !i.equals(20); i++) {
			list.add(i);
		}
		
		System.out.println("Before the shuffle: " + list.toString());
		shuffle(list);
		System.out.println("After the shuffle: " + list);		
	}
	public static void shuffle(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int random = hdR.mtd.getRandomNumber(0, list.size() - 1);
			Integer temp = list.get(i);
			list.set(i, list.get(random));
			list.set(random, temp);
		}	}
}
