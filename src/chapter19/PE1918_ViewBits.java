package chapter19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 18. 11. 2014 2014 15:29:35 
 */
public class PE1918_ViewBits {
	
	
	public static String getBits(int value) {
		String result = "";
		
		int mask = 1;
		for (int i = 7; i >= 0; i--) {
			int temp = value >> i;
			int bit = temp & mask;
			result += bit;
		}
		
		return result;		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.print("Enter name of the file: ");
		Scanner input = new Scanner(System.in);
		File file = new File(input.nextLine());
		
		FileInputStream inputStream = new FileInputStream(file);
		
		int value;
		while ((value = inputStream.read()) != - 1) {
			System.out.println(getBits(value));
		}
		input.close();
		inputStream.close();
	}

}
