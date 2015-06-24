/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author jslapnicka
 * @Date & @Time 28. 8. 2014 2014 10:36:29 
 */
public class PE1424_CreateLargeDataset {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("C:/Java/Salary.txt");
		
		if (file.exists()) {
			System.out.println("The File already exists !");
			System.exit(1);
		}
		
		PrintWriter output = new PrintWriter(file);
		
		int numberOfItems = 1000;
		String[] firstName = new String[numberOfItems];
		String[] lastName = new String[numberOfItems];
		String[] rank = new String[numberOfItems];
		int[] salary = new int[numberOfItems];
		
		// Generate and write the data into the file
		for (int i = 0; i < numberOfItems; i++) {
			firstName[i] = "FirstName" + i;
			lastName[i] = "LastName" + i;
			
			int randomRank = hdR.mtd.getRandomNumber(1, 3);
			switch (randomRank) {
				case 1: rank[i] = "assistant"; 
						salary[i] = hdR.mtd.getRandomNumber(50000, 80000); break;
				case 2: rank[i] = "associate";
						salary[i] = hdR.mtd.getRandomNumber(60000, 110000); break;
				case 3: rank[i] = "full";
						salary[i] = hdR.mtd.getRandomNumber(75000, 130000); break;
			}
			
			output.println(firstName[i] + " " + lastName[i] + " " + rank[i] + " " + salary[i]);
		}
		output.close();
		System.out.println("Operation had been successfull !");
	}

}
