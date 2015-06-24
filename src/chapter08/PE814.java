/**
 * 
 */
package chapter08;
import java.util.*;
/**
 * @author jslapnicka
 * @Date & @Time 12. 6. 2014 2014 13:44:04 
 */
public class PE814 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int[] numbers = new int[100000];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(101);
		}

		StopWatch stopwatch = new StopWatch();
		stopwatch.setStartTime(stopwatch.start());
		hdR.mtd.selectionSort(numbers);
		stopwatch.setEndTime(stopwatch.stop());

		System.out.println("Time elapsed during selection sort: " + stopwatch.getElapsedTime() + " ms.");
	}
}
class StopWatch {
	Date date = new Date();
	private long startTime = 0;
	private long endTime = 0;

	// Constructor
	public StopWatch() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	/**
	 * 
	 * Resets the stopwatches to the current time
	 */
	public long start() {
		return System.currentTimeMillis();
	}

	/**
	 * Sets the endTime to the current time
	 */
	public long stop() {
		return System.currentTimeMillis();
	}

	/**
	 * @return the elapsed time of the stopwatch
	 */
	public long getElapsedTime() {
		return (endTime - startTime);
	}

}
