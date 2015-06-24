/**
 * 
 */
package chapter20;

import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 17:47:02 
 */
public class PE2018_TowersOfHanoi {

	static int count = 0;
	
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		count++;
		if (n == 1) {
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
		} else {
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = input.nextInt();
		
		// Find the solution recursively
		System.out.println("The moves are:");
		moveDisks(n, 'A', 'B', 'C');
		System.out.println("\nNumber of moves: " + count);
		input.close();
	}

}
