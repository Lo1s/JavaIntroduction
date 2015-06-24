/**
 * 
 */
package chapter24;


import java.io.EOFException;
import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author jslapnicka
 * @Date & @Time 29. 1. 2015 2015 8:41:42 
 */
public class PE2408_AllPrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file: ");
		File file = new File(input.nextLine());
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		int choice = -1;
		long number = 0;
		JFrame frame = new JFrame();
		
		
		// C:/Java/Test/PrimeNumbers.dat
		if (file.exists() && raf.length() > 0) {
			frame.setTitle("Warning");
			frame.setAlwaysOnTop(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			choice = JOptionPane.showConfirmDialog(frame, "File already exist, continue ?", "Warning", JOptionPane.YES_NO_OPTION);
		} else {
			System.out.println("Creating new file...");
			number = 2;
		}
				
		System.out.print("Find all prime numbers <= n, enter n: ");
		int n = input.nextInt();
		
		// A list to hold prime numbers
		List<Long> list = new ArrayList<Long>();
		
		final int NUMBER_PER_LINE = 10;
		int squareRoot = 1;
		
		if (choice == JOptionPane.YES_OPTION) {
			System.out.println("Reading data...");
			try {
				while (true) {
					list.add(raf.readLong());
				}
			}
			catch (EOFException ex) {
				System.out.println("All data were read");
			}
			raf.seek(file.length() - 8); // bit size of the long type is 8
			number = raf.readLong() + 1;
		} else if (choice == JOptionPane.NO_OPTION) {
			System.out.println("Recreating the file...");
			raf.setLength(0);
			number = 2;
		}
		
		System.out.println("The prime numbers are \n");
		
		// Repeatedly find prime numbers
		while (number <= n) {
			boolean isPrime = true;
						
			if (squareRoot * squareRoot < number) squareRoot++;
			
			// Test whether number is prime
			for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
				if (number % list.get(k) == 0) {
					isPrime = false;
					break;
				}
			}
			
			// Print the prime number and increase the count
			if (isPrime) {
				list.add(number);
				if (list.size() % NUMBER_PER_LINE == 0) {
					System.out.println(number);
				}
				else
					System.out.print(number + " ");
				raf.writeLong(number);
			}
			
			// Check whether the next number is prime
			number++;
		}
		
		System.out.println("\n" + list.size() + " prime(s) less than or equal to " + n);
		input.close();
		raf.close();
	}


}
