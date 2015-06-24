package chapter04;
/**
 * 
 */

/**
 * @author jslapnicka
 *
 */
import java.util.Scanner;
public class PE428 {

	/**
	 * 
	 */
	public PE428() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// User input
		Scanner input = new Scanner (System.in);
		System.out.print("Enter an year: ");
		int year = input.nextInt();
		System.out.print("Enter the first day of the year: ");
		int firstDayInput = input.nextInt();
		
		// Leap year check
		boolean isLeapYear = false;
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			isLeapYear = true;
				
		// Number of days for each month
		int month = 1;
		int daysInMonth = 0;
		String monthName = "";
		
		while (month <= 12) {
			if (month == 1) {
				monthName = "January";
				daysInMonth = 31;
			} else if (month == 2) {
				monthName = "February";
				if (isLeapYear)
					daysInMonth = 29;
				else
					daysInMonth = 28;
			} else if (month == 3) {
				monthName = "March";
				daysInMonth = 31;
			} else if (month == 4) {
				monthName = "April";
				daysInMonth = 30;
			} else if (month == 5) {
				monthName = "May";
				daysInMonth = 31;
			} else if (month == 6) {
				monthName = "June";
				daysInMonth = 30;
			} else if (month == 7) {
				monthName = "July";
				daysInMonth = 31;
			} else if (month == 8) {
				monthName = "August";
				daysInMonth = 31;
			} else if (month == 9) {
				monthName = "September";
				daysInMonth = 30;
			} else if (month == 10) {
				monthName = "October";
				daysInMonth = 31;
			} else if (month == 11) {
				monthName = "November";
				daysInMonth = 30;
			} else if (month == 12) {
				monthName = "December";
				daysInMonth = 31;
			}
			String day = "";
			switch (firstDayInput) {
			case 0: day = "Sunday"; break;
			case 1: day = "Monday"; break;
			case 2: day = "Tuesday"; break;
			case 3: day = "Wednesday"; break;
			case 4: day = "Thursday"; break;
			case 5: day = "Friday"; break;
			case 6: day = "Saturday"; break;
			}
			
			firstDayInput = (firstDayInput + daysInMonth) % 7;
			System.out.println(monthName + " 1, " + year + " is " + day);
			month++;
					
		}

	}

}
