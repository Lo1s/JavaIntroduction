/**
 * 
 */
package chapter22;

import java.io.File;
import java.util.Stack;

/**
 * @author jslapnicka
 * @Date & @Time 16. 1. 2015 2015 8:58:57 
 */
public class PE2220_DirectorySize {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File test = new File("C:/Java/");
		System.out.println(test.getAbsolutePath() + " size is: " + getSize(test) + " bytes");
	}
	
	public static long getSize(File directory) {
		long size = 0;
		Stack<File> directoryStack = new Stack<File>();
		directoryStack.add(directory);
		
		while (!directoryStack.isEmpty()) {
			File temp = directoryStack.pop();
			
			if (temp.isFile())
				size += temp.length();
			else {
				File[] fileList = temp.listFiles();
				for (int i = 0; i < fileList.length; i++) {
					directoryStack.add(fileList[i]);
				}
			}
	
		}
		
		
		return size;
	}

}
