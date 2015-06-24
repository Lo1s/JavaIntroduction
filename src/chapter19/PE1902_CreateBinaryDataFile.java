/**
 * 
 */
package chapter19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 10:50:51 
 */
public class PE1902_CreateBinaryDataFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Create an output stream
		DataOutputStream output = new DataOutputStream(new FileOutputStream("C:/Java/examples/Exercise19_02.dat"));
		
		// Write 100 random integers
		for (int i = 0; i < 100; i++) {
			output.writeInt((int)(Math.random() * 100));
		}
		
		// Close the output stream
		output.close();
		
		// Read the data for check
		DataInputStream input = new DataInputStream(new FileInputStream("C:/Java/examples/Exercise19_02.dat"));
		try {
			while (true)
				System.out.println(input.readInt());
		}
		catch (EOFException ex) {
			System.out.println("All data were read");
		}
		
		// Close the input stream
		input.close();
	}

}
