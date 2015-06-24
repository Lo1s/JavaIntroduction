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
 * @Date & @Time 12. 11. 2014 2014 8:44:59 
 */
public class L1903_DetectEndOfFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DataOutputStream output = new DataOutputStream(new FileOutputStream("C:/Java/examples/test.dat"));
			output.writeDouble(4.5);
			output.writeDouble(43.25);
			output.writeDouble(3.2);
			output.close();
			
			@SuppressWarnings("resource")
			DataInputStream input = new DataInputStream(new FileInputStream("C:/Java/examples/test.dat"));
			while (true) {
				System.out.println(input.readDouble());
			}
		}
		catch (EOFException ex) {
			System.out.println("All data were read");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
