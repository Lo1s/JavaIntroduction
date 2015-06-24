/**
 * 
 */
package chapter24;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author jslapnicka
 * @Date & @Time 29. 1. 2015 2015 10:33:00 
 */
public class PE2408_ReadDatFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		RandomAccessFile raf = new RandomAccessFile("C:/Java/Test/PrimeNumbers.dat", "r");
		
		while (raf.getFilePointer() < raf.length()) {
			System.out.println(raf.readLong());
		}
		raf.close();
	}

}
