/**
 * 
 */
package chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 28. 8. 2014 2014 11:13:44 
 */
public class PE1425_ProcessLargeDataset {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a filename: ");
		String FileString = input.nextLine();
		input.close();

		try {
			File file = new File(FileString);
			input = new Scanner(file);

		}
		catch (FileNotFoundException ex) {
			System.out.print("Wrong input !");
		}
		String[] firstName = new String[1000];
		String[] lastName = new String[1000];
		String[] rank = new String[1000];
		double[] salary = new double[1000];
		
		for (int i = 0; i < 1000; i++) {
			firstName[i] = input.next();
			lastName[i] = input.next();
			rank[i] = input.next();
			salary[i] = (long)input.nextDouble();
		}
		
		long totalAssistant = 0;
		int countAssistants = 0;
		long totalAssociate = 0;
		int countAssociates = 0;
		long totalFull = 0;
		int countFulls = 0;
		long total;
		
		for (int i = 0; i < 1000; i++) {
			if (rank[i].equals("assistant")) {
				totalAssistant += salary[i];
				countAssistants++;
			}
			else if (rank[i].equals("associate")) {
				totalAssociate += salary[i];
				countAssociates++;
			}
			else if (rank[i].equals("full")) {
				totalFull += salary[i];
				countFulls++;
			}
		}
		
		total = totalAssistant + totalAssociate + totalFull;
		
		System.out.println("Totals:"
				+ "\nAssistant: " + totalAssistant
				+ "\nAssociate: " + totalAssociate
				+ "\nFull: " + totalFull
				+ "\nTotal: " + total);
		
		System.out.println("\nAverage: "
				+ "\nAssistant: " + (totalAssistant / countAssistants)
				+ "\nAssociate: " + (totalAssociate / countAssociates)
				+ "\nFull: " + (totalFull / countFulls)
				+ "\nTotal: " + (total / 1000));
	}

}
