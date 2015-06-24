/**
 * 
 */
package chapter07;
import java.util.Scanner;
import java.io.*;

/**
 * @author jslapnicka
 *
 */
public class PE717 {

	/**
	 * 
	 */
	public PE717() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(new File ("PE717-input.txt"));
		// Number of banks
		int n = input.nextInt();
		// limit for safe bank
		int limit = input.nextInt();

		double[][] borrowers = new double[n][n];
		double[] balances = new double[n];
		int[] numberOfBorrowers = new int[n];
		int debtorID = 0;
		for (int creditorID = 0; creditorID < borrowers.length; creditorID++) {
			balances[creditorID] = input.nextDouble();
			numberOfBorrowers[creditorID] = input.nextInt();
			debtorID = input.nextInt();
			borrowers[creditorID][debtorID] = input.nextDouble();
			if (numberOfBorrowers[creditorID] > 1) {
				debtorID = input.nextInt();
				borrowers[creditorID][debtorID] = input.nextDouble();
			}
		}
		double[] assets = createAssets(borrowers, balances, numberOfBorrowers);
		// Boolean array for skipping the already checked assets
		boolean[] checkAssets = new boolean[assets.length];
		// if the checkAssets method returns a value that is greater than 0, then indexed debtor is under limit
		int belowLimit = checkAssets(assets, checkAssets, limit);
		while (belowLimit > 0) {
			for (int i = 0; i < borrowers[belowLimit].length; i++) {
				borrowers[i][belowLimit] = 0;
			}
			assets = createAssets(borrowers, balances, numberOfBorrowers);
			checkAssets[belowLimit] = true;
			belowLimit = checkAssets(assets, checkAssets, limit);
		}
		// Displaying results
		System.out.print("Unsafe banks are: ");
		for (int i = 0; i < checkAssets.length; i++) {
			if (checkAssets[i])
				System.out.print(i + " ");
		}
	}
	// Creates total assets
	public static double[] createAssets(double[][] borrowers, double[] balances, int[] numberOfBorrowers) {
		double[] assets = new double[balances.length];
		for (int i = 0; i < assets.length; i++) {
			double sumLoans = 0;
			for (int j = 0; j < borrowers[i].length; j++) {
				sumLoans += borrowers[i][j];
			}
			assets[i] = balances[i] + sumLoans;
		}
		return assets;
	}
	// Checks if assets are above limit
	public static int checkAssets(double[] assets, boolean[] checkAssets, int limit) {
		for (int i = 0; i < assets.length; i++) {
			if (assets[i] < limit && !checkAssets[i]) {
				return i;
			}
		}
		return -1;
	}
}
