/**
 * 
 */
package chapter08;
import javax.swing.*;


/**
 * @author jslapnicka
 * @Date & @Time 10. 6. 2014 2014 13:24:46 
 */
public class PE806 {
	static String calendar = "";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Prompt the user to enter year
		String yearInput = JOptionPane.showInputDialog(null, "Enter full year (e.g., 2012)");
		int year = Integer.parseInt(yearInput);

		// Prompt the user to enter month
		String monthInput = JOptionPane.showInputDialog(null, "Enter month as a number between 1 and 12: ");
		int month = Integer.parseInt(monthInput);
		System.out.print("\n\n");
		calendar = printMonth(year, month, calendar);
		
		JOptionPane.showMessageDialog(null, calendar);
		
	}
	// Print calendar for the given month of the year
	public static String printMonth(int year, int month, String calendar) {
		calendar += printMonthTitle(year, month, calendar);
		calendar =printMonthBody(year, month, calendar);
		return calendar;
	}

	// Print month title
	public static String printMonthTitle(int year, int month, String calendar) {
		calendar += "                    " + getMonthName(month) + " " + year + "\n";
		calendar += "    _________________________________________\n";
		calendar += "    Sun   Mon   Tue   Wed   Thu   Fri   Sat\n";
		return calendar;
	}

	// Print month body
	public static String printMonthBody(int year, int month, String calendar) {
		int lineCheck = 0;
		for (int k = 1; k <= getStartDay(year, month); k++) {
			if (k < 10)
				calendar += "      ";
			lineCheck++;
		}
		for (int i = 1; i <= getNumberOfDaysInMonth(year, month); i++) {
			if (i < 10)
			calendar += "     " + i;
			else
				calendar += "    " + i;
			lineCheck ++;
			if (lineCheck == 7) {
				calendar += "\n";
				lineCheck = 0;
			}					
		}
		return calendar;
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

	// Get start day of 01.MM.YEAR
	public static int getStartDay(int year, int month) {
		final int START_DAY_FOR_JAN_1_1800 = 3;

		// Get total number of days from 01.01.1800 to 01.MM.YEAR 
		int totalNumberOfDays = getNumberOfDays(year, month);

		// Return the start day of 01.MM.YEAR
		return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7; 
	}

	// Get total number of days
	public static int getNumberOfDays(int year, int month) {
		int total = 0;

		// Get total number of day since year 1800 to 1.1.YYYY
		for (int i = 1800; i < year; i++)
			if (isLeapYear(i))
				total = total + 366;
			else 
				total = total + 365;

		// Add days from 1.1. January to the month entered by user
		for (int i = 1; i < month; i++)
			total = total + getNumberOfDaysInMonth(year, i);

		return total; // dummy value
	}

	// Get total number of days in month
	public static int getNumberOfDaysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) 
			return 31;
		if (month == 4 || month == 6 || month == 9 || month == 11)			
			return 30;
		if (month == 2)
			return isLeapYear(year) ? 29 : 28;
		else
			return 0; // month is incorrect
	}

	public static boolean isLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}

}
