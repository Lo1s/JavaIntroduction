/**
 * 
 */
package chapter14;

import java.io.File;

/**
 * @author jslapnicka
 * @Date & @Time 28. 8. 2014 2014 13:19:20 
 */
public class PE1428_RenameFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("C:/Java/Test");
		File[] fileList = file.listFiles();

		// 0123456789
		// Exercise10_10
		for (int i = 0; i < fileList.length; i++) {
			StringBuilder catchName = new StringBuilder(fileList[i].getName());
			if (catchName.length() < 13) {
				String numbers = catchName.substring(8, catchName.length());
				String[] separateNumbers = numbers.split("_");

				if (separateNumbers[0].length() == 1)
					separateNumbers[0] = "0" + separateNumbers[0];
				if (separateNumbers[1].length() == 1)
					separateNumbers[1] = "0" + separateNumbers[1];
				String finalName = "Exercise" + separateNumbers[0] + "_" + separateNumbers[1];
				File finalFile = new File("C:/Java/Test/" + finalName);
				fileList[i].renameTo(finalFile);
			}
		}
		System.out.println("Files had been renamed !");
	}

}
