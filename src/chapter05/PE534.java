/**
 * 
 */
package chapter05;

import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE534 {

	/**
	 * 
	 */
	public PE534() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter year
		System.out.print("Enter full year (e.g., 2012): ");
		int year = input.nextInt();
		
		// Prompt the user to enter month
		System.out.print("Enter month as a number between 1 and 12: ");
		int month = input.nextInt();
		System.out.print("\n\n");
		
		printMonth(year, month);
		
	}
    // Print calendar for the given month of the year
	public static void printMonth(int year, int month) {
		printMonthTitle(year, month);
		printMonthBody(year, month);
	}
	
	// Print month title
	public static void printMonthTitle(int year, int month) {
		System.out.println("                   " + getMonthName(month) + " " + year);
		System.out.println("   _________________________________________");
		System.out.println("    Sun   Mon   Tue   Wed   Thu   Fri   Sat");
	}
	
	// Print month body
	public static void printMonthBody(int year, int month) {
		int lineCheck = 0;
		for (int k = 1; k <= getStartDay(year, month); k++) {
			System.out.print("      ");
			lineCheck++;
		}
		for (int i = 1; i <= getNumberOfDaysInMonth(year, month); i++) {
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
	
	// Get start day of 01.MM.YEAR
	public static int getStartDay(int year, int month) {
		return getDayOfTheWeek(year, month, 1);
	}
	
	public static int getDayOfTheWeek(int year, int month, int dayOfTheMonth) {
	    int century = year / 100;
	    int yearOfTheCentury = year % 100; 
	    
	    if (month == 1) {
	        month = 13;
	        year--; 
	      } else if (month == 2) {
	        month = 14;
	        year--;
	      } 

	      int dayOfTheWeek = (dayOfTheMonth + (26 * (month + 1)) / 10 + yearOfTheCentury + yearOfTheCentury / 4 + century / 4 + 5 * century) % 7;
	      return (dayOfTheWeek + 6) % 7;
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