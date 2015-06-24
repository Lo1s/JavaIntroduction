package chapter03;
import java.util.Scanner;

public class PE330 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

    // Creating scanner to prompt the user for a timezone
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter your timezone to GMT: ");
    byte timeZone = input.nextByte();
    
    // Obtain the total milliseconds since midnight, Jan 1, 1970
    long totalMilliseconds = System.currentTimeMillis();

    // Obtain the total seconds since midnight, Jan 1, 1970
    long totalSeconds = totalMilliseconds / 1000;

    // Compute the current second in the minute in the hour
    long currentSecond = totalSeconds % 60;

    // Obtain the total minutes
    long totalMinutes = totalSeconds / 60;

    // Compute the current minute in the hour
    long currentMinute = totalMinutes % 60;

    // Obtain the total hours
    long totalHours = totalMinutes / 60;

    // Compute the current hour
    long currentHour = totalHours % 24;  
    String AMPM = "";

    if (currentHour > 12) {
      currentHour = currentHour / 2;
      AMPM = "PM";
    } else {
      AMPM = "AM";
    }  

    String hourPrefix = "";
    String conversionPrefix = "";
    String minutePrefix = "";
    String secondPrefix = "";

    long timeConversion = (totalHours + timeZone) % 24;
    
    if (timeConversion > 12) {
      timeConversion = timeConversion / 2;
    }

    if (currentHour < 10) { 
      hourPrefix = "0";
    } else if (timeConversion < 10) {
      conversionPrefix = "0";
    } else if (currentMinute < 10) {
      minutePrefix = "0";
    } else if (currentSecond < 10) {
      secondPrefix = "0";
    } 


    if (timeZone <= 14 && timeZone >= -11) {
    System.out.println("\t" + "Current time is " + hourPrefix + currentHour + ":"
      + minutePrefix + currentMinute + ":" + secondPrefix + currentSecond + " " + AMPM + " GMT \n" +
      "\t" + "Time in your timezone GMT " + timeZone + " is: " + conversionPrefix + timeConversion + ":" + minutePrefix + currentMinute + ":" + secondPrefix + currentSecond + " " + AMPM);
    } else {
    System.out.println("\t" + 	"You have entered a wrong timezone !" + "\n" +
    "\t" + "Please enter a timezone between -11 to +14");
    }    
  }
}
