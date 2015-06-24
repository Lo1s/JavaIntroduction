/**
 * 
 */
package chapter24;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author jslapnicka
 * @Date & @Time 29. 1. 2015 2015 16:42:10 
 */
public class PE2410_NumberOfPrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, EOFException, IOException {
		// TODO Auto-generated method stub
		long[] limits = {
				10,
				100,
				1000,
				10000,
				100000,
				1000000,
				10000000,
				100000000,
				1000000000,
				10000000000L,
				100000000000L,
				1000000000000L,
				10000000000000L,
				100000000000000L,
				1000000000000000L,
				10000000000000000L,
				100000000000000000L,
				1000000000000000000L};

		RandomAccessFile raf = new RandomAccessFile("C:/Java/Test/PrimeNumbers.dat", "r");
		
		for (int i = 0; i < limits.length; i++) {
			int count = 0;
			while (raf.getFilePointer() < raf.length() && raf.readLong() < limits[i]) {
				count++;
			}
			raf.seek(0);
			System.out.println("Number of prime numbers <= " + limits[i] + " is " + count);
		}
		raf.close();
	}

}
