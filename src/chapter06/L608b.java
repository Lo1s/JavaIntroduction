package chapter06;

public class L608b {

	public L608b() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] test = {1, 9, 4.5, 6.6, 5.7, -4.5};

		hdR.mtd.displayArray(test, 10);
		System.out.println("\n");
		hdR.mtd.displayArray(selectionSort(test), 10);

	}

	public static double[] selectionSort(double[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			double currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		return list;
	}
	
}
