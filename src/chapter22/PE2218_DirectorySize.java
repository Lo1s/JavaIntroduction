/**
 * 
 */
package chapter22;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jslapnicka
 * @Date & @Time 14. 1. 2015 2015 7:43:56 
 */
public class PE2218_DirectorySize {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File test = new File("C:/Java/");
		System.out.println(test.getAbsolutePath() + " size is: " + getSize(test) + " bytes");
	}
	
	public static long getSize(File directory) {
		long size = 0;
		Queue<File> directoryQueue = new LinkedList<File>();
		directoryQueue.add(directory);
		
		while (!directoryQueue.isEmpty()) {
			File temp = directoryQueue.poll();
			
			if (temp.isFile())
				size += temp.length();
			else {
				File[] fileList = temp.listFiles();
				for (int i = 0; i < fileList.length; i++) {
					directoryQueue.add(fileList[i]);
				}
			}
	
		}
		
		
		return size;
	}

}
