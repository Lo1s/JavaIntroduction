/**
 * 
 */
package chapter22;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author jslapnicka
 * @Date & @Time 16. 1. 2015 2015 10:20:14 
 */
public class PE2222_NonRecursiveTowersOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = input.nextInt();
				
		moveDisks(n, 'A', 'B', 'C');
		input.close();
	}
	
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		Stack<Disks> stack = new Stack<Disks>();
		stack.push(new Disks(n, false, fromTower, toTower, auxTower));
		while (!stack.empty()) {
			Disks disk = stack.pop();
			n = disk.n;
			fromTower = disk.fromTower;
			toTower = disk.toTower;
			auxTower = disk.auxTower;
						
			if (disk.isLast || n == 1)
				System.out.println("Move " + n + " disk from " + fromTower + " to " + toTower);
			else {
				stack.push(new Disks(n - 1, false, auxTower, toTower, fromTower));
				stack.push(new Disks(n, true, fromTower, toTower, auxTower));
				stack.push(new Disks(n - 1, false, fromTower, auxTower, toTower));
			}
				

		}
	}
	
	public static class Disks {
		int n;
		char fromTower;
		char auxTower;
		char toTower;
		boolean isLast = false;
		
		public Disks() {
			// TODO Auto-generated constructor stub
		}
		
		public Disks(int n, boolean isLast, char fromTower, char toTower, char auxTower) {
			this.fromTower = fromTower;
			this.auxTower = auxTower;
			this.toTower = toTower;
			this.n = n;
			this.isLast = isLast;
		}
	}

}
