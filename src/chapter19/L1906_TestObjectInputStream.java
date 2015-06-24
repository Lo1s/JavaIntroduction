/**
 * 
 */
package chapter19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 9:11:52 
 */
public class L1906_TestObjectInputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		// Create an input stream for file object.dat
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:/Java/examples/object.dat"));
		
		// Read a string, double value, and object from the file
		String name = input.readUTF();
		double score = input.readDouble();
		java.util.Date date = (java.util.Date)input.readObject();
		System.out.println(name + " " + score + " " + date);
		
		// Close input stream
		input.close();
	}

}
