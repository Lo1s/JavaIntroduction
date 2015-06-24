/**
 * 
 */
package chapter11;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author jslapnicka
 * @Date & @Time 21. 7. 2014 2014 8:24:10 
 */
public class PE1109_LargestRowAndColumn {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the array size: ");
		Integer n = new Integer(input.nextInt());

		ArrayList<Integer> list = randomBinaryArrray(n);
		printArrayList(list, n);

		ArrayList<Integer> row = countRow(list, n);
		ArrayList<Integer> column = countColumn(list, n);
		int maxRow = 0;
		int indexRow = 0;
		int maxColumn = 0;
		int indexColumn = 0;
		for (int i = 0; i < n; i++) {
			if (row.get(i) > maxRow) {
				maxRow = row.get(i);
				indexRow = i;
			}
			if (column.get(i) > maxColumn) {
				maxColumn = column.get(i);
				indexColumn = i;
			}
		}
		
		System.out.print("Max row: " + indexRow 
				+ "\nMax column: " + indexColumn);
	}
	public static void printArrayList(ArrayList<Integer> list, Integer n) {
		for (int i = 0; i < n * n; i++) {
			System.out.print(list.get(i) + " ");
			if ((i + 1) % n == 0)
				System.out.println();
		}

	}
	public static ArrayList<Integer> randomBinaryArrray(Integer n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n * n; i++) {
			list.add(Integer.valueOf((int)(Math.random() * 2)));
		}
		return list;
	}
	public static ArrayList<Integer> countRow(ArrayList<Integer> list, Integer n) {
		ArrayList<Integer> rows = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < n * n; i++) {
			if (list.get(i) == 1)
				count++;
			if ((i + 1) % n == 0) {
				rows.add(count);
				count = 0;
			}
			
		}		
		return rows;
	}
	public static ArrayList<Integer> countColumn(ArrayList<Integer> list, Integer n) {
		ArrayList<Integer> columns = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n * n; j += n) {
				if (list.get(j) == 1)
					count++;
			}
			columns.add(count);
			count = 0;
		}	
		return columns;
	}
}
