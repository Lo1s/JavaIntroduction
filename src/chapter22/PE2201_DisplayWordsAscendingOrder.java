/**
 * 
 */
package chapter22;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 11. 12. 2014 2014 11:01:58 
 */
public class PE2201_DisplayWordsAscendingOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: java PE2201_DisplayWordsAscendingOrder filename");
			System.exit(1);
		}

		File filename = new File(args[0]);
		Scanner input = new Scanner(filename);
		ArrayList<String> stringList = new ArrayList<String>();
		while (input.hasNext())
			stringList.add(input.next());

		Collections.sort(stringList);
		print(stringList);
		input.close();
	}

	/** No reason to complicate like that, but just for practicing purposes */
	public static <E> void print(ArrayList<E> list) {
		Iterator<E> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

	}
}
