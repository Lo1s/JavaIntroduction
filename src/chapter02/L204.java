package chapter02;
import java.util.Scanner;

public class L204 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  
  System.out.print("Enter the seconds for conversion: ");
  int seconds = input.nextInt();
  
  if(seconds < 3600) {

    int minutes = seconds / 60;
    int remainingSeconds = seconds % 60;

    System.out.println(seconds + " seconds is " + minutes + " minutes and " + remainingSeconds + " seconds !");

    } else if(seconds >= 3600 && seconds < 7200) {

    int minutes = seconds / 60;
    int remainingSeconds = seconds % 60;    
    int hour = minutes / 60;
    int remainingMinutes = minutes % 60;

    System.out.println(seconds + " seconds is " + hour + " hour " + remainingMinutes + " minutes and " + remainingSeconds + " seconds !");
    
    } else if(seconds >= 7200) {

    int minutes = seconds / 60;
    int remainingSeconds = seconds % 60;    
    int hour = minutes / 60;
    int remainingMinutes = minutes % 60;

    System.out.println(seconds + " seconds is " + hour + " hours " + remainingMinutes + " minutes and " + remainingSeconds + " seconds !");

    }
  }
}