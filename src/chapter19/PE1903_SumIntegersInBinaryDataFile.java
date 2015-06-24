/**
 * 
 */
package chapter19;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 11:12:15 
 */
public class PE1903_SumIntegersInBinaryDataFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Create an output stream
		DataOutputStream output = new DataOutputStream(new FileOutputStream("C:/Java/examples/Exercise19_03.dat"));
		
		// Write integers
		for (int i = 1; i <= 10; i++) {
			output.writeInt(i);
		}
		
		// Close the output stream
		output.close();
		
		// Create an random access input stream
		RandomAccessFile inout = new RandomAccessFile("C:/Java/examples/Exercise19_03.dat", "r");
		int sum = 0;
		
		while (inout.getFilePointer() < inout.length())
			sum += inout.readInt();
		
		// Close the input stream
		inout.close();
		
		// Print the sum
		System.out.println("Sum: " + sum);
	}

}
