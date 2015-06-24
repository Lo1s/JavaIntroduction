/**
 * 
 */
package chapter05;

import javax.swing.JOptionPane;

/**
 * @author Jura
 *
 */
public class PE524 {

	/**
	 * 
	 */
	public PE524() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long totalMiliSeconds = System.currentTimeMillis();
		long totalSeconds = totalMiliSeconds / 1000;
		long currentSecond = totalSeconds % 60;
		long totalMinutes = totalSeconds / 60;  
		long currentMinute = totalMinutes % 60;
		long totalHours = totalMinutes / 60;
		long currentHour = (totalHours % 24) + 2;

		// Obtaining total number of days
		int totalDays = (int)totalHours / 24;
		if (currentHour > 0)
			totalDays++;

		// Obtaining a year
		int currentYear = 2000;
		do {
			currentYear++;
		} while (getTotalNumberOfDaysInYears(currentYear) < totalDays);


		// Obtaining a month
		int totalNumberOfDaysInTheYear = totalDays - getTotalNumberOfDaysInYears(currentYear -1);
		int currentMonth = 0;
		do {
			currentMonth++;
		} while (PE524.getTotalDaysInMonth(currentYear, currentMonth) < totalNumberOfDaysInTheYear);

		// Obtaining a day
		int currentDay = totalNumberOfDaysInTheYear - PE524.getTotalDaysInMonth(currentYear, currentMonth - 1);

		// Display results
		String output = "Current date and time is " +
				currentMonth + "/" + currentDay + "/" + currentYear + " " +
				currentHour + ":" + currentMinute + ":" + currentSecond + " GMT";

		JOptionPane.showMessageDialog(null, output);

	}
	public static int getTotalNumberOfDaysInYears(int year) {
		int total = 0;

		for (int i = 1970; i <= year; i++) {
			if(hdR.mtd.isLeapYear(i))
				total += 366;
			else
				total += 365;
		}
		return total;
	}
	
	public static int getTotalDaysInMonth(int year, int month) {
		int total = 0;
		// Obtain number of days since 1 Jan
		for (int i = 1; i <= month; i++) {
			total = total + hdR.mtd.getNumberOfDaysInMonth(year, i);
		}
		return total;
	}

}
