/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 9. 7. 2014 2014 8:32:19 
 */
public class PE1001_Time {
	private int hour;
	private int minute;
	private int second;
	
	// No-arg constructor
	PE1001_Time() {
		second = (int)(System.currentTimeMillis() / 1000 % 60);
		minute = (int)(System.currentTimeMillis() / 1000 / 60 % 60);
		hour = (int)(System.currentTimeMillis() / 1000 / 60 / 60 % 24) + 2;
	}
	// Constructor with a specified elapsed time
	PE1001_Time(long elapsedTime) {
		this.setTime(elapsedTime);
	}
	// Constructor with specified hour, minute, second
	PE1001_Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}
	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}
	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}
	
	public void setTime(long elapsedTime) {
		long time = elapsedTime;
		second = (int)(time / 1000);
		minute = (int)(time / 1000 / 60);
		hour = (int)(time / 1000 / 60 / 60);
	}
}
