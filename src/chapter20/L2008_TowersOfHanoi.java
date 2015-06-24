/**
 * 
 */
package chapter20;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 20. 11. 2014 2014 15:48:51 
 */
public class L2008_TowersOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = input.nextInt();
		
		// Find the solution recursively
		System.out.println("The moves are:");
		moveDisks(n, 'A', 'B', 'C');
		input.close();
	}
	
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		if (n == 1) // Stopping condition
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
		else {
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
	}

}
