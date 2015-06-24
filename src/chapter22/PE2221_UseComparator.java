/**
 * 
 */
package chapter22;

import java.util.Comparator;

import chapter15.L1501_GeometricObject;
import chapter15.L1502_Circle;
import chapter15.L1503_Rectangle;

/**
 * @author jslapnicka
 * @Date & @Time 16. 1. 2015 2015 9:06:07 
 */
public class PE2221_UseComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1501_GeometricObject[] list = {new L1502_Circle(5), new L1503_Rectangle(4, 5),
				new L1502_Circle(5.5), new L1503_Rectangle(2.4, 5), new L1502_Circle(0.5),
				new L1503_Rectangle(4, 65), new L1502_Circle(4.5), new L1503_Rectangle(4.4, 1),
				new L1502_Circle(6.5), new L1503_Rectangle(4, 5)};
		System.out.println("Before sort: " + toString(list));
		selectionSort(list, new L2204_GeometricObjectComparator());
		System.out.println("Sorted: " + toString(list));
	}

	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
		int tempIndex = 0;

		for (int i = 0; i < list.length; i++) {
			E min = list[i];
			for (int j = i; j < list.length; j++) {
				if (comparator.compare(list[j], min) == -1) {
					tempIndex = j;
					min = list[j];
				}
			}
			if (comparator.compare(min, list[i]) < 1) {
				list[tempIndex] = list[i];
				list[i] = min;
			}
		}
	}
	
	public static String toString(L1501_GeometricObject[] list) {
		String result = "";
		
		for (int i = 0; i < list.length; i++) {
			result += list[i].getArea() + ", ";
		}
		
		return result;
	}

}
