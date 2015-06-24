/**
 * 
 */
package chapter19;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 13:23:32 
 */
public class PE1908_UpdateCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File counter = new File("C:/Java/examples/Exercise19_08.dat");
		// Create an random access file
		RandomAccessFile raf = new RandomAccessFile(counter, "rw");

		int count = 0;
		
		if (raf.length() > 0)
			count = raf.readInt();
		
		raf.seek(0);
		raf.writeInt(++count);
		
		raf.seek(0);
		System.out.println(raf.readInt());
		
		raf.close();
	}

}
