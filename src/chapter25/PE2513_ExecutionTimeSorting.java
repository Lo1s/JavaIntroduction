/**
 * 
 */
package chapter25;

import chapter06.L608;

/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2015 2015 10:47:11 
 */
public class PE2513_ExecutionTimeSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printTable();
	}
	
	public static void printTable() {
		//Header
		System.out.printf("%10s%7s%10s%15s%15s%15s%15s%15s", 
				"Array", " | ",  "Selection", "Bubble", "Merge", "Quick", "Heap", "Radix\n");
		System.out.printf("%9s%8s%5s%18s%16s%15s%16s%14s", 
				"size", " | ", "Sort", "Sort", "Sort", "Sort", "Sort", "Sort\n");
		System.out.printf("%101s" ,"------------------------------------------------------------------------------------------------\n");
		for (int arraySize = 50000; arraySize <= 300000; arraySize += 50000) {
			System.out.printf("%10d%7s", arraySize, " | ");
			// Selection sort
			double[] arrayDouble = initializeArray(arraySize);
			Integer[] arrayInteger = toInteger(arrayDouble);
			int[] arrayInt = toInt(arrayDouble);
			long startTime = System.currentTimeMillis();
			L608.selectionSort(arrayDouble);
			long endTime = System.currentTimeMillis();
			System.out.printf("%5d%4s", (endTime - startTime), "ms");
			// Bubble sort
			startTime = System.currentTimeMillis();
			L2504_BubbleSort.bubbleSort(arrayInt);
			endTime = System.currentTimeMillis();
			System.out.printf("%13d%4s", (endTime - startTime), "ms");
			// Merge sort
			startTime = System.currentTimeMillis();
			L2506_MergeSort.mergeSort(arrayInt);
			endTime = System.currentTimeMillis();
			System.out.printf("%11d%4s", (endTime - startTime), "ms");
			// Quick sort
			startTime = System.currentTimeMillis();
			PE2504_ImprovedQuickSort.quickSort(arrayInteger);
			endTime = System.currentTimeMillis();
			System.out.printf("%12d%4s", (endTime - startTime), "ms");
			// Heap sort
			startTime = System.currentTimeMillis();
			L2510_HeapSort.heapSort(arrayInteger);
			endTime = System.currentTimeMillis();
			System.out.printf("%11d%4s", (endTime - startTime), "ms");
			// Radix sort
			startTime = System.currentTimeMillis();
			PE2512_RadixSort.radixSort(arrayInt, 3);
			endTime = System.currentTimeMillis();
			System.out.printf("%9d%4s", (endTime - startTime), "ms\n");
		}		
	}
	
	public static double[] initializeArray(int arraySize) {
		double[] array = new double[arraySize];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 100);
		}
		return array;
	}
	
	public static Integer[] toInteger(double[] arrayDouble) {
		Integer[] array = new Integer[arrayDouble.length];
		for (int i = 0; i < arrayDouble.length; i++) {
			array[i] = (int)arrayDouble[i];
		}
		return array;
	}
	
	public static int[] toInt(double[] arrayDouble) {
		int[] array = new int[arrayDouble.length];
		for (int i = 0; i < arrayDouble.length; i++) {
			array[i] = (int)arrayDouble[i];
		}
		return array;
	}
	
	public static void displayArray(int[] array, int numberPerLine) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1)
				System.out.print(", ");
			if (i % numberPerLine == 0)
				System.out.println();
			
		}
		System.out.println();
	}

}
