/**
 * 
 */
package chapter15;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 15:42:24 
 */
public class PE1506_DisplayCalendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("Usage: java PE1506_DisplayCalendar month year");
			System.exit(1);
		}		
		// Getting the calendar information
		int month = Integer.valueOf(args[0]) + 1;
		int year = Integer.valueOf(args[1]);		
		GregorianCalendar calendar = new GregorianCalendar(year, month, 0);
		int firstDay = firstDay();
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		printMonth(year, month, firstDay, lastDay);

	}
	// Print calendar for the given month of the year
	public static void printMonth(int year, int month, int firstDay, int lastDay) {
		printMonthTitle(year, month);
		printMonthBody(year, month, firstDay, lastDay);
	}

	// Print month title
	public static void printMonthTitle(int year, int month) {
		System.out.println("                   " + getMonthName(month) + " " + year);
		System.out.println("   _________________________________________");
		System.out.println("    Sun   Mon   Tue   Wed   Thu   Fri   Sat");
	}

	// Print month body
	public static void printMonthBody(int year, int month, int firstDay, int lastDay) {
		int lineCheck = 0;
		for (int k = 1; k <= firstDay; k++) {
			System.out.print("      ");
			lineCheck++;
		}
		for (int i = 1; i <= lastDay; i++) {
			System.out.printf("%6d", i);
			lineCheck ++;
			if (lineCheck == 7) {
				System.out.println();
				lineCheck = 0;
			}					
		}	

	}

	// Get month name
	public static String getMonthName(int month) {
		String monthName = "";

		switch (month) {
		case 1: monthName = "January"; break;
		case 2: monthName = "February"; break;
		case 3: monthName = "March"; break;
		case 4: monthName = "April"; break;
		case 5: monthName = "May"; break;
		case 6: monthName = "June"; break;
		case 7: monthName = "July"; break;
		case 8: monthName = "August"; break;
		case 9: monthName = "September"; break;
		case 10: monthName = "October"; break;
		case 11: monthName = "November"; break;
		case 12: monthName = "December"; break;
		}
		return monthName;
	}
	
	public static int firstDay() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}
}
