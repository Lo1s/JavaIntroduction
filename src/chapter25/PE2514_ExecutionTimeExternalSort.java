/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 2. 7. 2015 2015 10:59:30 
 */
public class PE2514_ExecutionTimeExternalSort {

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
				"File size", " | ",  "5,000,000", "10,000,000", "15,000,000", "20,000,000", "25,000,000", "30,000,000\n");
		System.out.printf("%102s" ,"----------------------------------------------------------------------------------------------------\n");
		System.out.printf("%5s%12s", "Time", " | ");
		for (int arraySize = 5000000; arraySize <= 30000000; arraySize += 5000000) {
			try {
			long startTime = System.currentTimeMillis();
			L2512_SortLargeFile.sort("C:/Java/Test/largedata.dat", "C:Java/Test/sortedfile.dat");
			long endTime = System.currentTimeMillis();
			System.out.printf("%8d%7s", (endTime - startTime), "");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
