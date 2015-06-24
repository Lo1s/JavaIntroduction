/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE525 {

	/**
	 * 
	 */
	public PE525() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number for conversion to time: ");
		long number = input.nextLong();
		
		System.out.print("The converted result: " + PE525.convertMillis(number));

	}
	// Converts milliseconds to hours, minutes and seconds 
	public static String convertMillis(long millis) {
		long totalMilliSeconds = millis;
		long totalSeconds = totalMilliSeconds / 1000;
		long currentSecond = totalSeconds % 60;
		long totalMinutes = totalSeconds / 60;  
		long currentMinute = totalMinutes % 60;
		long totalHours = totalMinutes / 60;

		
		String seconds = "" + currentSecond;
		String minutes = "" + currentMinute;
		String hours = "" + totalHours;
		
		String output = hours + ":" + minutes + ":" + seconds;
		return output;
	}

}
