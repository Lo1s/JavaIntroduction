/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


/**
 * @author jslapnicka
 * @Date & @Time 21. 1. 2015 2015 14:18:54 
 */
public class PE2312_NameForBothGenders {

	public static void intersect(String filename) {
		// Load files & initialize databases
		HashMap<String, Integer> boys = new HashMap<String, Integer>();
		HashMap<String, Integer> girls = new HashMap<String, Integer>();

		try {
			File file = new File(filename);
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				Integer rank = input.nextInt();
				String nameBoys = input.next();
				input.next(); // skip the volume
				String nameGirls = input.next();
				boys.put(nameBoys, rank);
				girls.put(nameGirls, rank);
				input.nextLine();
			}
			input.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Problem with the input files !");
			ex.printStackTrace();
		}

		Set<String> keySetBoys = boys.keySet();
		Set<String> keySetGirls = girls.keySet();
		keySetBoys.retainAll(keySetGirls);
		
		System.out.println(keySetBoys.size() + " names used for both genders");
		System.out.println("They are " + keySetBoys);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a file name for baby name ranking: ");
		String file = "C:/Java/Test/" + input.nextLine();
		intersect(file);
		input.close();
	}

}
