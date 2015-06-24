/**
 * 
 */
package chapter23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jslapnicka
 * @Date & @Time 20. 1. 2015 2015 15:44:59 
 */
public class PE2307_ReviseL2309_CountOccurencesOfWords {

	public static void main(String[] args) {

		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<String, Integer>();

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
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(map);
		Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
		ArrayList<WordOccurrence> list = new ArrayList<PE2307_ReviseL2309_CountOccurencesOfWords.WordOccurrence>();
		String key;
		Integer value;
		
		for(Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator(); iterator.hasNext(); list.add(new WordOccurrence(key, value.intValue()))) {
			Map.Entry<String, Integer> entry = (java.util.Map.Entry<String, Integer>)iterator.next();
			key = (String)entry.getKey();
			value = (Integer)entry.getValue();
		}

		Collections.sort(list);
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}

	}
	
	static class WordOccurrence implements Comparable<WordOccurrence> {
		String word;
		int count;

		public WordOccurrence(String key, int value) {
			// TODO Auto-generated constructor stub
			this.word = key;
			this.count = value;
		}

		@Override
		public int compareTo(WordOccurrence o) {
			return this.count - o.count;
		}
		
		@Override
		public boolean equals(Object o) {
			return word.equals(((WordOccurrence)o).word);
		}
		
		@Override
		public String toString() {
			return (new StringBuilder(String.valueOf(word))).append(": ").append(count).toString();
		}
		
	}

}


