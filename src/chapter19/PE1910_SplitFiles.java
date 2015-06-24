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
 * @Date & @Time 13. 11. 2014 2014 12:23:39 
 */
public class PE1910_SplitFiles {

	/** Use the split file function by other applications */
	private int numberOfPieces;
	private int numberOfBytes;
	private long fileSize;
	private long part;
	private BufferedInputStream input;
	private File sourceFile;
	private String fileName;

	public PE1910_SplitFiles() {
		// TODO Auto-generated constructor stub		
	}

	public PE1910_SplitFiles(File sourceFile, int numberOfPieces) {
		this.sourceFile = sourceFile;
		this.numberOfPieces = numberOfPieces;

		try {
			input = new BufferedInputStream(new FileInputStream(sourceFile));
		}
		catch (IOException ex) {
			System.out.println(sourceFile + " not found !");
		}

		// Get the name of the splitted files in the form: xxx.partX
		fileName = sourceFile.getName().substring(0, sourceFile.getName().length() - 4);

		// Get sourceFile size and the size of the splitted files
		fileSize = sourceFile.length();
		part = fileSize / numberOfPieces;
	}

	public void split() throws FileNotFoundException, IOException {
		// Create split files
		for (int  i = 0; i < numberOfPieces; i++) {
			BufferedOutputStream output = new BufferedOutputStream(
					new FileOutputStream(new File("C:/Java/examples/" + fileName + ".part" + i)));
			int value;
			int numberOfBytes = 0;
			while (numberOfBytes++ < part  && (value = input.read()) != -1) {
				output.write(value);
			}
			output.close();
		}
		
		input.close();
		System.out.println("[" + sourceFile.length() + "]");
	}

	public int getNumberOfBytes() {
		return numberOfBytes;
	}

	/** Run from the command prompt */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("Usage: java PE1910_SplitFiles souceFile numberOfPieces");
			System.exit(0);
		}
		// Get number of pieces
		int numberOfPiecesArg = Integer.parseInt(args[1]);

		// Get Source file and create input stream for it
		BufferedInputStream inputArg = new BufferedInputStream(new FileInputStream(
				new File("C:/Java/examples/" + args[0])));

		// Get fileName and extension of the source file
		File sourceFileArg = new File("C:/Java/examples/" + args[0]);
		String fileNameArg = sourceFileArg.getName().substring(0, sourceFileArg.getName().length() - 4);

		// Get fileSize and size of the split file
		long fileSizeArg = inputArg.available();
		int partArg = (int)
				Math.ceil(1.0 * fileSizeArg / numberOfPiecesArg);
		System.out.println(partArg);
		// Copy the content of the sourceFile into split files
		for (int  i = 0; i < numberOfPiecesArg; i++) {
			BufferedOutputStream outputArg = new BufferedOutputStream(
					new FileOutputStream(new File("C:/Java/examples/" + fileNameArg + ".part" + i)));
			int value;
			int numberOfBytesArg = 0;
			while (numberOfBytesArg++ < partArg  && (value = inputArg.read()) != -1) {
				outputArg.write(value);
			}
			outputArg.close();
		}
		
		inputArg.close();
		System.out.println("[" + sourceFileArg.length() + "]");

	}

}
