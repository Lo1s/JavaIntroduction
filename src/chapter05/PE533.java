/**
 * 
 */
package chapter05;

/**
 * @author jslapnicka
 *
 */
public class PE533 {

	/**
	 * 
	 */
	public PE533() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time = System.currentTimeMillis();
		long seconds = time / 1000;
		long currentSeconds = seconds % 60;
		long minutes = seconds / 60;
		long currentMinutes = minutes % 60;
		long hours = minutes / 60;
		long currentHours = (hours % 24) + 2;
		String timeString = "";
		System.out.print("Current time and date is: ");
		
		// Time
		if (currentHours < 9)
			timeString += "0" + currentHours + ":";
		else
			timeString += currentHours + ":";
		if (currentMinutes < 9)
			timeString += "0" + currentMinutes + ":";
		else
			timeString += currentMinutes + ":";
		if (currentSeconds < 9)
			timeString += "0" + currentSeconds;
		else 
			timeString += currentSeconds;
		
		// Date (Day, Month, Year)
		
		// Year
		int days = (int)hours / 24;
		int countDays = 365;
		int lastYear = 0;
		for (int year = 1970; countDays <= days; year++) {
			if (hdR.mtd.isLeapYear(year)) {
				countDays += 366;
			} else {
				countDays += 365;	
			}
			lastYear = year;
		}
		
		int daysInCurrentYear = days - (countDays - 366);
		
		// Month
		int currentMonth = 0;
		int countDaysInMonth = 0;
		for (int month = 1; month < 12; month++) {
			countDaysInMonth += hdR.mtd.getNumberOfDaysInMonth(lastYear, month);
			if (daysInCurrentYear > countDaysInMonth)
				currentMonth = month + 1;
		}
		
		String monthName = "";
		switch(currentMonth) {
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
		
		// Day
		
		int currentDay = 0;
		for (int month = 1; month < currentMonth; month++) {
			currentDay += hdR.mtd.getNumberOfDaysInMonth(lastYear + 1, month);
		}
		
		System.out.println(monthName + " " + (daysInCurrentYear - currentDay) + ", " + (lastYear + 1) + " " + timeString);

	}

}
