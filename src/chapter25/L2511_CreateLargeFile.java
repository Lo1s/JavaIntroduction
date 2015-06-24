/**
 * 
 */
package chapter25;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author jslapnicka
 * @Date & @Time 16. 6. 2015 2015 7:54:29 
 */
public class L2511_CreateLargeFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:/Java/Test/largedata.dat")));
		
		for (int i = 0; i < 800004; i++)
			output.writeInt((int)(Math.random() * 1000000));
		
		output.close();
		
		// Display first 100 numbers
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("C:/Java/Test/largedata.dat")));
		for (int i = 0; i < 100; i++)
			System.out.print(input.readInt() + " ");
		input.close();
	}

}
