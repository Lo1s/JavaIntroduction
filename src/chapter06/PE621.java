/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author hydRa
 *
 */
public class PE621 {

	/**
	 * 
	 */
	public PE621() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of balls to drop: ");
		int numberOfBalls = input.nextInt();
		System.out.print("Enter the number of slots in the bean machine: ");
		int numberOfSlots = input.nextInt();

		System.out.print("\n");
		String toss = "";

		int[] slots = new int[numberOfSlots];
		for (int i = 0; i < numberOfBalls; i++) {
			int[] beanMachine = beanMachine(numberOfSlots);
			toss += beanMachineToss(beanMachine) + "\n";
			slots[sum(beanMachine)]++;
		}
		System.out.print(toss);
		System.out.println();
		printBuildUp(slots);
		for (int i = 0; i < numberOfSlots; i++)
			System.out.print("|" + i);
		System.out.print("|");
	}
	// Creating a bean machine array (stores 0 as L & 1 as R)
	public static int[] beanMachine(int slots) {
		int[] beanMachine = new int[slots];
		for (int i = 0; i < beanMachine.length; i++) {
			beanMachine[i] = hdR.mtd.getRandomNumber(0, 1);
		}
		return beanMachine;
	}
	// String of the bean machine toss
	public static String beanMachineToss(int[] array) {
		String lR = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0)
				lR += "L";
			else {
				lR += "R";
			}
		}
		return lR;
	}	
	// Buildup
	// Counting the sum of the toss
	public static int sum(int[] toss) {
		int sum = 0;
		for (int i = 0; i < toss.length; i++) {
			sum += toss[i];
		}
		return sum;
	}
	// Find max index in a passed Array
	public static int maxIndex(int[] array) {
		int maxIndex = 0;
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			// Find max value in array slots[]
			if (array[i] > max) {
				maxIndex = i;
				max = array[i];
			}
		}
		return maxIndex;
	}
	// Creates the buildup
	public static void printBuildUp(int[] slots) {
		int sum = 1;
		int ball = 0;
		// Prints "O"
		while (sum != 0) {
			int max = slots[maxIndex(slots)];
			for (int i = 0; i < slots.length; i++) {
				if (slots[i] == max) {
					System.out.print("|O");
					slots[i]--;
					ball++;
				} else 
					System.out.print("| ");
			}
			if (ball > 1) {
				System.out.println("| " + ball + " balls");
				ball = 0;
			} else {
				System.out.println("| " + ball + " ball");
				ball = 0;
			}
				sum = 0;
				for (int k = 0; k < slots.length; k++)
					sum += slots[k];
		}
	}
}
