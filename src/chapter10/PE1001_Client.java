/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 9. 7. 2014 2014 8:32:01 
 */
public class PE1001_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1001_Time test = new PE1001_Time();
		System.out.println("Current time: " + test.getHour() + ":" + test.getMinute() + ":" + test.getSecond());
		PE1001_Time test2 = new PE1001_Time(555550000);
		System.out.println("Elapsed time -> Hours: " + test2.getHour() + ", Minutes: " + test2.getMinute() + ", Seconds: " + test2.getSecond());
		PE1001_Time test3 = new PE1001_Time(13, 37, 59);
		System.out.println("Set time to: " + test3.getHour() + ":" + test3.getMinute() + ":" + test3.getSecond());
	}

}
