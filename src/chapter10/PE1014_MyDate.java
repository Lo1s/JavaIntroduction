/**
 * 
 */
package chapter10;
import java.util.*;
/**
 * @author jslapnicka
 * @Date & @Time 14. 7. 2014 2014 10:18:27 
 */
public class PE1014_MyDate {
	private int year;
	private int month;
	private int day;
	GregorianCalendar calendar = new GregorianCalendar();
	
	public PE1014_MyDate() {
		this.year = calendar.get(GregorianCalendar.YEAR);
		this.month = calendar.get(GregorianCalendar.MONTH);
		this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	public PE1014_MyDate(long elapsedTime) {
		GregorianCalendar cal2 = new GregorianCalendar();
		cal2.setTimeInMillis(elapsedTime);
		this.year = cal2.get(GregorianCalendar.YEAR);
		this.month = cal2.get(GregorianCalendar.MONTH);
		this.day = cal2.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	public PE1014_MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	
	
}
