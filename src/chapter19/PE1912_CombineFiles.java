/**
 * 
 */
package chapter19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author jslapnicka
 * @Date & @Time 14. 11. 2014 2014 10:29:10 
 */
public class PE1912_CombineFiles {

	/** Use the combine file function by other applications */
	private int numberOfPieces;
	@SuppressWarnings("unused")
	private String sourceFile;
	private BufferedOutputStream output;
	private String fileName;
	
	public PE1912_CombineFiles() {
		// TODO Auto-generated constructor stub
		
	}
	
	public PE1912_CombineFiles(String sourceFile, int numberOfPieces) throws FileNotFoundException, IOException {
		this.numberOfPieces = numberOfPieces;
		this.sourceFile = sourceFile;
		
		// Get fileName and extension of the source file
		fileName = sourceFile.substring(0, sourceFile.length() - 4);
		
		output = new BufferedOutputStream(new FileOutputStream("C:/Java/examples/" + sourceFile));
	}
	
	public void combine() throws FileNotFoundException, IOException {
		for (int i = 0; i < numberOfPieces; i++) {
			BufferedInputStream input = new BufferedInputStream(
					new FileInputStream(new File("C:/Java/examples/" + fileName + ".part" + i)));
			int value;
			while ((value = input.read()) != -1) {
				output.write(value);
			}
			input.close();
		}
		output.close();
	}
	
	/** Run from the command prompt */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("Usage: java PE1911_CombineFiles sourceFile numberOfPieces");
			System.exit(0);
		}
		// Get number of pieces
		int numberOfPiecesArg = Integer.parseInt(args[1]);
		
		// Get fileName and extension of the source file
		String fileNameArg = args[0].substring(0, args[0].length() - 4);
		
		// Create combined file
		BufferedOutputStream outputArg = new BufferedOutputStream(new FileOutputStream("C:/Java/examples/" + args[0]));

		// Copy the content of the split files to the combined file
		for (int i = 0; i < numberOfPiecesArg; i++) {
			BufferedInputStream inputArg = new BufferedInputStream(
					new FileInputStream(new File("C:/Java/examples/" + fileNameArg + ".part" + i)));
			int value;
			while ((value = inputArg.read()) != -1) {
				outputArg.write(value);
			}
			inputArg.close();
		}
		outputArg.close();
	}

}
