/**
 * 
 */
package chapter23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 1. 2015 2015 14:56:05 
 */
public class PE2313_BabyNamePopularityRanking {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt() - 2001;
		System.out.print("Enter the gender: ");
		String gender = input.next();
		System.out.print("Enter the name: ");
		String name = input.next();
		
		findRanking(name, year, gender);
		input.close();
	}

	public static void findRanking(String name, int year, String gender) {
		// Load files & initialize databases
		ArrayList<HashMap<String, Integer>> boys = new ArrayList<HashMap<String,Integer>>();
		ArrayList<HashMap<String, Integer>> girls = new ArrayList<HashMap<String,Integer>>();
		File[] files = new File[10];

		try {
			for (int i = 0; i < 10; i++) {
				files[i] = new File("C:/Java/Test/babynamesranking20" + ((i + 1) < 10 ? "0" + (i + 1) : i + 1)  + ".txt");
				boys.add(new HashMap<String, Integer>());
				girls.add(new HashMap<String, Integer>());
				Scanner input = new Scanner(files[i]);
				while (input.hasNextLine()) {
					Integer rank = input.nextInt();
					String nameBoys = input.next();
					input.next(); // skip the volume
					String nameGirls = input.next();
					boys.get(i).put(nameBoys, rank);
					girls.get(i).put(nameGirls, rank);
					input.nextLine();
				}
				input.close();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Problem with the input files !");
			ex.printStackTrace();
		}
		
		switch(gender) {
		case "Male": 
			if (boys.get(year).containsKey(name)) {
				System.out.println("Boy name " + name + " is ranked #" + boys.get(year).get(name) + " in year " + (year + 2001));
			} else {
				System.out.println("Boy name not found in the database !");
			}
			break;
		case "Female":
			if (girls.get(year).containsKey(name)) {
				System.out.println("Girl name " + name + " is ranked #" + girls.get(year).get(name) + " in year " + (year + 2001));
			} else {
				System.out.println("Girl name not found in the database !");
			}
		}
	}
	
}
