
package chapter20;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 27. 11. 2014 2014 9:22:09 
 */
public class PE2029_NumberOfFiles {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a directory or a file: ");
		
		String directory = input.nextLine();
		int[] numbers = getNumberOfFiles(directory);
		System.out.println("Number of directories: " + numbers[0]);
		System.out.println("Number of files: " + numbers[1]);
		input.close();
	}
	
	public static int[] getNumberOfFiles(String directory) {
		int[] numbers = new int[2];
		ArrayList<File[]> fileList = new ArrayList<File[]>();
		File file = new File(directory);
		
		if(file.isDirectory()) {
			fileList.add(file.listFiles());
			
			for (int i = 0; i < fileList.size(); i++) {
				for (int j = 0; j < fileList.get(i).length; j++) {
					if (fileList.get(i)[j].isDirectory()) {
						fileList.add(fileList.get(i)[j].listFiles());
						numbers[0]++;
					} else {
						numbers[1]++;
					}
				}
			}
			return numbers;
		} else {
			numbers[0] = (file.isDirectory() ? numbers[0] += 1 : 0);
			numbers[1] = (file.isFile() ? numbers[1] += 1 : 0);
			return numbers;
		}
	}

}
