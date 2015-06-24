/**
 * 
 */
package chapter25;

import java.util.Comparator;

/**
 * @author jslapnicka
 * @Date & @Time 19. 6. 2015 2015 11:11:13 
 */
public class PE2506_CheckOrder<E extends Comparable<E>> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intList = new int[]{5, 2, 2, 2, 1, 0};
		System.out.println("Ordered ? " + ordered(intList));
		System.out.println("Ordered in ascending order ? " + ordered(intList, true));
		System.out.println("Ordered in descending order ? " + ordered(intList, false));
		double[] doubleList = new double[]{0.5, 2.2, 2.3, 3.6, 4.1, 5.2};
		System.out.println("Ordered ? (double) " + ordered(doubleList));
		System.out.println("Ordered in ascending order ? (double) " + ordered(doubleList, true));
		System.out.println("Ordered in descending order ? (double) " + ordered(doubleList, false));
		String[] names = new String[]{"Zeus", "Polymer", "Kate", "John", "Cat"}; 
		String[] names2 = new String[]{"Cat", "John", "Kate", "Polymer", "Zeus"};
		System.out.println("Ordered ? (Generic - comparable) " + ordered(names));
		System.out.println("Ordered ? (Generic - comparable) in ascending order ? " + ordered(names2, true));
		System.out.println("Ordered ? (Generic - comparable) in descending order ? " + ordered(names, false));
		System.out.println("Ordered ? (Generic - comparator) " + ordered(names, new PE2501_Comparator<>()));
		System.out.println("Ordered ? (Generic - comparator) in ascending order ? " + ordered(names2, new PE2501_Comparator<>(), true));
		System.out.println("Ordered ? (Generic - comparator) in descending order ? " + ordered(names, new PE2501_Comparator<>(), false));
	}
	
	public static boolean ordered(int[] list) {
		boolean ordered = false;
		// Descending ?
		if (list[0] > list[1]) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] < list[i + 1])
					return false;
			}
			return true;
		}
		// Ascending ?
		else if (list[0] < list[1]) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] > list[i + 1])
					return false;
			}
			return true;
		}
		return ordered;
	}
	
	public static boolean ordered(int[] list, boolean ascending) {
		boolean ordered = false;
		// Descending ?
		if (list[0] > list[1] && !ascending) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] < list[i + 1])
					return false;
			}
			return true;
		}
		// Ascending ?
		else if (list[0] < list[1] && ascending) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] > list[i + 1])
					return false;
			}
			return true;
		}
		return ordered;
	}
	
	public static boolean ordered(double[] list) {
		boolean ordered = false;
		// Descending ?
		if (list[0] > list[1]) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] < list[i + 1])
					return false;
			}
			return true;
		}
		// Ascending ?
		else if (list[0] < list[1]) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] > list[i + 1])
					return false;
			}
			return true;
		}
		return ordered;
	}
	
	public static boolean ordered(double[] list, boolean ascending) {
		boolean ordered = false;
		// Descending ?
		if (list[0] > list[1] && !ascending) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] < list[i + 1])
					return false;
			}
			return true;
		}
		// Ascending ?
		else if (list[0] < list[1] && ascending) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] > list[i + 1])
					return false;
			}
			return true;
		}
		return ordered;
	}
	
	public static <E extends Comparable<E>> boolean ordered (E[] list) {
		boolean ordered = false;
		// Descending ?
		if (list[0].compareTo(list[1]) > 0) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i].compareTo(list[i + 1]) < 0)
					return false;
			}
			return true;
		}
		// Ascending ?
		else if (list[0].compareTo(list[1]) < 0) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i].compareTo(list[i + 1]) > 0)
					return false;
			}
			return true;
		}
		return ordered;
	}
	
	public static <E extends Comparable<E>> boolean ordered (E[] list, boolean ascending) {
		boolean ordered = false;
		// Descending ?
		if (list[0].compareTo(list[1]) > 0 && !ascending) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i].compareTo(list[i + 1]) < 0)
					return false;
			}
			return true;
		}
		// Ascending ?
		else if (list[0].compareTo(list[1]) < 0 && ascending) {
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i].compareTo(list[i + 1]) > 0)
					return false;
			}
			return true;
		}
		return ordered;
	}
	
	public static <E> boolean ordered(E[] list, Comparator<? super E> comparator) {
		boolean ordered = false;
		// Descending ?
		if (comparator.compare(list[0], list[1]) > 0) {
			for (int i = 0; i < list.length - 1; i++) {
				if (comparator.compare(list[i], list[i + 1]) < 0)
					return false;
			}
			return true;
		}
		// Ascending ?
		else if (comparator.compare(list[0], list[1]) < 0) {
			for (int i = 0; i < list.length - 1; i++) {
				if (comparator.compare(list[i], list[i + 1]) > 0)
					return false;
			}
			return true;
		}
		return ordered;
	}
	
	public static <E> boolean ordered(E[] list, Comparator<? super E> comparator, boolean ascending) {
		boolean ordered = false;
		// Descending ?
		if (comparator.compare(list[0], list[1]) > 0 && !ascending) {
			for (int i = 0; i < list.length - 1; i++) {
				if (comparator.compare(list[i], list[i + 1]) < 0)
					return false;
			}
			return true;
		}
		// Ascending ?
		else if (comparator.compare(list[0], list[1]) < 0 && ascending) {
			for (int i = 0; i < list.length - 1; i++) {
				if (comparator.compare(list[i], list[i + 1]) > 0)
					return false;
			}
			return true;
		}
		return ordered;
	}

}
