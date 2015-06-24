/**
 * 
 */
package chapter23;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jslapnicka
 * @Date & @Time 19. 1. 2015 2015 10:28:01 
 */
public class L2309_CountOccurenceOfWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value 
		Map<String, Integer> map = new TreeMap<String, Integer>();

		String[] words = text.split("[ \n\t\r.,:;!?(){}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		// Get all entries into set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

		for (Map.Entry<String, Integer> entry: entrySet)
			System.out.println(entry.getKey() + "\t" + entry.getValue());
	}

}
