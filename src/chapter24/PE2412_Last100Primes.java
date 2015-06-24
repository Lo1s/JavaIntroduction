/**
 * 
 */
package chapter24;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author jslapnicka
 * @Date & @Time 30. 1. 2015 2015 14:51:30 
 */
public class PE2412_Last100Primes {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		RandomAccessFile raf = new RandomAccessFile("C:/Java/Test/PrimeNumbers.dat", "r");
		
		raf.seek(raf.length() - 100 * 8);
		int count = 0;
		while (raf.getFilePointer() < raf.length()) {
			System.out.println(raf.readLong());
			count++;
		}
		raf.close();
		System.out.println("*** Count: " + count + " ***");
	}

}
