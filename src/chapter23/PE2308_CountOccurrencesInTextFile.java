/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jslapnicka
 * @Date & @Time 21. 1. 2015 2015 9:16:00 
 */
public class PE2308_CountOccurrencesInTextFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// C:/Java/Test/proguard-project.txt
		System.out.print("Enter a file: ");		
		File file = new File(input.nextLine());
		input.close();

		StringBuilder builder = new StringBuilder();

		try {
			Scanner fileScan = new Scanner(file);
			while (fileScan.hasNextLine()) {
				builder.append(fileScan.nextLine() + "\n");
			}
			fileScan.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Problem with the file: " + file.getAbsolutePath());
		}

		String text = builder.toString();

		// Create a TreeMap to hold words as key and count as value 
		Map<String, Integer> map = new TreeMap<String, Integer>();

		String[] words = text.split("[ \n\t\r.,:;!?(){}/]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			if (key.length() > 0) {
				if (Character.isLetter(key.charAt(0))) {
					if (!map.containsKey(key)) {
						map.put(key, 1);
					} else {
						int value = map.get(key);
						value++;
						map.put(key, value);
					}
				}
			}
		}

		// Get all entries into set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

		for (Map.Entry<String, Integer> entry: entrySet)
			System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
	}

}
