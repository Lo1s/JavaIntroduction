/**
 * 
 */
package chapter08;
import java.util.*;
/**
 * @author jslapnicka
 * @Date & @Time 10. 6. 2014 2014 13:05:55 
 */
public class PE805 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar calendar = new GregorianCalendar();
		// Display the current year
		System.out.print("The current year is ");
		System.out.println(calendar.get(GregorianCalendar.YEAR));
		
		// Display the current month
		System.out.print("The current month is ");
		System.out.println(calendar.get(GregorianCalendar.MONTH));
		
		// Display the current day
		System.out.print("The current day is ");
		System.out.println(calendar.get(GregorianCalendar.DAY_OF_MONTH) + "\n");
		
		// Year, month and day by setTimeInMillis = 1234567898765L
		GregorianCalendar calendar2 = new GregorianCalendar();
		calendar2.setTimeInMillis(1234567898765L);
		// Year
		System.out.println("Year: " + calendar2.get(GregorianCalendar.YEAR));
		// Month
		System.out.println("Month: " + calendar2.get(GregorianCalendar.MONTH));
		// Day
		System.out.println("Day: " + calendar2.get(GregorianCalendar.DAY_OF_MONTH));
	}

}
