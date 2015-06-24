package chapter19;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 */

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 8:32:46 
 */
public class L1902_TestDataStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Create an output stream for the file temp.dat
		DataOutputStream output = new DataOutputStream(new FileOutputStream("C:/Java/examples/temp.dat"));
		
		// Write student test scores to the file
		output.writeUTF("John");
		output.writeDouble(85.5);
		output.writeUTF("Susan");
		output.writeDouble(185.5);
		output.writeUTF("Kim");
		output.writeDouble(105.25);
		
		// Close output stream
		output.close();
		
		// Create an input stream for file temp.dat
		DataInputStream input = new DataInputStream(new FileInputStream("C:/Java/examples/temp.dat"));
		
		// Read student test scores from the file
		System.out.println(input.readUTF() + " " + input.readDouble());
		System.out.println(input.readUTF() + " " + input.readDouble());
		System.out.println(input.readUTF() + " " + input.readDouble());
		
		// Close the input stream
		input.close();
	}

}
