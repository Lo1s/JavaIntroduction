/**
 * 
 */
package chapter19;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 19. 11. 2014 2014 9:46:32 
 */
@SuppressWarnings("serial")
public class PE1919_ViewHex extends JFrame {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a file name: ");
		File file = new File(input.nextLine());
		int value;
		
		try {
			FileInputStream inputStream = new FileInputStream(file);
			while ((value = inputStream.read()) != -1) {
				System.out.println(Integer.toHexString(value));
			}
			inputStream.close();
		} catch (IOException ex) {
			System.out.println("File not found !");
		}

	}

}
