/**
 * 
 */
package chapter14;

import java.io.File;
import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 19. 8. 2014 2014 9:49:50 
 */
public class L1412_TestFileClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.io.File file = new File("C:/Java/site/image/us.gif");
		System.out.println("Does it exists ? " + file.exists());
		System.out.println("The file has " + file.length() + " bytes");
		System.out.println("Can it be read ? " + file.canRead());
		System.out.println("Can it be written ? " + file.canWrite());
		System.out.println("Is it a directory ? " + file.isDirectory());
		System.out.println("Is it a file ? " + file.isFile());
		System.out.println("Is it absolute ? " + file.isAbsolute());
		System.out.println("Is it hidden ? " + file.isHidden());
		System.out.println("Absolute path is: " + file.getAbsolutePath());
		System.out.println("Last modified on: " + new Date(file.lastModified()));
	}

}
