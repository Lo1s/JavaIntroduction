/**
 * 
 */
package chapter14;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * @author jslapnicka
 * @Date & @Time 19. 8. 2014 2014 14:50:07 
 */
public class L1416_ReadFileUsingFileChooser {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// Get the selected file
			File file = fileChooser.getSelectedFile();
			
			// Create Scanner for the selected file
			Scanner input = new Scanner(file);
			
			// Read text from the file
			while (input.hasNext()) {
				System.out.println(input.nextLine());
			}
			
			input.close();
		} else {
			System.out.println("No file selected !");
		}
	}

}
