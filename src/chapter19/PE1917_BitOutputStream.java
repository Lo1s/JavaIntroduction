/**
 * 
 */
package chapter19;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author jslapnicka
 * @Date & @Time 18. 11. 2014 2014 10:51:06 
 */
public class PE1917_BitOutputStream {

	private int mask = 1;
	private int count;
	private int value;
	private FileOutputStream output;

	public PE1917_BitOutputStream(File file) {
		// TODO Auto-generated constructor stub
		try {
			output = new FileOutputStream(file);
		} catch (FileNotFoundException ex) {
			System.out.println(file + " not found !");
		}
	}

	public void writeBit(char bit) throws FileNotFoundException, IOException {
		count++;
		
		value = value << 1;
		
		if (bit == '1')
			value = value | mask;
		
		if (count == 8) {
			output.write(value);
			count = 0;
		}
	}

	public void writeBit(String bits) throws FileNotFoundException, IOException {
		for (int i = 0; i < bits.length(); i++)
			writeBit(bits.charAt(i));		
	}

	public void close() throws FileNotFoundException, IOException {
		if (count > 0) {
			value = value << (8 - count);
			output.write(value);
		}
		output.close();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		PE1917_BitOutputStream output = new PE1917_BitOutputStream(new File("C:/Java/examples/Exercise19_17.dat"));

		output.writeBit('1');
		output.writeBit('0');
		output.writeBit('1');
		output.writeBit('1');
		output.writeBit("0100");
		output.writeBit('0');
		output.writeBit('1');
		output.writeBit('1');
		output.writeBit('1');
		output.close();
	}
}
