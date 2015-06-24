/**
 * 
 */
package chapter20;

/**
 * @author jslapnicka
 * @Date & @Time 20. 11. 2014 2014 14:29:44 
 */
public class L2005_RecursiveSelectionSort {

	public static void sort(double[] list) {
		sort(list, 0, list.length - 1);
	}
	
	public static void sort(double[] list, int low, int high) {
		if (low < high) {
			// Find the smallest number and its index in list[low....high]
			int indexOfMin = low;
			double min = list[low];
			for (int i = low + 1; i <= high; i++) {
				if (list[i] < min) {
					indexOfMin = i;
					min = list[i];
				}
			}
			
			// Swap the smallest in list[low .. high] with list[low]
			list[indexOfMin] = list[low];
			list[low] = min;
			
			// Sort the remaining list[low+1 .. high]
			sort(list, low + 1, high);
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] test = new double[] {1, 5, 20, 3, 2};
		sort(test);
		
	}

}
