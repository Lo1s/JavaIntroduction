/**
 * 
 */
package chapter19;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import chapter10.L1002_Loan;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 13:14:33 
 */
public class PE1907_RestoreObjectsFromFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		L1002_Loan loan1 = new L1002_Loan(5, 10, 10000);
		L1002_Loan loan2 = new L1002_Loan(4, 15, 20000);
		L1002_Loan loan3 = new L1002_Loan(3, 25, 30000);
		L1002_Loan loan4 = new L1002_Loan(10, 2, 5000);
		L1002_Loan loan5 = new L1002_Loan(25, 1, 500);

		// Create output stream for the objects
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:/Java/examples/Exercise19_07"));

		// Write the objects into the file
		output.writeObject((Object)loan1);
		output.writeObject((Object)loan2);
		output.writeObject((Object)loan3);
		output.writeObject((Object)loan4);
		output.writeObject((Object)loan5);

		// Close the output stream
		output.close();

		// Create an input object stream for the check
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:/Java/examples/Exercise19_07"));

		try {
			while (true) {
				L1002_Loan newLoan = (L1002_Loan)input.readObject();
				System.out.println(newLoan.getTotalPayment());
			}
		}
		catch (EOFException ex) {
			System.out.println("All data were read !");
		}

		// Close the input stream
		input.close();

	
	}
}

