/**
 * 
 */
package chapter25;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jslapnicka
 * @Date & @Time 16. 6. 2015 2015 8:03:22 
 */
public class L2512_SortLargeFile {
	
	public static final int MAX_ARRAY_SIZE = 100000;
	public static final int BUFFER_SIZE = 100000;
	
	public static void main(String[] args) throws Exception {
		// Sort largedata.dat to sortedFile.dat
		sort("C:/Java/Test/largedata.dat", "C:/Java/Test/sortedFile.dat");
		// Display first 100 members in the sorted file
		displayFile("sortedFile.dat");
	}
	/** Sort data in the sourceFile into targetFile */
	public static void sort(String sourceFile, String targetFile) throws Exception {
		// Implement Phase 1: Create initial segments
		int numberOfSegments = initializeSegments(MAX_ARRAY_SIZE, sourceFile, "f1.dat");
		
		// Implement Phase 2: Merge Segments recursively
		merge(numberOfSegments, MAX_ARRAY_SIZE, "C:/Java/Test/f1.dat", "C:/Java/Test/f2.dat", "C:/Java/Test/f3.dat", targetFile);
	}
	
	/** Sort original file into sorted segments */
	private static int initializeSegments (int segmentSize, String originalFile, String f1) throws Exception {
		int[] list = new int[segmentSize];
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1)));
		
		int numberOfSegments = 0;
		while (input.available() > 0) {
			numberOfSegments++;
			int i = 0;
			for ( ; input.available() > 0 && i < segmentSize; i++) {
				list[i] = input.readInt();
			}
			
			// Sort an array list[0....i-1]
			java.util.Arrays.sort(list, 0, i);
			
			// Write the array to f1.dat
			for (int j = 0; j < i; j++) {
				output.writeInt(list[j]);
			}
		}
		
		output.close();
		input.close();
		
		return numberOfSegments;
	}
	
	private static void merge(int numberOfSegments, int segmentSize, String f1, String f2, String f3, String targetFile) throws Exception {
		if (numberOfSegments > 1) {
			mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
			merge((numberOfSegments + 1) / 2, segmentSize * 2, f3, f1, f2, targetFile);
		} else { // Rename f1 as the final sorted file
			File sortedFile = new File(targetFile);
			if (sortedFile.exists())
				sortedFile.delete();
			new File(f1).renameTo(sortedFile);
		}
	}
	
	private static void mergeOneStep(int numberOfSegments, int segmentSize, String f1, String f2, String f3) throws Exception {
		DataInputStream f1Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));
		DataOutputStream f2Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));
		
		// Copy half number of segments from f1.dat to f2.dat
		copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
		f2Output.close();
		
		// Merge remaining segments in f1 with segments in f2 into f3
		DataInputStream f2Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
		DataOutputStream f3Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));
		
		mergeSegments(numberOfSegments / 2, segmentSize, f1Input, f2Input, f3Output);
		f1Input.close();
		f2Input.close();
		f3Output.close();
	}
	
	// Copy half number of segments from f1.dat to f2.dat
	private static void copyHalfToF2(int numberOfSegments, int segmentSize, DataInputStream f1, DataOutputStream f2) throws Exception {
		for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++)
			f2.writeInt(f1.readInt());
	}
	
	private static void mergeSegments(int numberOfSegments, int segmentSize, DataInputStream f1,
			DataInputStream f2, DataOutputStream f3) throws Exception {
		for (int i = 0; i < numberOfSegments; i++) {
			mergeTwoSegments(segmentSize, f1, f2, f3);
		}
		
		// If f1 has one extra segment, copy it to f3
		while (f1.available() > 0) {
			f3.writeInt(f1.readInt());
		}
	}
	
	private static void mergeTwoSegments(int segmentSize, DataInputStream f1, DataInputStream f2,
			DataOutputStream f3) throws Exception {
		int intFromF1 = f1.readInt();
		int intFromF2 = f2.readInt();
		int f1Count = 1;
		int f2Count = 1;
		
		while (true) {
			if (intFromF1 < intFromF2) {
				f3.writeInt(intFromF1);
				if (f1.available() > 0 || f1Count++ >= segmentSize) {
					f3.writeInt(intFromF2);
					break;
				} else {
					intFromF1 = f1.readInt();
				}
			} else {
				f3.writeInt(intFromF2);
				if (f2.available() == 0 || f2Count++ >= segmentSize) {
					f3.writeInt(intFromF1);
					break;
				} else {
					intFromF2 = f2.readInt();
				}
			}
		}
		
		while (f1.available() > 0 && f1Count++ < segmentSize) {
			f3.writeInt(f1.readInt());
		}
		
		while (f2.available() > 0 && f2Count++ < segmentSize) {
			f3.writeInt(f2.readInt());
		}
	}
	
	/** Display first 100 members in the specified file */
	public static void displayFile(String filename) {
		try {
			DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
			for (int i = 0; i < 100; i++) {
				System.out.print(input.readInt() + " ");
			}
			input.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
